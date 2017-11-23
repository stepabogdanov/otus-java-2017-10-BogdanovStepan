package BigProgramm;


import MyTestFramework.Annotaions.After;
import MyTestFramework.Annotaions.Before;
import MyTestFramework.Annotaions.Test;
import MyTestFramework.TestApps;


public class BigProgrammTest {
    BigProgramm instance;
    BigProgramm instanceDev;

    @Before
    public void initialize () {
        instance = new BigProgramm(2, 3);
    }


    @After
    public void unInitialize() {
        instance = null;
    }

    @Test
    public void testSum() {
       // instance = new BigProgramm(2, 3);
        TestApps.assertEquals(5, instance.sum());

    }

    @Before
    public void InitializeDev() {
        instanceDev = new BigProgramm(10,2);
    }

    @Test
    public void testDev() {
        //BigProgramm instanceOne = new BigProgramm(10, 2);
        TestApps.assertEquals(5, instanceDev.dev());
    }

    @After
    public void unInitializeDev() {
        instance = null;
    }

    @Test
    public void testSub() {
        BigProgramm instanceOne = new BigProgramm(2, 3);
        TestApps.assertEquals(-1, instanceOne.sub());

    }

    @Test
    public void testMulty() {
        BigProgramm instancOne = new BigProgramm(2, 3);
        TestApps.assertEquals(6, instancOne.multy());

    }
}