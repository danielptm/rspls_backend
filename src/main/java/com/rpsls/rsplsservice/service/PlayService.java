package com.rpsls.rsplsservice.service;

import com.rpsls.rsplsservice.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayService {

    ResultsService resultsService;

    @Autowired
    public PlayService(ResultsService resultsService) {
        this.resultsService = resultsService;
    }
    public Result playRound() {
        return null;
    }
}
