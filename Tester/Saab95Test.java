import org.junit.Test;

import static org.junit.Assert.*;
// all tests done 02-10-22:17
public class Saab95Test {
    Saab95 saab = new Saab95();
    @Test
    public void setTurboOn() {
        saab.setTurboOn();
        assertTrue(saab.getTurboOn());
    }

    @Test
    public void setTurboOff() {
        saab.setTurboOn();

        saab.setTurboOff();
        assertFalse(saab.getTurboOn());
    }

    @Test
    public void speedFactor() {
        double exp = saab.getEnginePower() * 0.01 * 1;
        assertEquals(saab.speedFactor(),exp,0);
    }

    @Test
    public void incrementSpeed() {
        saab.startEngine();
        saab.incrementSpeed(1);

        assertEquals(saab.getCurrentSpeed(),1.35,0);
    }

    @Test
    public void decrementSpeed() {
        saab.startEngine();
        saab.incrementSpeed(2);
        saab.decrementSpeed(1);

        assertEquals(saab.getCurrentSpeed(),1.35,0);
    }
}