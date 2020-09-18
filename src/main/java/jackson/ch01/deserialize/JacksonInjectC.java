package jackson.ch01.deserialize;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.Getter;

@Getter
public class JacksonInjectC {

    @JacksonInject
    private int id;
    private String name;
}
