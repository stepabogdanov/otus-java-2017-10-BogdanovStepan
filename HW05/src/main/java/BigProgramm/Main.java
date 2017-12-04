package BigProgramm;

import MyTestFramework.TestApps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Class> classes0 = getClasses(Main.class.getClassLoader(), "TestPack");
        List<Class> classes1 = getClasses(Main.class.getClassLoader(), "BigProgramm");
        List<Class> classes2 = getClasses(Main.class.getClassLoader(), "MyTestFramework");
        List<Class> classes3 = getClasses(Main.class.getClassLoader(), "MyFramework");

        TestApps.runTests(classes0);
        TestApps.runTests(classes1);
        TestApps.runTests(classes2);
        TestApps.runTests(classes3);

        //printClasses("BigProgramm");


    }

    static void printClasses(String pack) {
        List<Class> classes = getClasses(Main.class.getClassLoader(), pack);
        for (Class c : classes) {
            System.out.println("Class: " + c);
        }
    }

    private static List<Class> getClasses(ClassLoader cl, String pack) {

        String dottedPackage = pack.replaceAll("[/]", ".");
        List<Class> classes = new ArrayList<>();
        URL upackage = cl.getResource(pack);

        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader((InputStream) upackage.getContent()));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.endsWith(".class")) {
                    classes.add(Class.forName(dottedPackage + "." + line.substring(0, line.lastIndexOf('.'))));
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
            catch (NullPointerException ex) {
                System.out.println("package not found");
            }

        return classes;
    }
}
    ///

