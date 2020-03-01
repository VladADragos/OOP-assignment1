package carsnstuff.trucks;

import carsnstuff.Vehicle;

import java.awt.*;

abstract class Truck extends Vehicle {
    Truck(int nrDoors, Color color, int enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
}
