package gui;

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

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the
    // statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    // methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.spawnCars();

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the view
     * to update its images. Change this method to your needs.
     */

    private void spawnCars(){
        Volvo240 car1 = new Volvo240();
        Saab95 car2 = new Saab95();
        Scania car3 = new Scania();

        car2.getPosition().setPosition(0,100);
        car3.getPosition().setPosition(0,200);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            if(car.getPosition().getY() > 100 || car.getPosition().getY() < 0){
                car.flipDir();
            }
            System.out.println(car.getDir());
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
