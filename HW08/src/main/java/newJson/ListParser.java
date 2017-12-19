package newJson;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;
import java.util.AbstractCollection;
import java.util.AbstractList;

public class ListParser {
    JsonArrayBuilder jsonArrayBuilder;
    public JsonArrayBuilder parse (Field field, Object fieldsValue) throws IllegalAccessException {
        jsonArrayBuilder = Json.createArrayBuilder();
        if (field.getType().equals(AbstractList.class.getCanonicalName())) {

            System.out.println("ee");
            return jsonArrayBuilder;
        }
        return null;
    }
}
