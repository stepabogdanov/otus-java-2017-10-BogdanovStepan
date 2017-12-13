package myJson;





import javax.json.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

public class MySerialization {

    public String doSerialize (Object o) {
        String string ="";
        return string;
    }

     static JsonObject reflection (Object o) throws IllegalAccessException {
        JsonObject jsonObject;
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        JsonObjectBuilder enclosedObjectBuilder = Json.createObjectBuilder();

        for (Field field : o.getClass().getDeclaredFields() ) {
            boolean fieldAccessible = true;

            if (!field.isAccessible()) {
                field.setAccessible(true); //
                fieldAccessible = false;
            }

            if (
                    !(field.getType().getName().equals(String.class.getCanonicalName()) ||
                 field.getType().getName().equals(Integer.class.getCanonicalName()) ||
                 field.getType().getName().equals(Long.class.getCanonicalName()) ||
                 field.getType().getName().equals(Byte.class.getCanonicalName()) ||
                 field.getType().getName().equals(Short.class.getCanonicalName()) ||
                 field.getType().getName().equals(Boolean.class.getCanonicalName()) ||
                 field.getType().isAssignableFrom(AbstractSet.class) ||
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

            if (field.getType().isAssignableFrom(AbstractSet.class)) {
                JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
                jsonArrayBuilder.add(field.get(o).toString());
                jsonObjectBuilder.add(field.getName(), jsonArrayBuilder);
            }




            if (field.getType().getName().equals(String.class.getCanonicalName()) ||
                field.getType().getName().equals(Long.class.getCanonicalName()) ||
                field.getType().getName().equals(Byte.class.getCanonicalName()) ||
                field.getType().getName().equals(Short.class.getCanonicalName()) ||
                field.getType().getName().equals(Boolean.class.getCanonicalName()) ||
                field.getType().isPrimitive()) {
                //System.out.println(field.getName() + " _" + field.get(o).toString());
                jsonObjectBuilder.add(field.getName(), field.get(o).toString());

            }

            if (field.getType().getName().equals(Integer.class.getCanonicalName()) ||
                field.getType().getName().equals(int.class.getCanonicalName())) {

                jsonObjectBuilder.add(field.getName(), (Integer) field.get(o));
            }

            if (!fieldAccessible) {
                field.setAccessible(false);
            }

        }

        jsonObject = jsonObjectBuilder.build();
        return jsonObject;
    }

    private  JsonObjectBuilder fieldParser (Field field) {
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        return jsonObjectBuilder;



    }

}
