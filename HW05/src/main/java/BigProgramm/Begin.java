package BigProgramm;

import MyTestFramework.TestApps;

import java.lang.reflect.InvocationTargetException;

public class Begin {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
       // List<Class> list = new ArrayList<>();
       // list.add(BigProgrammTest.class);
        //BigProgrammTest bigProgrammTest = new BigProgrammTest();
        TestApps.runTests(BigProgrammTest.class);
    }
}
