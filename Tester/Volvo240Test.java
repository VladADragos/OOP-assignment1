import org.junit.Test;

import static org.junit.Assert.*;

public class Volvo240Test {
    Volvo240 volvo = new Volvo240();
    @Test
    public void speedFactor() {
        double expectedSpeedFactor = volvo.getEnginePower() * 0.01 * 1.25;
        assertEquals(volvo.speedFactor(),expectedSpeedFactor,0);
    }

    @Test
    public void incrementSpeed() {
        volvo.startEngine();
        volvo.incrementSpeed(1);

        assertEquals(volvo.getCurrentSpeed(),1.35,0);
    }

    @Test
    public void decrementSpeed() {
        volvo.startEngine();
        volvo.incrementSpeed(2);
        volvo.decrementSpeed(1);

        assertEquals(volvo.getCurrentSpeed(),1.35,0);
    }

}