package myJson;





import javax.json.*;
import java.lang.reflect.Field;
import java.util.Arrays;

public class MySerialization {

    public String doSerialize (Object o) {
        String string ="";
        return string;
    }

     static JsonObject reflection (Object o) throws IllegalAccessException {
        JsonObject jsonObject = null;
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        JsonObjectBuilder enclosedObjectBuilder = Json.createObjectBuilder();

        for (Field field : o.getClass().getDeclaredFields() ) {
            boolean fieldAccseseble = true;

            if (!field.isAccessible()) {
                field.setAccessible(true);
                fieldAccseseble = false;
            }

            if (
                    !(field.getType().getName().equals(String.class.getCanonicalName()) ||
                 field.getType().getName().equals(Integer.class.getCanonicalName()) ||
                 field.getType().getName().equals(Long.class.getCanonicalName()) ||
                 field.getType().getName().equals(Byte.class.getCanonicalName()) ||
                 field.getType().getName().equals(Short.class.getCanonicalName()) ||
                 field.getType().getName().equals(Boolean.class.getCanonicalName()) ||
                 field.getType().isPrimitive() ||
                 field.getType().isArray())

                     ) {
            jsonObjectBuilder.add(field.getName(), reflection(field.get(o)));

            }

            if (field.getType().isArray()) {
                JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
                for (Object  array : (Object[]) field.get(o)) {
                    jsonArrayBuilder.add((String) array);
                }
                jsonObjectBuilder.add(field.getName(), jsonArrayBuilder);
            }

            if (    (field.getType().getName().equals(String.class.getCanonicalName()) ||
                    field.getType().getName().equals(Integer.class.getCanonicalName()) ||
                    field.getType().getName().equals(Long.class.getCanonicalName()) ||
                    field.getType().getName().equals(Byte.class.getCanonicalName()) ||
                    field.getType().getName().equals(Short.class.getCanonicalName()) ||
                    field.getType().getName().equals(Boolean.class.getCanonicalName()) ||
                    field.getType().isPrimitive())
                    ) {

                //System.out.println(field.getName() + " _" + field.get(o));

                jsonObjectBuilder.add(field.getName(), field.get(o).toString());

            }

            if (!fieldAccseseble) {
                field.setAccessible(false);
            }

        }

        jsonObject = jsonObjectBuilder.build();
        return jsonObject;
    }
}
