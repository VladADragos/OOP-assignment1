package gui;

import carsnstuff.Vehicle;
import carsnstuff.position.Position;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    List<BufferedImage> carImages = new ArrayList<>();

    List<Vehicle> _cars;
    // TODO: Make this genereal for all cars
    void moveit(int x, int y) {
        for(Vehicle c : _cars){
            c.getPosition().setPosition(y,x);
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y,List<Vehicle> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        _cars = cars;
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to
            // pics.
            // if you are starting in IntelliJ.
            for(Vehicle c: _cars){
                carImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+c.toString()+".jpg")));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }



    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Vehicle v : _cars){
            int index = _cars.indexOf(v);
            g.drawImage(carImages.get(index), v.getPosition().getX_Int(), v.getPosition().getY_Int(), null);
        }
         // see javadoc for more info on the parameters
    }
}
