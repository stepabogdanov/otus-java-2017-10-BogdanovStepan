package newJson;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;

public class ListParser {
    JsonArrayBuilder jsonArrayBuilder;
    public JsonArrayBuilder parse (Field field, Object fieldsValue) throws IllegalAccessException {
        jsonArrayBuilder = Json.createArrayBuilder();
        System.out.println();
        if (field.getType().isAssignableFrom(AbstractList.class)) {
            for (String string: (ArrayList<String>) fieldsValue) {
                System.out.println(string);
                jsonArrayBuilder.add(string);
            }
        return jsonArrayBuilder;
        }
        return null;
    }
}
