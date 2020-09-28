package jackson.ch01annotations.general;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonUnwrappedC {

    private long id;
    @JsonUnwrapped
    private Name name;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Name {

        private String firstName;
        private String lastName;
    }
}
