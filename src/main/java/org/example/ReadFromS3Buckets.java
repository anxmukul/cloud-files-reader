package org.example;
import java.util.List;
import java.util.ListIterator;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsResponse;
import software.amazon.awssdk.services.s3.model.S3Object;

public class ReadFromS3Buckets implements FileReader{
    public void readFileFromCloud(){
        System.out.println("I method::::: ");
        Region region = Region.AP_SOUTHEAST_2;

        String bucketName = "anxnewbucket";
        S3Client client = S3Client.builder().region(region).build();
        ListObjectsRequest request = ListObjectsRequest.builder().bucket(bucketName).build();

        ListObjectsResponse response = client.listObjects(request);
        List<S3Object> objects = response.contents();

        ListIterator<S3Object> listIterator = objects.listIterator();

        while (listIterator.hasNext()) {
            S3Object object = listIterator.next();
            System.out.println(object.key() + " - " + object.size() + object);
        }
    }
}