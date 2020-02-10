import java.awt.*;

/**
 * Volvo240 class that inherits from car
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    /**
     * Volvo constructor
     */
    public Volvo240() {
        super(4, Color.black, 100, "Volvo240");

    }

    /**
     * Calculates and returns speedFactor
     * @return speedFactor
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
    /**
     * increases the speed of the car
     * @param amount how much the speed of the car should be increased
     */
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    /**
     * decreases the speed of the car
     * @param amount how much the speed of the car should be decreased
     */
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

}
