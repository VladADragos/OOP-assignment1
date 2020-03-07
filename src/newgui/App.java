package newgui;

import carsnstuff.Vehicle;
import carsnstuff.cars.Saab95;
import carsnstuff.cars.Volvo240;
import carsnstuff.trucks.Scania;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    CarController c = new CarController();
    private List<Vehicle> cars = new ArrayList<>();


    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the
    // statements
    // each step between delays.
    private Timer timer;


    public void App(){
        spawnCars();
        this.timer = new Timer(delay, new TimerListener());

    }
    public static void main(String[] args) {

        // Instance of this class
        App app = new App();

        CarController cc = new CarController();
        CarView frame = new CarView();



        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        app.timer.start();
    }
    private void spawnCars(){
        Vehicle car1 = new Volvo240();
        Vehicle car2 = new Saab95();
        Vehicle car3 = new Scania();

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
                if(car.getPosition().getY() > 800-240-60 || car.getPosition().getY() < 0){
                    car.flipDir();
                }

                //frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

}
