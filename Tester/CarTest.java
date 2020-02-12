import jdk.jfr.Description;
import org.junit.Test;
import  org.junit.Assert;
import  org.junit.Test;
import static org.junit.Assert.*;
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

    int testNrDoors = 3;
    Color testColor = Color.BLUE;
    int testEnginePower = 100;
    String testModelName = "car";

    Car testCar = new Car(testNrDoors,testColor,testEnginePower,testModelName);


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

        Assert.assertEquals(car.getDir(),Dir.w);
    }

    @Test
    public void testMove(){
        car.startEngine();
        car.gas(1);
        car.move();

        Assert.assertEquals(car.getPosition().getY(),1.1,0);
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


    @Test
    public void getNrDoors() {
        Assert.assertEquals(testCar.getNrDoors(),testNrDoors);

    }

    @Test
    public void getEnginePower() {

        Assert.assertEquals(testCar.getEnginePower(),testEnginePower,0);
    }

    @Test
    public void getCurrentSpeed() {
        Car car = new Car(4,Color.BLACK,100,"car");
        car.startEngine();
        car.gas(1);


        Assert.assertTrue(car.getCurrentSpeed() ==1.1);

    }

    @Test
    public void getColor() {
        Assert.assertEquals(testCar.getColor(),testColor);
    }

    @Test
    public void setColor() {
        Color newTestColor = Color.BLACK;
        testCar.setColor(Color.BLACK);

        Assert.assertEquals(testCar.getColor(),newTestColor);
    }

    @Test
    public void startEngine() {
        testCar.startEngine();
        Assert.assertEquals(testCar.getCurrentSpeed(),0.1,0);
    }

    @Test
    public void stopEngine() {
        testCar.stopEngine();
        Assert.assertEquals(testCar.getCurrentSpeed(),0,0);
    }

    @Test
    public void incrementSpeed() {
        testCar.startEngine();
        testCar.incrementSpeed(1);
        Assert.assertEquals(testCar.getCurrentSpeed(),1.1,0);

    }

    @Test
    public void decrementSpeed() {
        testCar.startEngine();
        testCar.incrementSpeed(1);
        testCar.incrementSpeed(1);
        testCar.decrementSpeed(1);
        Assert.assertEquals(testCar.getCurrentSpeed(),1.1,0);
    }

    @Test
    public void move() {
        testCar.startEngine();
        testCar.gas(1);

        testCar.move();
        System.out.println(testCar.getPosition());

        Assert.assertEquals(testCar.getPosition().getY(),1.1,0);
    }

    @Test
    public void turnLeft() {
        testCar.turnLeft();
        assertEquals(testCar.getDir(),Dir.w);
    }

    @Test
    public void turnRight() {
        testCar.turnRight();
        assertEquals(testCar.getDir(),Dir.e);
    }

    @Test
    public void gas() {
        testCar.startEngine();
        testCar.gas(1);

        assertEquals(testCar.getCurrentSpeed(),1.1,0);
    }

    @Test
    public void brake() {
        testCar.startEngine();
        testCar.incrementSpeed(1);
        testCar.incrementSpeed(1);
        testCar.decrementSpeed(1);
        Assert.assertEquals(testCar.getCurrentSpeed(),1.1,0);
    }

    @Test
    public void speedFactor() {
        assertEquals(car.speedFactor(),1,0);
    }

    @Test
    public void getPosition() {
        assertEquals(testCar.position.getPosition().getY(),0,0);
        assertEquals(testCar.position.getPosition().getX(),0,0);
    }
}