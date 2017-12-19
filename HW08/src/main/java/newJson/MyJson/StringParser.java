package newJson.MyJson;

import java.lang.reflect.Field;

class StringParser  {

    String parse(Field field, Object o)  {
        if (field.getType().equals(String.class)) {

            return (String) o;
        }

        return null;
    }
}

