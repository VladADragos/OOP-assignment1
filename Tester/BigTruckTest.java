import org.junit.Test;
import javax.annotation.processing.SupportedSourceVersion;
import java.awt.*;
import java.util.zip.CheckedOutputStream;

import static org.junit.Assert.*;
import carsnstuff.*;
// all tests done 02-10-22.46
public class BigTruckTest {

    BigTruck bigTruck = new BigTruck();

    // Car car = new Car(4, Color.BLACK,100,"car");

    @Test
    public void addCar() {
        Volvo240 volvo = new Volvo240();
        bigTruck.setRampIsDown(true);
        bigTruck.addCar(volvo);
        assertTrue(bigTruck.getFlak().contains(volvo));
    }

    @Test
    public void removeCar() {
        Volvo240 volvo = new Volvo240();
        bigTruck.setRampIsDown(true);
        bigTruck.addCar(volvo);
        bigTruck.removeCar();
        assertFalse(bigTruck.getFlak().contains(volvo));
    }

    @Test
    public void move() {
        Volvo240 volvo = new Volvo240();
        bigTruck.setRampIsDown(true);
        bigTruck.addCar(volvo);
        System.out.println(bigTruck.getFlak());
        bigTruck.move();
        assertEquals(bigTruck.getPosition().getY(), bigTruck.getFlak().poll().getPosition().getY(), 0);
    }

    @Test
    public void setRampIsDown() {
        bigTruck.setRampIsDown(true);
        assertTrue(bigTruck.getRampIsDown());
    }
}