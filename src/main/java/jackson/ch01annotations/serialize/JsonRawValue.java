package jackson.ch01annotations.serialize;

public class JsonRawValue {

    private String name;
    @com.fasterxml.jackson.annotation.JsonRawValue
    private String json;

    public JsonRawValue(String name, String json) {
        this.name = name;
        this.json = json;
    }

    public String getName() {
        return name;
    }
}
