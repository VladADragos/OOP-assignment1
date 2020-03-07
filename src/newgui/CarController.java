package newgui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import carsnstuff.*;
import carsnstuff.cars.Car;
import carsnstuff.cars.Saab95;
import carsnstuff.cars.Volvo240;
import carsnstuff.position.Dir;
import carsnstuff.trucks.Scania;

/*
  This class represents the Controller part in the MVC pattern.
  It's responsibilities is to listen to the View and responds in a appropriate manner by
  modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:



    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    // methods:



    /*
     * Each step the TimerListener moves all the cars in the list and tells the view
     * to update its images. Change this method to your needs.
     */



    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    void stopAll(){
        for ( Vehicle c : cars){
            c.stopEngine();
        }
    }

    void startAll(){
        for ( Vehicle v : cars){
            v.startEngine();
        }
    }

    void turboOn(){
        for(Vehicle v : cars){
            if(v instanceof Saab95){
                ((Saab95) v).setTurboOn();
            }
        }
    }
    void turboOff(){
        for(Vehicle v : cars){
            if(v instanceof Saab95){
                ((Saab95) v).setTurboOff();
            }
        }
    }

    void lowerBed(){
        for(Vehicle v : cars){
            if(v instanceof Scania){
                ((Scania) v).decrementFlak();
            }
        }


    }
    void liftBed(){
        for(Vehicle v : cars){
            if(v instanceof Scania){
                ((Scania) v).incrementFlak();
            }
        }


    }
}
