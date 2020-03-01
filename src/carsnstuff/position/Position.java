package carsnstuff.position;

import java.awt.*;

/**
 * A double based point
 */
public class Position {
    private double y = 0;
    private double x = 0;

    public Position(double y, double x) {
        this.y = y;
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }
    public int getX_Int(){
        return (int)x;
    }
    public int getY_Int(){
        return (int)y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setPosition(double y, double x) {
        setY(y);
        setX(x);
    }

    public Position getPosition() {
        return new Position(this.getY(), this.getX());
    }

    public boolean isClose(Position p, float range) {
        return Math.abs(getX() - p.getX()) < range && Math.abs(getY() - p.getY()) < range;

    }

    public Point getAsPoint(){
        return new Point((int)this.getY(),(int)this.getX());
    }

    public void log(){
        System.out.println("Y: "+getY());
        System.out.println("X: "+getX());
        System.out.println("\n");
    }

}
