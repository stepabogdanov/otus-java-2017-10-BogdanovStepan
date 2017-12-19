package newJson;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;
import java.util.Arrays;

public class ArrayParser {
    JsonArrayBuilder jsonArrayBuilder;

    public JsonArrayBuilder parse (Field field, Object fieldsValue) throws IllegalAccessException {
        if (field.getType().isArray()) {
            jsonArrayBuilder = Json.createArrayBuilder();
            if (fieldsValue.getClass().getTypeName().equals(int[].class.getCanonicalName())) {
                for (Object array : (int[]) fieldsValue) {
                    jsonArrayBuilder.add((int) array);
                }
            }
            if (fieldsValue.getClass().getTypeName().equals(String[].class.getCanonicalName())) {
                for (Object array : (String[]) fieldsValue) {
                    jsonArrayBuilder.add((String) array);
                }
            }
        return jsonArrayBuilder;
        }
    return null;
    }
}

