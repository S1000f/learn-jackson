package jackson.ch01.serialize;

@com.fasterxml.jackson.annotation.JsonPropertyOrder({"name", "id"})
public class JsonPropertyOrder {
    public int id;
    public String name;

    public JsonPropertyOrder(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
