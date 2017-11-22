package BigProgramm;


import MyTestFramework.Annotaions.Test;
import MyTestFramework.TestApps;


public class BigProgrammTest {

    @Test
    public void testSum() {
        BigProgramm instanceOne = new BigProgramm(2, 3);
        TestApps.assertEquals(5, instanceOne.sum());

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