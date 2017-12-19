package newJson.MyJson;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.ArrayList;

class ListParser {

    JsonArrayBuilder parse (Field field, Object fieldsValue) {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        if (field.getType().isAssignableFrom(AbstractList.class)) {
            for (String string: (ArrayList<String>) fieldsValue) {   // TODO: 20.12.17 сделать проверку на типизацию листа
                jsonArrayBuilder.add(string);
            }
        return jsonArrayBuilder;
        }
        return null;
    }
}
