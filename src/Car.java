import java.awt.*;
import java.util.Vector;


/**
 * Car superclass that other cars inherit from
 */
public  class Car implements IMovable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    public  Dir dir = Dir.s ;
    public Point position = new Point(0,0);

    /**
     * Car constructor
     * @param nrDoors number of doors
     * @param color the color
     * @param enginePower the engine power
     * @param modelName the model name
     */
    public Car(int nrDoors, Color color, int enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;

        stopEngine();
    }

    /**
     * nrDoors getter
     * @return returns the number of doors of the car
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * enginePower getter
     * @return returns the enginePower of the car
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * currentSpeed getter
     * @return returns the currentSpeed of the car
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * color getter
     * @return returns the color of the car
     */
    public Color getColor() {
        return color;
    }

    /**
     * color setter
     * @param clr the new color
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * starts the engine of the car
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * stops the engine of the car
     */
    public void stopEngine() {
        currentSpeed = 0;
    }


    //public abstract double speedFactor();

    /**
     * @param amount how much the speed of the car should be increased
     */
    public  void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor();
    }


    /**
     * @param amount how much the speed of the car should be decreased
     */
    public  void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor();
    }


    /**
     * moves the car depending on its direction
     */
    public void move() {
        switch (dir){
            case n:
                position.y -= getCurrentSpeed();
                break;
            case s:
                position.y+= getCurrentSpeed();
                break;
            case e:
                position.x += getCurrentSpeed();
                break;
            case w:
                position.x -= getCurrentSpeed();
                break;
        }

    }


    /**
     * turns the car left
     */
    public void turnLeft(){

        switch (dir){
            case n:
                dir = Dir.e;
                break;
            case s:
                dir = Dir.w;
                break;
            case e:
                dir = Dir.n;
                break;
            case w:
                dir = Dir.s;
                break;
        }
    }

    /**
     * turns the car right
     */
    public void turnRight() {
       // position.rotate(-1);


        switch (dir){
            case n:
                dir = Dir.w;
                break;
            case s:
                dir = Dir.n;
                break;
            case e:
                dir = Dir.s;
                break;
            case w:
                dir = Dir.e;
                break;
        }



    }


    /**
     * acceleration amount
     * @param amount acceleration amount 0,1(double)
     */
    // TODO fix this method according to lab pm
    public void gas(double amount) {
        if(amount >= 0 && amount <= 1 ){
            incrementSpeed(amount);
            if(currentSpeed > enginePower){
                decrementSpeed(amount);
            }
        }


    }

    // TODO fix this method according to lab pm

    /**
     * slows down the car
     * @param amount amount of slow, must be between 0,1(double)
     */
    public void brake(double amount) {
        if(amount >= 0 && amount <= 1){
            decrementSpeed(amount);
            if(currentSpeed<0){
                incrementSpeed(amount);
            }
        }

    }

    /**
     * @return double representing the speed factor. default 1
     */
    public double speedFactor() {
        return 1;
    }

    /**
     * returns the position
     * @return Point
     */
    public Point getPosition(){
        return position;
    }

}
