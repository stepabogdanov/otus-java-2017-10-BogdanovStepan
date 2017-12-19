package newJson.MyJson;

import javax.json.JsonArrayBuilder;
import java.lang.reflect.Field;

class Parser {
    private Field field;
    private Object o;

    Parser (Field field, Object o) {
    this.field = field;
    this.o = o;
    }

    String executeString() throws IllegalAccessException {
        StringParser stringParser = new StringParser();
        String string = stringParser.parse(field, o);

        if (string != null) {
            return string;
        }
        return null;
    }
    Integer executeInt() throws IllegalAccessException {
        IntParser intParser = new IntParser();
        Integer value = intParser.parse(field, o);

        if (value != null) {
            return value;

        }
        return null;
    }
    JsonArrayBuilder executeArray () throws IllegalAccessException {
        JsonArrayBuilder jsonArrayBuilderArr;
        JsonArrayBuilder jsonArrayBuilderList;
        ArrayParser arrayParser = new ArrayParser();
        ListParser listParser = new ListParser();

        jsonArrayBuilderArr = arrayParser.parse(field, o);
        jsonArrayBuilderList = listParser.parse(field, o);

        if (jsonArrayBuilderArr != null) {
            return jsonArrayBuilderArr;
        }
        if (jsonArrayBuilderList != null) {
            return jsonArrayBuilderList;
        }
        return null;
    }

}
