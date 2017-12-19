package newJson;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;

public class Parser {
    JsonObject jsonObject;
    JsonObjectBuilder jsonObjectBuilder;
    Field field;
    Object o;
    String string;
    Integer integer;


    Parser (Field field, Object o) {
    this.field = field;
    this.o = o;
    }

    public String executeString() throws IllegalAccessException {
        StringParser stringParser = new StringParser();

        if (stringParser.parse(field, o) != null) {
            return stringParser.parse(field, o);
        }
        return null;
    }
    public Integer executeInt() throws IllegalAccessException {
        IntParser intParser = new IntParser();

        if (intParser.parse(field, o) != null) {
            return intParser.parse(field, o);

        }

        return null;
    }
}
