package com.nastypad.kipuhapi.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("sharedMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper enhancedModelMapper() {
        EnhancedModelMapper mapper = new EnhancedModelMapper();
        return mapper;
    }
}
