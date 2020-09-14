package jackson.ch01;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;

public class ExtendableBean {
    public String name;
    private Map<String, String> properties;

    public void setName(String name) {
        this.name = name;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

}
