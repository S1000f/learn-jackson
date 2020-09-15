package jackson.ch01.serialize;

public class JsonGetter {
    private int id;
    private String name;

    public JsonGetter(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @com.fasterxml.jackson.annotation.JsonGetter
    public String getTheName() {
        return name;
    }
}
