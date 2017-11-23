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


    public static void runTests(Class[] clazz) throws IllegalAccessException,
                                                    InstantiationException,
                                                    InvocationTargetException {

        List <Method> methodsList;
        Object object;

        for (Class testClass: clazz) {
            methodsList = Arrays.asList(testClass.getDeclaredMethods());

            System.out.println(testClass.getName());

            for (Method methodTest : methodsList) {
                for (Annotation annotationT : methodTest.getDeclaredAnnotations()) {
                    if (annotationT.annotationType().equals(Test.class)) {
                        object = testClass.newInstance();

                        for (Method methodBefore : methodsList) {
                            for (Annotation annotationB : methodBefore.getDeclaredAnnotations()) {
                                if (annotationB.annotationType().equals(Before.class)) {
                                    methodBefore.invoke(object);
                                }
                            }
                        }
                        System.out.print("method: " + methodTest.getName());
                        methodTest.invoke(object);

                        for (Method methodAfter : methodsList) {
                            for (Annotation annotationA : methodAfter.getDeclaredAnnotations()) {
                                if (annotationA.annotationType().equals(After.class)) {
                                    methodAfter.invoke(object);

                                }
                            }
                        }

                    }
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
