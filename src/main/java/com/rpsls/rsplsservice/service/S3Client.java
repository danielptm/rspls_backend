package com.rpsls.rsplsservice.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.rpsls.rsplsservice.utils.ResourceGetter;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class S3Client {

    private static final Logger LOGGER = Logger.getLogger(ResourceGetter.class.getName());


    //These credentials are only hard coded for the sake of this exam. It is not best practice, and the user for these credentials is going to be deleted at the end of the week.
    private static final BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIA56GAXAIFRTYHM7PK", "1J8F6ezQAwdrFrF+WbL3yloMSwBVk3ULcpn1cvEL");
    private static final AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .build();

    public String getResultsFile() {
        String result = null;
        try (S3Object s3Object = s3Client.getObject("daniels-misc", "rpsls/results.json");
             InputStream inputStream = s3Object.getObjectContent()) {

            StringWriter writer = new StringWriter();

            IOUtils.copy(inputStream, writer);
            result = writer.toString();

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("There was an error when READING the file from s3: %s", e.getMessage()));
        }
        return result;
    }

    public void writeContentsToS3(String fileContents) {
        try {
            StringJoiner sj = new StringJoiner("", "", "");
            sj.add(getResultsFile());
            sj.add(fileContents);
            s3Client.putObject("daniels-misc", "rpsls/results.json", sj.toString());
        } catch(Exception e) {
            LOGGER.log(Level.SEVERE, String.format("There was an error when WRITING the file from s3: %s", e.getMessage()));

        }
    }
}
