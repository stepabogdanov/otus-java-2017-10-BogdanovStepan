package newJson;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.lang.reflect.Field;

public class MyJson {
        JsonObject jsonObject;
        String string;
        Integer valueInteger;
        Long valueLong;



    public JsonObject toJson(Object o) {

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

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

                if (parser.executeArray() != null) {
                    jsonObjectBuilder.add(field.getName(), parser.executeArray());
                }

                if (parser.executeInt() == null &&
                        parser.executeString() == null &&
                        parser.executeArray() == null ) {
                    jsonObjectBuilder.add(field.getName(), toJson(field.get(o)));
                }

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
