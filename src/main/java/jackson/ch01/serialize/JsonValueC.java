package jackson.ch01.serialize;

import com.fasterxml.jackson.annotation.JsonValue;

public class JsonValueC {

    private int id;
    private String name;

    public JsonValueC(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonValue
    public int getId() {
        return id;
    }
}
