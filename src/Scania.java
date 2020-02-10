import java.awt.*;
/*
 * Flak cars that can pick up cars
 *
 * */
public class Scania extends Car {
    /**
     * angle of ramp
     */
    double flak;

    /**
     * default constructor
     */
    Scania(){
        super(2, Color.BLACK,200,"Scania");
    }


    /**
     * increases the angle of ramp
     */
    public void incrementFlak(){
        if(flak<70&&getCurrentSpeed() ==0)
            flak++;


    }

    /**
     * decreace the angle of the ramp
     */
    public void decrementFlak(){
        if(flak>0 && getCurrentSpeed()==0)
            flak--;
    }

    /**
     * an overriden function over the inherited car class that accelerates the car
     * @param amount acceleration amount 0,1(double)
     */
    @Override
    public void gas(double amount) {
        if(amount >= 0 && amount <= 1 && flak == 0)
            incrementSpeed(amount);

    }

    /**
     * an overriden function over the inherited car class that deaccelerates the car
     * @param amount amount of slow, must be between 0,1(double)
     */
    @Override
    public void brake(double amount){
        if(amount >= 0 && amount <= 1 && flak == 0)
            decrementSpeed(amount);

    }

    /**
     * gets flak
     * @return flak
     */
    public double getFlak(){
        return flak;
    }


}
