package jackson.ch01.serialize;

import com.fasterxml.jackson.annotation.JsonValue;

public enum JsonValue_ {

    TYPE1(1, "TYPE1"),
    TYPE2(2, "TYPE2");

    private Integer id;
    private String name;

    JsonValue_(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
