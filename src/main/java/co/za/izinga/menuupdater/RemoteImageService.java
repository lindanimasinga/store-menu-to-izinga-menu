package co.za.izinga.menuupdater;

import com.luciad.imageio.webp.WebPReadParam;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class RemoteImageService {

    private static final Logger log = LoggerFactory.getLogger(RemoteImageService.class);

    static String getFileNameFromUrl(String url) {
        String[] parts = url.split("/");
        String filenameWithParams = parts[parts.length - 1];
        return filenameWithParams.split("\\?")[0];  // Remove query parameters if any
    }

    static BufferedImage downloadImage(String imageUrl) throws IOException {
        Request request = new Request.Builder()
                .url(imageUrl)
                .get()
                .addHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                .addHeader("accept-language", "en-US,en;q=0.9")
                .addHeader("cache-control", "no-cache")
                .addHeader("cookie", "anonymous-consents=%5B%5D; cookie-notification=NOT_ACCEPTED; JSESSIONID=Y29-901737bc-808d-4159-a50c-6a189989cf3c; _gcl_au=1.1.1553939616.1724095554; cookie-promo-alerts-popup=true; webp_supported=true; _fbp=fb.2.1724095560869.754078924869993292; _ce.irv=new; cebs=1; _ce.s=v~4aef3de6948504a2349677214298a9899ec21957~lcw~1724095561685~lva~1724095561685~vpv~0~lcw~1724095561687; _tt_enable_cookie=1; _ttp=-ZDtcBxGBLLFcOe56EMjV-GNybl; _hjSessionUser_502443=eyJpZCI6ImZiMzYxYmY2LTMxYjUtNTUwZS05ZDZiLWFjYzViZmE1ZmVjMyIsImNyZWF0ZWQiOjE3MjQwOTU1NjEyNzEsImV4aXN0aW5nIjp0cnVlfQ==; _gid=GA1.3.1840333841.1724188401; shopriteZA-preferredStore=54229; _ga_P4HXTRVEMT=deleted; AWSALB=GIwFc2/Ykc6+Kb9nZCN/utn1HejXuUzNm/ePp7aQmr9V1nlwJAHJKCJZk3GH161OD2FTaqdqzBYNXyTUtgteA4uaJnXPY/ZrPDw+A6O2gBzKO8I0jxBglv3nVDD9; AWSALBCORS=GIwFc2/Ykc6+Kb9nZCN/utn1HejXuUzNm/ePp7aQmr9V1nlwJAHJKCJZk3GH161OD2FTaqdqzBYNXyTUtgteA4uaJnXPY/ZrPDw+A6O2gBzKO8I0jxBglv3nVDD9; __gads=ID=e67dffd9f2073abe:T=1724095558:RT=1724358414:S=ALNI_MYKjm5xhjXGUcsrTvPyuWmTR4Rdqw; __eoi=ID=49d2ba5f3bef0e66:T=1724095558:RT=1724358414:S=AA-AfjY3Sv4cW8QKP9Mmw2kuvrBv; _ga_P4HXTRVEMT=GS1.1.1724358402.15.1.1724358414.48.0.0; _ga=GA1.3.675333128.1724095558")
                .addHeader("dnt", "1")
                .addHeader("pragma", "no-cache")
                .addHeader("priority", "u=0, i")
                .addHeader("sec-ch-ua", "\"Not)A;Brand\";v=\"99\", \"Google Chrome\";v=\"127\", \"Chromium\";v=\"127\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"macOS\"")
                .addHeader("sec-fetch-dest", "document")
                .addHeader("sec-fetch-mode", "navigate")
                .addHeader("sec-fetch-site", "none")
                .addHeader("sec-fetch-user", "?1")
                .addHeader("upgrade-insecure-requests", "1")
                .addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36")
                .build();

        try (Response response = Application.client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Failed to download image, HTTP response code: " + response.code());
            }
            InputStream inputStream = response.body().byteStream();
            ImageInputStream imageInputStream = ImageIO.createImageInputStream(inputStream);

            Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("webp");
            ImageReader reader = readers.next();

            reader.setInput(imageInputStream, true);
            WebPReadParam readParam = new WebPReadParam();

            var bufferedImage = reader.read(0, readParam);

            return bufferedImage;
        }
    }

    public static String convertAndUploadImages(String storeName, String imageUrl) {
        try {
            String bucketName = "izinga-aut";

            // Step 1: Download the WebP image
            log.info("image url is {}", imageUrl);
            BufferedImage webpImage = null;
            try {
                webpImage = RemoteImageService.downloadImage(imageUrl);
            } catch (IOException e) {
                return imageUrl;
            }

            if (webpImage == null) {
                log.error("Image is empty, not uploading to s3");
                return imageUrl;
            }

            String originalName = RemoteImageService.getFileNameFromUrl(imageUrl);
            String jpegName = originalName.replace(".webp", ".jpg");

            //convert transparent images
            if (webpImage.getType() == BufferedImage.TYPE_INT_ARGB) {
                var rgbImage = new BufferedImage(webpImage.getWidth(), webpImage.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g = rgbImage.createGraphics();
                g.drawImage(webpImage, 0, 0, Color.WHITE, null);  // Draw the image without transparency
                g.dispose();
                webpImage = rgbImage;
            }

            // Step 2: Convert WebP to JPEG
            ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
            ImageIO.write(webpImage, "jpeg", jpegOutputStream);
            jpegOutputStream.flush();
            byte[] jpegBytes = jpegOutputStream.toByteArray();
            jpegOutputStream.close();

            if (jpegBytes.length == 0) {
                log.error("file is empty not uploading to s3 %s".formatted(jpegName));
                return imageUrl;
            }

            // Step 3: Upload the JPEG image to S3
            log.info("uploading to s3 %s".formatted(jpegName));
            var url = AWS3Service.uploadToS3(jpegBytes, bucketName, "%s/%s".formatted(storeName, jpegName));
            log.info("Image uploaded successfully to %s/%s".formatted(bucketName, jpegName));
            return url;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return imageUrl;
        }
    }
}