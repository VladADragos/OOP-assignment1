import org.junit.Test;

import javax.annotation.processing.SupportedSourceVersion;
import java.awt.*;
import java.util.zip.CheckedOutputStream;

import static org.junit.Assert.*;
// all tests done 02-10-22.46
public class BigTruckTest {

    BigTruck bigTruck = new BigTruck();

    Car car = new Car(4, Color.BLACK,100,"car");

    @Test
    public void addCar() {
        bigTruck.setRampIsDown(true);
        bigTruck.addCar(car);
        assertTrue(bigTruck.flak.contains(car));
    }

    @Test
    public void removeCar() {
        bigTruck.setRampIsDown(true);
        bigTruck.addCar(car);
        bigTruck.removeCar();
        assertFalse(bigTruck.flak.contains(car));
    }

    @Test
    public void move() {
        bigTruck.setRampIsDown(true);
        bigTruck.addCar(car);
        System.out.println(bigTruck.flak);
        bigTruck.move();
        assertEquals(bigTruck.position.getY(),bigTruck.flak.poll().position.getY(),0);
    }

    @Test
    public void setRampIsDown() {
        bigTruck.setRampIsDown(true);
        assertTrue(bigTruck.rampIsDown);
    }
}