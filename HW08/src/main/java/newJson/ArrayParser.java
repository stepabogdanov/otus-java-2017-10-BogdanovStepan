package newJson;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;

public class ArrayParser {
    JsonArrayBuilder jsonArrayBuilder;

    public JsonArrayBuilder parse (Field field, Object fielsValue) throws IllegalAccessException {
        if (field.getType().isArray()) {
            jsonArrayBuilder = Json.createArrayBuilder();
            int a=0;

            System.out.println(field.get(fielsValue));
            if (!field.getClass().isPrimitive()) {
                for (Object array : (int[]) fielsValue) {
                    if (array.getClass().equals(String.class)) {
                        jsonArrayBuilder.add((String) array);
                    }
                    if (array.getClass().equals(Integer.class)) {
                        jsonArrayBuilder.add((Integer) array);
                    }
                    if (array.getClass().equals(Long.class) ) {
                        jsonArrayBuilder.add((Long) array);
                    }
                }
                return jsonArrayBuilder;
            }
            if (fielsValue.getClass().equals(int.class)) {
                for (Object array: (int[])fielsValue ) {
                    jsonArrayBuilder.add((int) array);
                }

            }
        }
        return null;
    }
}