package base;

import java.lang.reflect.InvocationTargetException;

public class Example {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException,
                                        NoSuchMethodException, InvocationTargetException {

        Class c = Class.forName(String.class.getCanonicalName());
        Class w = Class.forName(UserDataSet.class.getCanonicalName());
        System.out.println(UserDataSet.class.getCanonicalName());
        Object o = w.getConstructor().newInstance();
    }

}
