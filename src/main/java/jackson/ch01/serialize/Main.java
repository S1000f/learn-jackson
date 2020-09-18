package jackson.ch01.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jackson.ch01.serialize.JsonRootNameC;
import jackson.ch01.serialize.JsonSerializeC;
import jackson.ch01.serialize.JsonValueC;
import jackson.ch01.serialize.JsonValue_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException, ParseException {

        // @JsonValue
        String jsonValue = mapper.writeValueAsString(JsonValue_.TYPE1);
        System.out.println(jsonValue); // "TYPE1"

        JsonValueC jsonValueC = new JsonValueC(23, "who");
        String jsonvalueResult = mapper.writeValueAsString(jsonValueC);
        System.out.println(jsonvalueResult); // 23

        // @JsonRootName
        JsonRootNameC jsonRootNameC = new JsonRootNameC(33, "iam");
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String jsonrootnameReuslt = mapper.writeValueAsString(jsonRootNameC);
        System.out.println(jsonrootnameReuslt); // {"user":{"id":33,"name":"iam"}}
        mapper.disable(SerializationFeature.WRAP_ROOT_VALUE);

        // @JsonSerialize
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2020-09-01");

        JsonSerializeC jsonSerializeC = new JsonSerializeC("whose", date);
        String jsonSerializeResult = mapper.writeValueAsString(jsonSerializeC);
        System.out.println(jsonSerializeResult); // {"name":"whose","eventDate":"01-09-2020 12:00"}

    }
}
