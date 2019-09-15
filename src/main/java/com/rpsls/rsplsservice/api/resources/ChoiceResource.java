package com.rpsls.rsplsservice.api.resources;

import com.rpsls.rsplsservice.service.ChoicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/")
public class ChoiceResource {

    @Autowired
    ChoicesService choicesService;

    @GET
    @Path("choices")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllChoices() {
        return Response.ok(choicesService.getAllChoices()).build();
    }

    @GET
    @Path("choice")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRandomChoice() {
        return Response.ok(choicesService.getRandomChoice()).build();
    }
}
