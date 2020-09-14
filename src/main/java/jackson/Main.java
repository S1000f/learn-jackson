package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.ch01.ExtendableBean;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        ExtendableBean bean = new ExtendableBean();
        bean.setName("cat");
        Map<String, String> input = new HashMap<String, String>();
        input.put("name", "Milly");
        input.put("age", "9");
        bean.setProperties(input);

        String mapped = mapper.writeValueAsString(bean);
        System.out.println(mapped);
    }
}
