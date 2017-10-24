package hw02size;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MeasureObjects {

    static void MeasureSize (Object object) throws IllegalAccessException,
            InstantiationException, InterruptedException {
        final int SIZE = 20_000_000;
        long memBefore = 0, memAfter = 0, sizeOfObject = 0;
        Runtime runtime = Runtime.getRuntime();
        boolean loop = true;
        Class clazz = object.getClass();

        System.out.println("total memory before: " + runtime.totalMemory());
        System.out.println("free memory before:  " + runtime.freeMemory());
        while (loop) {
            Object [] arrayOfObjects = new Object[SIZE];
            System.gc();
            Thread.sleep(1000);
            memBefore = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("used memory before:   " + memBefore);
            for (int i = 0; i < SIZE; i++) {
                arrayOfObjects[i]  = clazz.newInstance();  // правильно ли таким образом создавать объект
                }
            memAfter = runtime.totalMemory() - runtime.freeMemory();
            loop = false;
        }
        System.gc();
        Thread.sleep(1000);
        sizeOfObject = (memAfter - memBefore) /SIZE;
        System.out.println("-----------------------------");
        System.out.println("used memory after:   " + memAfter);
        System.out.println("free memory after:   " + runtime.freeMemory());
        System.out.println("total memory after:  " + runtime.totalMemory());

        System.out.println("Object class name: " + clazz.getName());
        if (sizeOfObject%8 == 0){
            System.out.println("size of object: " + sizeOfObject);
        }
        else {
            sizeOfObject = ((sizeOfObject/8) * 8) + 8;
            System.out.println("size of object: " + sizeOfObject);
        }
        System.out.println();
    }
}
