
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateHandler extends StdDeserializer<Date> {
    protected DateHandler(Class<?> vc) {
        super(vc);
    }

    protected DateHandler(JavaType valueType) {
        super(valueType);
    }

    protected DateHandler(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext context)

            throws IOException {

        String date = jsonParser.getText();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.Mt.yyyy");
            return sdf.parse(date);

        } catch (Exception e) {
            return null;

        }
    }
}