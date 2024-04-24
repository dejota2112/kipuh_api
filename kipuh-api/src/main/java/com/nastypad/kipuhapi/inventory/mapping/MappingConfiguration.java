package com.nastypad.kipuhapi.inventory.mapping;

import com.nastypad.kipuhapi.inventory.mapping.mappers.ProductMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.List;

@Configuration("inventoryMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ProductMapper productMapper() {
        return new ProductMapper();
    }
}
