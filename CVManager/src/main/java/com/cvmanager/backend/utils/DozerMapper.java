package com.cvmanager.backend.utils;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DozerMapper {

    private static final BeanMappingBuilder BUILDER = new BeanMappingBuilder() {

        @Override
        protected void configure() {
            /*
                not needed any other configuration
             */
        }
    };

    private static final DozerBeanMapper MAPPER = new DozerBeanMapper();

    static {
        MAPPER.addMapping(BUILDER);
    }

    public <O, D> D parseObject(O  originalObject, Class<D> destinationObject) {
        return parser(destinationObject, originalObject);
    }

    public <O, D> List<D> parseList(List<O> originalObjects, Class<D> destinationObject) {
        List<D> destinationObjects = new ArrayList<>();
        for (Object originalObject : originalObjects) {
            destinationObjects.add(parser(destinationObject, originalObject));
        }
        return destinationObjects;
    }

    private static <D> D parser(Class<D> destinationObject, Object originalObject) {
        return MAPPER.map(originalObject, destinationObject);
    }

}