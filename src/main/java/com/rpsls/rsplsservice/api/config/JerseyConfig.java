package com.rpsls.rsplsservice.api.config;

import com.rpsls.rsplsservice.api.resources.ChoiceResource;
import com.rpsls.rsplsservice.api.resources.PlayResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ChoiceResource.class);
        register(PlayResource.class);
    }
}