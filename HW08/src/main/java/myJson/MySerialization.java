package myJson;





import javax.json.*;
import java.lang.reflect.Field;
import java.util.Arrays;

public class MySerialization {

    public String doSerialize (Object o) {
        String string ="";
        return string;
    }

    public static JsonObject reflection (Object o) throws IllegalAccessException {
        JsonObject jsonObject = null;
        JsonObjectBuilder jsonObjectBuilder = null;
        JsonObjectBuilder enclosedObjectBuilder = Json.createObjectBuilder();

        for (Field field : o.getClass().getDeclaredFields() ) {

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

                for ( Field fieldOfObject : field.get(o).getClass().getDeclaredFields() ) {

                    //System.out.println(fieldOfObject.getName() + " _" + fieldOfObject.get(field.get(o)));
                   // enclosedObjectBuilder.add(fieldOfObject.getName(), "en_" +fieldOfObject.get(field.get(o)).toString());


                    //reflection(field.get(o));

                }

                jsonObjectBuilder.add(field.getName(), reflection(field.get(o)));
                //reflection(field.get(o));



            }

            if (field.getType().isArray()) {
                JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
                //System.out.println("array ");
                for (Object  array : (Object[]) field.get(o)) {
                    //System.out.print(field.getName() + " _" + array + '\n');
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


                System.out.println(field.getName() + " _" + field.get(o));
                jsonObjectBuilder = Json.createObjectBuilder();
                jsonObjectBuilder.add(field.getName(), field.get(o).toString());

                //System.out.println("object: " + field.get(o).getClass() +  " _" + field.get(o).getClass());

//                jsonObjectBuilder.add(field.getName(), enclosedObjectBuilder);

            }

        }


        jsonObject = jsonObjectBuilder.build();
        //System.out.println("My json " + jsonObject);
        return jsonObject;
    }
}
