package com.rpsls.rsplsservice.api.config;

import com.rpsls.rsplsservice.api.resources.ChoiceResource;
import com.rpsls.rsplsservice.api.resources.PlayResource;
import com.rpsls.rsplsservice.api.resources.PlayerResource;
import com.rpsls.rsplsservice.api.resources.ResultsResource;
import com.rpsls.rsplsservice.model.PlayerName;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ChoiceResource.class);
        register(PlayResource.class);
        register(PlayerResource.class);
        register(ResultsResource.class);
    }
}
