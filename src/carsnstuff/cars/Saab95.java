package carsnstuff.cars;

import java.awt.*;

/**
 * Saab95 class that inherits from car
 */
public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * Saab constructor
     */
    public Saab95() {
        super(2, Color.red, 125, "Saab95");
        turboOn = false;
    }

    /**
     * turns the turbo of Saab on
     */
    public void setTurboOn() {
        turboOn = true;
        System.out.println("turbo on");
    }

    /**
     * turns the turbo of the Saab off
     */
    public void setTurboOff() {
        turboOn = false;
        System.out.println("turbo off");
    }

    /**
     * Calculates and returns speedFactor
     * 
     * @return speedFactor
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn)
            turbo = 1.3;
        return super.speedFactor() * turbo;
    }

    /**
     * for testing purposes:
     * 
     * @return boolean
     */
    public boolean getTurboOn() {
        return turboOn;
    }

}
