package com.pegasus.test.awss3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

/**
 * Created by enHui.Chen on 2020/8/26.
 */
public class AwsS3FileService {
    public static void main(String[] args) {
        String accessKey = "insert your access key here!";
        String secretKey = "insert your secret key here!";

        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3 conn = new AmazonS3Client(credentials);
        conn.setEndpoint("objects.dreamhost.com");
    }
}
