package com.rpsls.rsplsservice.api.resources;


import com.rpsls.rsplsservice.model.Player;
import com.rpsls.rsplsservice.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/play")
public class PlayResource {

    @Autowired
    PlayService playService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response play(Player player) {
        return Response.ok(playService.playRound(player)).build();
    }
}
