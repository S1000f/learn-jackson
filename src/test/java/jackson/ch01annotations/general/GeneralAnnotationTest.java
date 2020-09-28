package jackson.ch01annotations.general;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GeneralAnnotationTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @DisplayName("@JsonProperty")
    @Test
    public void jsonPropertyTest() throws JsonProcessingException {
        JsonPropertyC jsonPropertyC = new JsonPropertyC(3, "sully");
        String result = mapper.writeValueAsString(jsonPropertyC);
        System.out.println(result);

        assertEquals("{\"id\":3,\"name\":\"sully\"}", result);

        /*
        * NoArgConstructor 가 없으면 실패함
        * */
        JsonPropertyC jsonPropertyC1 = mapper.readerFor(JsonPropertyC.class).readValue(result);

        assertEquals("sully", jsonPropertyC1.getTheName());

    }

    @DisplayName("@JsonFormat")
    @Test
    public void jsonFormatTest() throws ParseException, JsonProcessingException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy hh:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("KST"));

        String toParse = "20-12-2014 02:30:33";
        Date date = format.parse(toParse);
        JsonFormatC jsonFormatC = new JsonFormatC("pubg", date);

        String result = mapper.writeValueAsString(jsonFormatC);
        System.out.println(result);

        assertEquals("{\"name\":\"pubg\",\"eventDate\":\"20-12-14 02:30:33\"}", result);
    }

    @DisplayName("@JsonUnwrapped")
    @Test
    public void jsonUnwrappedTest() throws JsonProcessingException {
        JsonUnwrappedC.Name name = new JsonUnwrappedC.Name("Json", "Doe");
        JsonUnwrappedC jsonUnwrappedC = new JsonUnwrappedC(23L, name);

        String result = mapper.writeValueAsString(jsonUnwrappedC);
        System.out.println(result);

        assertEquals("{\"id\":23,\"firstName\":\"Json\",\"lastName\":\"Doe\"}", result);
        assertNotEquals("{\n" +
                "    \"id\":23,\n" +
                "    \"name\":{\n" +
                "        \"firstName\":\"Json\",\n" +
                "        \"lastName\":\"Doe\"\n" +
                "    }\n" +
                "}", result);
    }



}
