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
    }

    /**
     * turns the turbo of the Saab off
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Calculates and returns speedFactor
     * @return speedFactor
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn)
            turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    /**
     * increases the speed of the car
     * @param amount how much the speed of the car should be increased
     */
    public void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * decreases the speed of the car
     * @param amount how much the speed of the car should be decreased
     */
    public void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }



}


