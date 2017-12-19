package newJson;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;

public class StringParser  {

    JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
    JsonObject jsonObject;


    public String parse(Field field, Object o) throws IllegalAccessException {
        if (field.getType().equals(String.class)) {

            return (String) o;
        }

        //System.out.println(jsonObject);
        return null;

    }
}

