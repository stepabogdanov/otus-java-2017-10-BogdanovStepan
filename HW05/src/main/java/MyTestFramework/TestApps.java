package MyTestFramework;

import MyTestFramework.Annotaions.After;
import MyTestFramework.Annotaions.Before;
import MyTestFramework.Annotaions.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestApps {


    public static void runTests(Class clazz) throws IllegalAccessException,
                                                    InstantiationException,
                                                            InvocationTargetException {
        Annotation[] annotations;
        Constructor[] constructors;
        List <Method> methodsList;
        Object object = null;

        annotations = clazz.getDeclaredAnnotations();

        for (Annotation annotation: annotations) {
           System.out.println(annotation.toString());
          //object = clazz.newInstance();

        }
        constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
          //constructor.newInstance();
        }

        methodsList = Arrays.asList(clazz.getDeclaredMethods());

        for (Method methodBefore : methodsList) {
            for (Annotation annotation : methodBefore.getDeclaredAnnotations()) {

                if (annotation.annotationType().equals(Before.class)) {
                    object = clazz.newInstance();
                    methodBefore.invoke(object);
                    System.out.println("Before done!");
                }
            }
        }

            for (Method methodTest : methodsList) {
                for (Annotation annotation : methodTest.getDeclaredAnnotations()) {
                    if (annotation.annotationType().equals(Test.class)) {
                        Object testObjest = clazz.newInstance();
                        //testObjest = object;

                        System.out.print("method: " + methodTest.getName());
                        methodTest.invoke(testObjest);
                        object = null;
                    }
                }
            }
                for (Method methodAfter : methodsList) {
                    for (Annotation annotation : methodAfter.getDeclaredAnnotations()) {
                        if (annotation.annotationType().equals(After.class)) {
                            object = clazz.newInstance();
                            methodAfter.invoke(object);
                        }
                    }
                }


    }

    public static void assertEquals (int a, int b) {
        boolean val;
        val = (a == b);
        if (val) {
            System.out.print(" testResult: PASSED\n");
        }
        else {
            System.out.print(" testResult: FAILED!!!\n");
            //throw new RuntimeException ();
        }
    }

    public static void assertEquals (String a, String b) {
       boolean val;
       val = (a.equals(b));
       if (val) {
           System.out.print(" testResult: PASSED\n");
       }
       else {
           System.out.print(" testResult: FAILED!!!\n");
           //throw new RuntimeException ();
       }
    }
}
