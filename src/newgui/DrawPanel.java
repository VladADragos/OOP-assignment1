package newgui;

import carsnstuff.CarRepresentation;
import carsnstuff.CarType;
import carsnstuff.Vehicle;
import carsnstuff.position.Position;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {



    Map<CarType,BufferedImage> map = new HashMap<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y,List<CarRepresentation> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        populateImageMap(cars);

    }

    void populateImageMap(List<CarRepresentation> cars){
        for(CarType type: CarType.values()){
            if(!map.containsKey(type)){
                try {
                    map.put(type, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + CarType.toStr(type))));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    protected void paintComponent(Graphics g, List<CarRepresentation> cars) {
        super.paintComponent(g);
        for(CarRepresentation c : cars){
            g.drawImage(map.get(c.getCarType()), c.getPosition().getX_Int(), c.getPosition().getY_Int(), null);
        }

    }
}
