import java.awt.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Bigtruck class
 */
public class BigTruck extends Car {
    /**
     * Represents the cars on the truck
     */
    Queue<Car> flak  = new ArrayDeque<Car>(0);

    /**
     * if the ramp is down or up
     */
    boolean rampIsDown = false;
    /**
     * the max number of cars that this truck can contain
     */
    int maxNumCars = 8;

    /**
     * Constructor
     */
    public BigTruck(){
        super(2, Color.BLACK,300,"Big truck");
    }

    /**
     * adds car on the truck
     * @param car the car to be added
     */
    public void addCar(Car car){
        // enginepower used for size
        if(rampIsDown && car.getEnginePower() < 300 && flak.size()<maxNumCars && car.hashCode() != this.hashCode()){
            flak.add(car);
        }


    }

    /**
     * removes car from truck
     * @return returns the car if it exists on the truck else returns null
     */
    public Car removeCar(){
        if(rampIsDown && flak.size()>0) {
            Car car = flak.peek();
            flak.remove();
            car.position.setPosition(this.position.getX() + 50, this.position.getY() + 50);
            return car;
        }
        return  null;
    }

    /**
     * moves the truck
     */
    @Override
    public void move(){
        switch (dir){
            case n:
                position.setY(position.getY()-getCurrentSpeed());
                break;
            case s:
                position.setY(position.getY()+getCurrentSpeed());
                break;
            case e:
                position.setX(position.getX()+getCurrentSpeed());
                break;
            case w:
                position.setX(position.getX()-getCurrentSpeed());
                break;
        }
        for(Car c : flak){
            c.position.setPosition(this.position.getY(),this.position.getX());
        }
    }

    public void setRampIsDown(boolean rampIsDown) {
        this.rampIsDown = rampIsDown;
    }
}



