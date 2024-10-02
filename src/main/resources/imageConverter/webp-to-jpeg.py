import requests
from PIL import Image
import boto3
from io import BytesIO
from urllib.parse import urlparse, parse_qs

def download_image(url):
    response = requests.get(url)
    response.raise_for_status()

    # Extract the path part of the URL and then get the filename
    parsed_url = urlparse(url)
    original_name = parsed_url.path.split('/')[-1].split('?')[0]  # Get the filename without query params

    return Image.open(BytesIO(response.content)), original_name

def convert_to_jpeg(image):
    jpeg_image = BytesIO()
    image = image.convert("RGB")  # Convert to RGB before saving as JPEG
    image.save(jpeg_image, format="JPEG")
    jpeg_image.seek(0)  # Rewind the buffer to the beginning
    return jpeg_image

def upload_to_s3(image, bucket_name, s3_key):
    s3_client = boto3.client('s3')
    s3_client.upload_fileobj(image, bucket_name, s3_key)

def main():
    url = 'https://www.shoprite.co.za/medias/10192261EA-checkers300Wx300H.webp?context=bWFzdGVyfGltYWdlc3wzNzEyfGltYWdlL3dlYnB8aW1hZ2VzL2hkMi9oODIvMTEwMzA3NjE4MzI0Nzgud2VicHxjMTlmMjRkODJjMDc0MzJhMjM1Y2IxN2NiMDU5NGVjNGFlNjU5ZGQ1M2ZiNzg0NTVkYTA2YmYwNjRiMWMwYTJm'  # Replace with the actual URL
    bucket_name = 'izinga-aut'

    # Step 1: Download the WebP image and get its original name
    webp_image, original_name = download_image(url)
    jpeg_name = original_name.rsplit('.', 1)[0] + '.jpg'

    # Step 2: Convert WebP to JPEG
    jpeg_image = convert_to_jpeg(webp_image)

    # Step 3: Upload the JPEG image to S3 with the same name but .jpg extension
    upload_to_s3(jpeg_image, bucket_name, jpeg_name)

    print(f"Image uploaded successfully to {bucket_name}/{jpeg_name}")

if __name__ == "__main__":
    main()
