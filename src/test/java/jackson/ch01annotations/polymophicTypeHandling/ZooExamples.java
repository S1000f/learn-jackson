package jackson.ch01annotations.polymophicTypeHandling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class ZooExamples {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void serializePolymorphic() throws JsonProcessingException {
        Zoo.Dog dog = new Zoo.Dog("lacy");
        Zoo zoo = new Zoo(dog);

        String result = mapper.writeValueAsString(zoo);
        System.out.println(result); // {"animal":{"type":"dog","name":"lacy","barkVolume":0.0}}
    }

    @Test
    public void deserialize() throws JsonProcessingException {
        String json = "{\n" +
                "    \"animal\":{\n" +
                "        \"name\":\"lacy\",\n" +
                "        \"type\":\"cat\"\n" +
                "    }\n" +
                "}";

        Zoo zoo = mapper.readerFor(Zoo.class)
                .readValue(json);
        System.out.println(zoo); // Zoo(animal=Zoo.Cat(likesCream=false, lives=0))
    }
}
