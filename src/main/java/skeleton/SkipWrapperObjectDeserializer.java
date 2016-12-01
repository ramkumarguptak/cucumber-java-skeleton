package skeleton;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

/**
 * Created by hnpc on 11/30/2016.
 */
public class SkipWrapperObjectDeserializer extends JsonDeserializer<Object> implements
        ContextualDeserializer {
    private Class<?> wrappedType;
    private String wrapperKey;

    public JsonDeserializer<?> createContextual(DeserializationContext ctxt,
                                                BeanProperty property) throws JsonMappingException {
        SkipWrapperObject skipWrapperObject = property
                .getAnnotation(SkipWrapperObject.class);
        wrapperKey = skipWrapperObject.value();
        JavaType collectionType = property.getType();
        //JavaType collectedType = collectionType.containedType(0);
        wrappedType = WeatherApiJsonWeather.class;//collectedType.getRawClass();
        return this;
    }

    @Override
    public Object deserialize(JsonParser parser, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.readTree(parser);
        //JsonNode wrapped = objectNode.get(0);
        Object mapped = mapIntoObject(objectNode);
        return mapped;
    }

    private Object mapIntoObject(JsonNode node) throws IOException,
            JsonProcessingException {
        JsonParser parser = node.traverse();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(parser, wrappedType);
    }
}