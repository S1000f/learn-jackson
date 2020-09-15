package jackson.ch01.serialize;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "user")
public class JsonRootNameC {

    private int id;
    private String name;

    public JsonRootNameC(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
