package jackson.ch01.deserialize;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class JsonAnySetterC {

    private String name;
    private Map<String, String> properties = new TreeMap<>();

    @JsonAnySetter
    public void add(String key, String value) {
        properties.put(key, value);
    }
}
