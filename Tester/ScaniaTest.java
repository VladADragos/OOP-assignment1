import org.junit.Test;

import static org.junit.Assert.*;

public class ScaniaTest {

    Scania scania = new Scania();

    @Test
    public void incrementFlak() {
        scania.incrementFlak();
        assertEquals(scania.getFlakAngle(),1,0);

        for(int i=0;i<70;i++){
            scania.incrementFlak();
        }
        assertTrue(scania.getFlakAngle()<=70);
    }

    @Test
    public void decrementFlak() {
        scania.incrementFlak();
        scania.incrementFlak();
        scania.decrementFlak();
        assertEquals(scania.getFlakAngle(),1,0);
        scania.decrementFlak();
        scania.decrementFlak();
        assertEquals(scania.getFlakAngle(),0,0);
    }

    @Test
    public void gas() {
        scania.startEngine();
        scania.gas(1);
        assertEquals(scania.getCurrentSpeed(),2.1,0);

    }

    @Test
    public void brake() {
        scania.startEngine();
        scania.gas(1);
        scania.gas(1);
        scania.brake(1);
        assertEquals(scania.getCurrentSpeed(),2.1,0.1);


    }

    @Test
    public void getFlakAngle() {
        assertEquals(scania.getFlakAngle(),0,0);
    }
}