package myJson;

import java.lang.reflect.Field;

public class MySerialization {

    public String doSerialize (Object o) {
        String string ="";
        return string;
    }

    public static String reflection (Object o) throws IllegalAccessException {
        String fields = "";

        for (Field field : o.getClass().getDeclaredFields() ) {

            if (
                    !(field.getType().getName().equals(String.class.getCanonicalName()) ||
                 field.getType().getName().equals(Integer.class.getCanonicalName()) ||
                 field.getType().getName().equals(Long.class.getCanonicalName()) ||
                 field.getType().getName().equals(Byte.class.getCanonicalName()) ||
                 field.getType().getName().equals(Short.class.getCanonicalName()) ||
                 field.getType().getName().equals(Boolean.class.getCanonicalName()) ||
                 field.getType().isPrimitive())

                     ) {

                System.out.println(field.getName() + " _" + field.getType().getName());
                //System.out.println(field.get(o) +  " " + field.get(o).getClass());
            }
            else {
                reflection(field.get(o));

//                for (Field fieldOfObject: field.get(o).getClass().getDeclaredFields()) {
//
//                }
            }

        }
        return fields;
    }
}
