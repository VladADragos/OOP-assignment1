package carsnstuff.interfaces;

public interface IVehicle {
     void flipDir();
     void move();
     void gas(double amount);
     void brake(double amount);
     void startEngine();
     void stopEngine();
}
