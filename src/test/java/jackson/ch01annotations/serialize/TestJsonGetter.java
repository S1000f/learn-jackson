package jackson.ch01annotations.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJsonGetter {

    @Test
    public void JsonGetterTest() throws JsonProcessingException {
        JsonGetter jsonGetter = new JsonGetter(22, "milly");
        String result = new ObjectMapper().writeValueAsString(jsonGetter);

        assertEquals("{\"theName\":\"milly\"}", result);
    }
}
