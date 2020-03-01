package carsnstuff.trucks;

import java.awt.*;

/*
 * Flak cars that can pick up cars
 *
 * */
public class Scania extends Truck {
    /**
     * angle of ramp
     */
    double flakAngle;

    /**
     * default constructor
     */
    public Scania() {
        super(2, Color.BLACK, 200, "Scania");
    }

    /**
     * increases the angle of ramp
     */
    public void incrementFlak() {
        if (flakAngle < 70 && getCurrentSpeed() == 0){
            System.out.println("Lifting flak");
            flakAngle++;
        }

    }

    /**
     * decreace the angle of the ramp
     */
    public void decrementFlak() {
        if (flakAngle > 0 && getCurrentSpeed() == 0){
            System.out.println("Lowering flak");
            flakAngle--;
        }

    }

    /**
     * an overridden function over the inherited car class that accelerates the car,
     * overridden because Scania should not gas if flak is upp
     * 
     * @param amount acceleration amount 0,1(double)
     */
    @Override
    public void gas(double amount) {
        if (flakAngle == 0)
            super.gas(amount);
    }

    /**
     * an overriden function over the inherited car class that deaccelerates the car
     * overridden because Scania should not break if flak is upp
     * 
     * @param amount amount of slow, must be between 0,1(double)
     */
    @Override
    public void brake(double amount) {
        if (flakAngle == 0)
            super.brake(amount);

    }

    /**
     * gets flak
     * 
     * @return flak
     */
    public double getFlakAngle() {
        return flakAngle;
    }

}
