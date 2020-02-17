import java.awt.*;

/**
 * Saab95 class that inherits from car
 */
public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * Saab constructor
     */
    Saab95() {
        super(2, Color.red, 125, "Saab95");
        turboOn = false;
    }

    /**
     * turns the turbo of Saab on
     */
    void setTurboOn() {
        turboOn = true;
    }

    /**
     * turns the turbo of the Saab off
     */
    void setTurboOff() {
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
        return super.speedFactor() * turbo;
    }



    /**
     * for testing purposes:
     * @return boolean
     */
    boolean getTurboOn(){
        return this.turboOn;
    }

}


