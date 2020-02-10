import jdk.jfr.Description;
import org.junit.Test;
import  org.junit.Assert;
import  org.junit.Test;

import java.awt.*;

/**
 * Test class
 */
public class CarTest {

    Saab95 saab = new Saab95();
    Volvo240 volvo = new Volvo240();
    BigTruck bigTruck = new BigTruck();
    Scania scania = new Scania();
    Car car = new Car(2, Color.BLACK,100,"car");

    public static void main(String[] args) {
        System.out.println("test");
    }

    //@Test
    //public void  saabGasTest(){
        // should not
        //Assert.assertTrue(saab.getCurrentSpeed()>0);

    //}


    @Test
    @Description("The speed of a car should be between 0 and enginePower")
    public void speedTestGreaterThan0(){
        saab.startEngine();
        saab.setTurboOn();
        saab.gas(1);
        saab.gas(1);

        for(int i = 0; i<100;i++){
            saab.brake(1);
        }

        Assert.assertTrue(saab.getCurrentSpeed() >= 0 && saab.getCurrentSpeed()<=saab.getEnginePower());
    }

    @Test
    @Description("The speed of a car should be between 0 and enginePower")
    public void speedTestLessThanEnginePower(){
        saab.startEngine();
        saab.setTurboOn();

        for(int i = 0; i<100;i++){
            saab.gas(.9);
        }

        Assert.assertTrue(saab.getCurrentSpeed()<=saab.getEnginePower());
    }

    @Test
    public  void testTurn(){
        car.turnLeft();

        Assert.assertEquals(car.dir,Dir.w);
    }

    @Test
    public void testMove(){
        car.startEngine();
        car.gas(1);
        car.move();
        Assert.assertEquals(car.getPosition().y,1);
    }


    // test for lab2

    @Test
    @Description("tests that the angle of the flak is less than or equal to 70")
    public void testAngleLessThan70(){
        for (int i=0; i<71;i++){
            scania.incrementFlak();
        }
        Assert.assertTrue(scania.getFlak()<=70);
    }

    @Test
    @Description("asserts that you cant add bigtruck to bigtruck")
    public void testCantAddBigTruckToBigTruck(){
        bigTruck.addCar(bigTruck);
        Assert.assertTrue(bigTruck.flak.size() == 0);
    }

    @Test
    public  void testMaxCars(){
        bigTruck.setRampIsDown(true);
        bigTruck.flak.add(new Saab95());
        bigTruck.flak.add(new Volvo240());
        System.out.println(bigTruck.flak);
        bigTruck.flak.remove();
        System.out.println(bigTruck.flak);



        //Assert.assertEquals(bigTruck.flak.size(),8);
    }





}