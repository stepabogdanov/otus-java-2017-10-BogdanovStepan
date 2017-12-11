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

            if ( !field.get(o).getClass().equals(String.class) || !field.get(o).getClass().equals(Integer.class)) {

                System.out.println(field.getName());
                System.out.println(field.get(o));
            }
            else {
                for (Field field1: field.getClass().getDeclaredFields()) {
                    reflection(field1.get(field));

                }
            }

        }
        return fields;
    }
}
