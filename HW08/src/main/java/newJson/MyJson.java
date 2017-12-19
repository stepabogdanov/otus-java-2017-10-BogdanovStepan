package newJson;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;

public class MyJson {
        JsonObject jsonObject;

    public JsonObject toJson(Object o) {

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        JsonObjectBuilder enclosedObjectBuilder = Json.createObjectBuilder();

        for (Field field : o.getClass().getDeclaredFields()) {
            boolean fieldAccessible = true;
            if (!field.isAccessible()) {
                field.setAccessible(true);
                fieldAccessible = false;
            }

            try {
                Parser parser = new Parser(field, field.get(o));
                if (parser.executeInt() != null) {
                    jsonObjectBuilder.add(field.getName(), parser.executeInt());
                }

                if (parser.executeString() != null) {
                    jsonObjectBuilder.add(field.getName(), parser.executeString());
                }


                //System.out.println(jsonObject);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


            if (!fieldAccessible) {
                field.setAccessible(false);
            }


        }

        return jsonObject = jsonObjectBuilder.build();
        //return null;
    }

}
