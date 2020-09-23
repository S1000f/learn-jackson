package jackson.ch01annotations.deserialize;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class JsonAliasC {

    @JsonAlias({"fName", "f_name"})
    private String firstName;
    private String lastName;
}
