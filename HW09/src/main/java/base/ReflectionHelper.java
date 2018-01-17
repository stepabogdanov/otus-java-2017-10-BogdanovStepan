package base;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectionHelper {

    private static List<Field> fieldList = new ArrayList<>();

    public static List<Field> getAllFields(Object object) throws IllegalAccessException, InstantiationException {

        boolean fieldAccessible = false;

            for (Field field : object.getClass().getDeclaredFields()) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                    fieldAccessible = true;
                }
                fieldList.add(field);
                if (fieldAccessible) {
                    field.setAccessible(false);
                }
            }

        return fieldList;
    }

}
