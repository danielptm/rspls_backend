package com.rpsls.rsplsservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rpsls.rsplsservice.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ResultsService {

    private static final Logger LOGGER = Logger.getLogger(ResultsService.class.getName());

    private S3Client s3Client;

    @Autowired
    public ResultsService(S3Client s3Client) {
        this.s3Client = s3Client;
    }


    public List<Result> getMostRecent10Results() {
        String resultsFile = s3Client.getResultsFile();
        List<Result> results = null;
        try {
            // Doing it like this is bad. It should be a singleton.
            ObjectMapper objectMapper =  new ObjectMapper();
            results = objectMapper.readValue(resultsFile, new TypeReference<ArrayList<Result>>(){});
            results = results.stream().limit(10).collect(Collectors.toList());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("There was a problem deserializing results from a json string: %s", e.getMessage()));
        }
        return results;
    }

    public void appendResult(Result result) {
        String resultsFile = s3Client.getResultsFile();
        List<Result> results = null;
        try {
            // Doing it like this is bad. It should be a singleton.
            ObjectMapper objectMapper =  new ObjectMapper();
            results = objectMapper.readValue(resultsFile, new TypeReference<ArrayList<Result>>(){});
            results.add(result);
            s3Client.writeContentsToS3(results.toString());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, String.format("There was a problem WRITING results to s3: %s", e.getMessage()));
        }
    }
}
