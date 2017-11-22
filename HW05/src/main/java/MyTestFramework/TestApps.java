package MyTestFramework;

import MyTestFramework.Annotaions.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestApps {


   public static void runTests(Class clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
       Annotation[] annotations;
       Constructor[] constructors;
       List <Method> methodslist = new ArrayList<>();
       Object object = new Object();

       annotations = clazz.getDeclaredAnnotations();

       for (Annotation annotation: annotations) {
           System.out.println(annotation.toString());
          //object = clazz.newInstance();

       }
       constructors = clazz.getDeclaredConstructors();
       for (Constructor constructor : constructors) {
          //constructor.newInstance();
       }

       methodslist = Arrays.asList(clazz.getDeclaredMethods());
       for (Method method : methodslist) {
           System.out.println(method.getName());
           object = clazz.newInstance();
           method.invoke(object);
       }

    }

    public static void assertEquals (int a, int b) {
       boolean val;
       val = (a == b);
       if (val) {
           System.out.println(val);
       }
       else {
           System.out.println(val=false);
       }
           //throw new RuntimeException ();
    }

}
