package newJson;

import java.lang.reflect.Field;

public interface FieldParser {
    <T> T parse(Field field, Object o) throws IllegalAccessException;
}
