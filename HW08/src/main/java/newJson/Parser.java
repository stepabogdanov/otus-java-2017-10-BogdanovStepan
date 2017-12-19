package newJson;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
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
        String string = stringParser.parse(field, o);

        if (string != null) {
            return string;
        }
        return null;
    }
    public Integer executeInt() throws IllegalAccessException {
        IntParser intParser = new IntParser();
        Integer value = intParser.parse(field, o);

        if (value != null) {
            return value;

        }
        return null;
    }
    public JsonArrayBuilder executeArray () throws IllegalAccessException {
        ArrayParser arrayParser = new ArrayParser();
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        jsonArrayBuilder = arrayParser.parse(field, o);

            if (jsonArrayBuilder != null) {
                //return jsonArrayBuilder;
            }
        return null;
    }
}
