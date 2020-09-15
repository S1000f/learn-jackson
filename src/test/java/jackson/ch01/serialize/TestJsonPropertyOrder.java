package jackson.ch01.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJsonPropertyOrder {

    @Test
    public void test() throws JsonProcessingException {
        JsonPropertyOrder jsonPropertyOrder = new JsonPropertyOrder(1, "who");
        String serialized = new ObjectMapper().writeValueAsString(jsonPropertyOrder);

        assertEquals("{\"name\":\"who\",\"id\":1}", serialized);
    }
}
