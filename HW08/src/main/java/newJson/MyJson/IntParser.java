package newJson.MyJson;

import java.lang.reflect.Field;

class IntParser {

    Integer parse(Field field, Object o) {
        if (field.getType().equals(int.class) ||
            field.getType().equals(Integer.class)) {
            return (Integer) o;
        }
        return null;
    }
}
