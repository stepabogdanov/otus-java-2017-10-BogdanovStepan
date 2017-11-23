package TestPack;


import MyTestFramework.Annotaions.After;
import MyTestFramework.Annotaions.Before;
import MyTestFramework.Annotaions.Test;
import MyTestFramework.TestApps;


public class BigProgrammTest {
    private BigProgramm instance;
    private BigProgramm instanceDev;

    @Before
    public void initialize () {
        instance = new BigProgramm(2, 3);
    }

    @Before
    public void InitializeDev() {
        instanceDev = new BigProgramm(10,2);
    }

    @After
    public void unInitialize() {
        instance = null;
    }

    @After
    public void unInitializeDev() {
        instance = null;
    }

    @Test
    public void testSum() {
       TestApps.assertEquals(5, instance.sum());
    }

    @Test
    public void testDev() {
        TestApps.assertEquals(5, instanceDev.dev());
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