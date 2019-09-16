package com.rpsls.rsplsservice.api.resources;


import com.rpsls.rsplsservice.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/player")
public class PlayerResource {

    @Autowired
    PlayerService playerService;

    @GET
    @Path("/random-name")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRandomName() {
        return Response.ok(playerService.getRandomName()).build();
    }
}
