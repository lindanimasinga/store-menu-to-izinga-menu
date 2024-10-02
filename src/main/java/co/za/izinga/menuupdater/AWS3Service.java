package co.za.izinga.menuupdater;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.ByteArrayInputStream;

public class AWS3Service {
    static String uploadToS3(byte[] jpegBytes, String bucketName, String keyName) {
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.AF_SOUTH_1)
                .build();

        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jpegBytes);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("image/jpeg");
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, keyName, byteArrayInputStream, metadata);

            s3.putObject(putObjectRequest);
            System.out.println("File uploaded successfully.");
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorCode());
            System.exit(1);
        }

        return String.format("https://%s.s3.%s.amazonaws.com/%s", bucketName, "af-south-1", keyName);
    }
}