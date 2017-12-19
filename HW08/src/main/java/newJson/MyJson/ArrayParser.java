package newJson.MyJson;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import java.lang.reflect.Field;

class ArrayParser {

    @SuppressWarnings("ConstantConditions")
    JsonArrayBuilder parse (Field field, Object fieldsValue) {
        if (field.getType().isArray()) {
            JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
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

