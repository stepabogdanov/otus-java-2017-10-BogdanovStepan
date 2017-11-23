package BigProgramm;

import MyTestFramework.TestApps;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Begin {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {

        Class [] classes = new Class[] {BigProgramm.class};

        TestApps.runTests(classes);
    }
}
