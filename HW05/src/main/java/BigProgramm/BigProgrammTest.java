package BigProgramm;


import MyTestFramework.Annotaions.Before;
import MyTestFramework.Annotaions.Test;
import MyTestFramework.TestApps;


public class BigProgrammTest {
    BigProgramm instance;

    @Before
    public void initialize () {
        instance = new BigProgramm(2, 3);
    }


    @Test
    public void testSum() {
        //instance = new BigProgramm(2, 3);
        TestApps.assertEquals(5, instance.sum());

    }

    @Test
    public void testDev() {
        BigProgramm instanceOne = new BigProgramm(10, 2);
        TestApps.assertEquals(5, instanceOne.dev());

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