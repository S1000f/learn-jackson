package jackson.ch01annotations.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJsonRawValue {

    @Test
    public void test() throws JsonProcessingException {
        JsonRawValue jsonRawValue = new JsonRawValue("milly", "anything");
        String result = new ObjectMapper().writeValueAsString(jsonRawValue);

        assertEquals("{\"name\":\"milly\",\"json\":anything}", result);
    }
}
