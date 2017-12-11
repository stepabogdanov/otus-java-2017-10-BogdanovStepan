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
            //System.out.println(field.getName());
            System.out.println(field.get(o).getClass());

        }
        return fields;
    }
}
