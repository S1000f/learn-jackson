package jackson.ch01annotations.deserialize;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.Getter;

@Getter
public class JacksonInjectC {

    @JacksonInject
    private int id;
    private String name;
}
