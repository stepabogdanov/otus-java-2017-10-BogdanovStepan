package MyTestFramework;

import MyTestFramework.Annotaions.After;
import MyTestFramework.Annotaions.Before;
import MyTestFramework.Annotaions.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class TestApps {

    public static void runTests(List<Class> clazz)  {

        List <Method> methodsList;
        Object object = null;

        for (Class testClass: clazz) {
            methodsList = Arrays.asList(testClass.getDeclaredMethods());

            System.out.println(testClass.getName());

            for (Method methodTest : methodsList) {
                for (Annotation annotationT : methodTest.getDeclaredAnnotations()) {
                    if (annotationT.annotationType().equals(Test.class)) {
                        try {
                            object = testClass.newInstance();
                        } catch (InstantiationException | IllegalAccessException ex) {
                            ex.printStackTrace();
                        }

                        for (Method methodBefore : methodsList) {
                            for (Annotation annotationB : methodBefore.getDeclaredAnnotations()) {
                                if (annotationB.annotationType().equals(Before.class)) {
                                    try {
                                        methodBefore.invoke(object);

                                    } catch ( IllegalAccessException | InvocationTargetException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        }
                        System.out.print("method: " + methodTest.getName());
                        try {
                            methodTest.invoke(object);
                        } catch (IllegalAccessException | InvocationTargetException ex) {
                            ex.printStackTrace();
                        }

                        for (Method methodAfter : methodsList) {
                            for (Annotation annotationA : methodAfter.getDeclaredAnnotations()) {
                                if (annotationA.annotationType().equals(After.class)) {
                                    try {
                                        methodAfter.invoke(object);
                                    } catch (IllegalAccessException | InvocationTargetException ex) {
                                        ex.printStackTrace();
                                    }

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
        }
    }
}
