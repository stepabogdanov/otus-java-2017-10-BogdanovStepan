package newJson;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;

public class IntParser {
    JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
    JsonObject jsonObject;


    public Integer parse(Field field, Object o) throws IllegalAccessException {
        if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {



          return (Integer) o;


        }

        //System.out.println(jsonObject);
        return null;
    }
}
