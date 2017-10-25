package hw02size;
import java.lang.reflect.InvocationTargetException;

public class MeasureObjects {

    private final static int SIZE = 20_000_000;
    private static Class clazz;
    private static long memBefore = 0, memAfter = 0, sizeOfObject = 0;
    private static Runtime runtime;

    public static void measureSizeObject(Object object) throws IllegalAccessException,
            InstantiationException, InterruptedException, NoSuchMethodException, InvocationTargetException {

        runtime = Runtime.getRuntime();
        boolean loop = true;
        clazz = object.getClass();

        System.out.println("total memory before: " + runtime.totalMemory());
        System.out.println("free memory before:  " + runtime.freeMemory());

        if (clazz.isArray()) {
            allocateMemoryArray();

        } else if (clazz.equals(String.class)) {
            allocateMemory(clazz, "");

        } else if (clazz.equals(Integer.class)) {
            allocateMemory(1);
        }
        else {
            allocateMemory();
        }

        System.gc();
        Thread.sleep(1000);
        sizeOfObject = (memAfter - memBefore) / SIZE;
        System.out.println("-----------------------------");
        System.out.println("used memory after:   " + memAfter);
        System.out.println("free memory after:   " + runtime.freeMemory());
        System.out.println("total memory after:  " + runtime.totalMemory());
        System.out.println("Object class name: " + clazz.getName());

        if (sizeOfObject % 8 == 0) {
            System.out.println("size of object: " + sizeOfObject);
        } else {
            sizeOfObject = ((sizeOfObject / 8) * 8) + 8;
            System.out.println("size of object: " + sizeOfObject);
        }
        System.out.println();

    }

    public static void measureConteiner (Object object, int initialCapacity) throws
                                        InterruptedException, IllegalAccessException,
                                        InstantiationException, NoSuchMethodException,
                                        InvocationTargetException {
        runtime = Runtime.getRuntime();
        boolean loop = true;
        clazz = object.getClass();

        System.out.println("total memory before: " + runtime.totalMemory());
        System.out.println("free memory before:  " + runtime.freeMemory());

        allocateMemory(initialCapacity);


        System.gc();
        Thread.sleep(1000);
        sizeOfObject = (memAfter - memBefore) / SIZE;
        System.out.println("-----------------------------");
        System.out.println("used memory after:   " + memAfter);
        System.out.println("free memory after:   " + runtime.freeMemory());
        System.out.println("total memory after:  " + runtime.totalMemory());
        System.out.println("Object class name: " + clazz.getName() +  " initialCapacity: " + initialCapacity);

        if (sizeOfObject % 8 == 0) {
            System.out.println("size of object: " + sizeOfObject);
        } else {
            sizeOfObject = ((sizeOfObject / 8) * 8) + 8;
            System.out.println("size of object: " + sizeOfObject);
        }
        System.out.println();

    }

    private static void allocateMemory(Class clazz, String instanceParam) throws InterruptedException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException {
        boolean loop = true;
        while (loop) {
            Object[] arrayOfObjects = new Object[SIZE];
            System.gc();
            Thread.sleep(1000);
            memBefore = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("used memory before:   " + memBefore);
            for (int i = 0; i < SIZE; i++) {
                arrayOfObjects[i] = clazz.getConstructor(clazz).newInstance(instanceParam);
            }
            memAfter = runtime.totalMemory() - runtime.freeMemory();
            loop = false;

        }
    }
    private static void allocateMemory(int instanceParam) throws InterruptedException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException {
        boolean loop = true;
        while (loop) {
            Object[] arrayOfObjects = new Object[SIZE];

            System.gc();
            Thread.sleep(1000);
            memBefore = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("used memory before:   " + memBefore);

            for (int i = 0; i < SIZE; i++) {
                arrayOfObjects[i] = clazz.getConstructor(int.class).newInstance(instanceParam);
            }

            memAfter = runtime.totalMemory() - runtime.freeMemory();
            loop = false;

        }
    }

    private static void allocateMemory() throws InterruptedException, IllegalAccessException, InstantiationException {
        boolean loop = true;
        while (loop) {
            Object[] arrayOfObjects = new Object[SIZE];
            System.gc();
            Thread.sleep(1000);
            memBefore = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("used memory before:   " + memBefore);
            for (int i = 0; i < SIZE; i++) {
                arrayOfObjects[i] = clazz.newInstance();             // правильно ли таким образом создавать объект
            }
            memAfter = runtime.totalMemory() - runtime.freeMemory();
            loop = false;

        }
    }

    private static void allocateMemoryArray() throws InterruptedException{
        boolean loop = true;
        while (loop) {
            Object[] arrayOfObjects = new Object[SIZE];
            System.gc();
            Thread.sleep(1000);
            memBefore = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("used memory before:   " + memBefore);
            for (int i = 0; i < SIZE; i++) {
                arrayOfObjects[i] = new int[0];
            }
            memAfter = runtime.totalMemory() - runtime.freeMemory();
            loop = false;

        }
    }
}
