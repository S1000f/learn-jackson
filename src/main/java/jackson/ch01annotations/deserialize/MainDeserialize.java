package jackson.ch01annotations.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainDeserialize {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {

        /* @JsonCreator
        * 맵핑되는 클래스 필드 명과 json의 키 이름이 다른 경우가 있을때
        * 해당 필드명이 특정 json의 값을 받도록 지정할 수 있다.
        * 예) json의 theName 값 -> JsonCreatorC 의 name 필드가 받도록 처리
        * */
        String json = "{\"id\":1,\"theName\":\"My bean\"}";
        JsonCreatorC bean = mapper.readerFor(JsonCreatorC.class)
                .readValue(json);
        System.out.println(bean.getId() + " : " + bean.getName()); // 1 : My bean

        /* @JacksonInject
        * 클래스의 특정 필드값은 json객체로 부터 값을 받는게 아니라
        * 별도로 만든 InjectableValues 객체로 부터 값을 받도록 지정할 수 있다
        *  */
        String json1 = "{\"name\":\"My beans!\"}";
        InjectableValues injectableValues = new InjectableValues.Std().addValue(int.class, 5);
        JacksonInjectC jacksonInjectC = mapper.reader(injectableValues)
                .forType(JacksonInjectC.class)
                .readValue(json1);
        System.out.println(jacksonInjectC.getId() + " : " + jacksonInjectC.getName()); // 5 : My beans!

        /* @JsonAnySetter
        *
        * */
        String json2 = "{\"name\":\"My bean\",\"rrre\":\"val2\",\"adff\":\"val1\"}";
        JsonAnySetterC jsonAnySetterC = new ObjectMapper().readerFor(JsonAnySetterC.class)
                .readValue(json2);
        System.out.println(jsonAnySetterC.getName());
        System.out.println(jsonAnySetterC.getProperties().get("rrre"));

        /* @JsonAlias
        * */
        String json3 = "{\"fName\" : \"John\", \"lastName\" :\"Green\"}";
        JsonAliasC aliasC = mapper.readerFor(JsonAliasC.class)
                .readValue(json3);
        System.out.println(aliasC.getFirstName());
        System.out.println(aliasC.getLastName());

    }
}
