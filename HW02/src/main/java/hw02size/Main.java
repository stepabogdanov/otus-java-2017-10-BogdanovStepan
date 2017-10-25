package hw02size;

import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InstantiationException,
            IllegalAccessException,
            InterruptedException, NoSuchMethodException, InvocationTargetException {
        Object object = new Object();
        String stringPoll = new String("");
        String string = new String(new char[0]);
        Integer integer = new Integer(0);
        MyClass myClass = new MyClass();
        List<Integer> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        int[] array = new int[0];

        MeasureObjects.measureSizeObject(object);
        MeasureObjects.measureSizeObject(string);
        MeasureObjects.measureSizeObject(stringPoll);
        MeasureObjects.measureSizeObject(integer);
        MeasureObjects.measureSizeObject(array);
        MeasureObjects.measureSizeObject(myClass);
        MeasureObjects.measureSizeObject(list);
        MeasureObjects.measureConteiner(list,10);
        MeasureObjects.measureSizeObject(map);
        MeasureObjects.measureConteiner(map, 20);

    }

}
