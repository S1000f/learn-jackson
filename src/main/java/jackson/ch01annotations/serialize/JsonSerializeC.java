package jackson.ch01annotations.serialize;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class JsonSerializeC {

    private String name;
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date eventDate;

    public JsonSerializeC(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

    public String getName() {
        return name;
    }

    public Date getEventDate() {
        return eventDate;
    }
}
