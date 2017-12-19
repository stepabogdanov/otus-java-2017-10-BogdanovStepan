package newJson;

import java.lang.reflect.Field;

public interface FieldParserNew {

    String parse (Field field, Object o) throws IllegalAccessException;

    //Integer parse (Field field, Object o) throws IllegalAccessException;


}
