package pl.damianlegutko.util.genrex.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_ENUMS_USING_TO_STRING;

public class Serializer {
    private static final String SERIALIZATION_ERROR_MESSAGE = "Cannot serialize this object";
    static JsonMapper jsonMapper = (JsonMapper) new JsonMapper()
            .registerModule(new JavaTimeModule())
            .setSerializationInclusion(NON_NULL)
            .enable(INDENT_OUTPUT)
            .enable(WRITE_ENUMS_USING_TO_STRING);

    private Serializer() {
    }

    public static String toJson(Object objectToSerialize) {
        try {
            return jsonMapper.writeValueAsString(objectToSerialize);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException("Problem with serialization", exception);
        }
    }

    public static <T> T deepClone(Object objectToSerialize, Class<T> cloneToClass) {
        String objectAsJson = toJson(objectToSerialize);
        return toObjectFromJson(objectAsJson, cloneToClass);
    }

    public static <T> T toObjectFromJson(String json, Class<T> clazz) {
        try {
            return jsonMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(SERIALIZATION_ERROR_MESSAGE, e);
        }
    }
}
