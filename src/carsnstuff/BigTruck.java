package carsnstuff;

import java.awt.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Bigtruck class
 */

public class BigTruck extends Truck {

    Queue<Car> flak = new ArrayDeque<Car>(0);
    boolean rampIsDown = false;
    private int maxNumCars = 8;

    /**
     * constructor
     */
    public BigTruck() {
        super(2, Color.BLACK, 300, "Big truck");
    }

    /**
     * adds car on the truck
     * 
     * @param car the car to be added
     */
    // TODO consider how to block big truck
    // done?
    public void addCar(Car car) {
        // TODO make car not able to move
        // done?
        if (rampIsDown && car.getEnginePower() < 300 && flak.size() < maxNumCars && car.hashCode() != this.hashCode()
                && position.isClose(car.getPosition(), 50)) {
            car.beingTransported();
            flak.add(car);
        }
    }

    /**
     * removes car from truck
     * 
     * @return returns the car if it exists on the truck else returns null
     */
    public Car removeCar() {
        if (rampIsDown && flak.size() > 0) {
            Car car = flak.peek();
            flak.remove();
            car.position.setPosition(this.position.getX() + 50, this.position.getY() + 50);
            car.notBeingTransported();
            return car;
        }
        return null;
    }

    /**
     * moves the truck
     */
    @Override
    public void move() {
        if (rampIsDown) {
            super.move();
            for (Car c : flak) {
                // TODO change to protected
                c.position.setPosition(this.position.getY(), this.position.getX());
            }
        }

    }

    /**
     * for testing
     * 
     * @param rampIsDown boolean
     */
    public void setRampIsDown(boolean rampIsDown) {
        this.rampIsDown = rampIsDown;
    }

    public Queue<Car> getFlak() {
        return flak;
    }

    public boolean getRampIsDown(){
        return rampIsDown;
    }
}
