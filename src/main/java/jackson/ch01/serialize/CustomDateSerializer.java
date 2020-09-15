package jackson.ch01.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateSerializer extends StdSerializer<Date> {

    private static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm");

    public CustomDateSerializer() {
        this(null);
    }

    protected CustomDateSerializer(Class<Date> t) {
        super(t);
    }

    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeString(format.format(date));
    }
}
