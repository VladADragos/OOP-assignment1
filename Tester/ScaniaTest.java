import org.junit.Test;

import static org.junit.Assert.*;

public class ScaniaTest {

    Scania scania = new Scania();

    @Test
    public void incrementFlak() {
        scania.incrementFlak();
        assertEquals(scania.getFlak(),1,0);

        for(int i=0;i<70;i++){
            scania.incrementFlak();
        }
        assertTrue(scania.getFlak()<=70);
    }

    @Test
    public void decrementFlak() {
        scania.incrementFlak();
        scania.incrementFlak();
        scania.decrementFlak();
        assertEquals(scania.getFlak(),1,0);
        scania.decrementFlak();
        scania.decrementFlak();
        assertEquals(scania.getFlak(),0,0);
    }

    @Test
    public void gas() {
        scania.startEngine();
        scania.gas(1);
        assertEquals(scania.getCurrentSpeed(),1.1,0);

    }

    @Test
    public void brake() {
        scania.startEngine();
        scania.gas(1);
        scania.gas(1);
        scania.brake(1);
        assertEquals(scania.getCurrentSpeed(),1.1,0);


    }

    @Test
    public void getFlak() {
        assertEquals(scania.getFlak(),0,0);
    }
}