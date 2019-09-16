package com.rpsls.rsplsservice.api.resources;

import com.rpsls.rsplsservice.service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/results")
public class ResultsResource {

    @Autowired
    ResultsService resultsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTopTenResults() {
        return Response.ok(resultsService.getMostRecent10Results()).build();
    }

}
