package com.rpsls.rsplsservice.api.resources;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/results")
public class ResultsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTopTenResults() {
        return null;
    }
}