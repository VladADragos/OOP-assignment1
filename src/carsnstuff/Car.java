package carsnstuff;

import java.awt.*;
import java.util.Vector;

/**
 * Car superclass that other cars inherit from
 */
public abstract class Car extends Vehicle {
    private boolean transportMode = false;

    /**
     * Car constructor
     * 
     * @param nrDoors     number of doors
     * @param color       the color
     * @param enginePower the engine power
     * @param modelName   the model name
     */
    Car(int nrDoors, Color color, int enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        stopEngine();
    }

    void beingTransported() {
        stopEngine();
        transportMode = true;
    }

    void notBeingTransported() {
        transportMode = false;
    }

    @Override
    public void move() {
        if (!transportMode) {
            super.move();
        }
    }

    @Override
    public void turnLeft() {
        if (!transportMode) {
            super.turnLeft();
        }
    }

    @Override
    public void turnRight() {
        if (!transportMode) {
            super.turnRight();
        }
    }

}
