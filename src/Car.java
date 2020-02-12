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
    private   Dir dir = Dir.s ;
    public Position position = new Position(0,0);

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
        currentSpeed = getCurrentSpeed() + speedFactor()*amount;
    }


    /**
     * @param amount how much the speed of the car should be decreased
     */
    public  void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor()*amount;
    }


    /**
     * moves the car depending on its direction
     */
    public void move() {
        switch (dir){
            case n:
                position.setY(position.getY()-getCurrentSpeed());
                break;
            case s:
                position.setY(position.getY()+getCurrentSpeed());
                break;
            case e:
                position.setX(position.getX()+getCurrentSpeed());
                break;
            case w:
                position.setX(position.getX()-getCurrentSpeed());
                break;
        }

    }


    /**
     * turns the car left
     */
    public void turnLeft(){

        switch (dir){
            case n:
                setDir(Dir.e);
                break;
            case s:
                setDir(Dir.w);
                break;
            case e:
                setDir(Dir.n);
                break;
            case w:
                setDir(Dir.s);
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
                setDir(Dir.w);
                break;
            case s:
                setDir(Dir.e);
                break;
            case e:
                setDir(Dir.s);
                break;
            case w:
                setDir(Dir.n);
                break;
        }



    }


    /**
     * acceleration amount
     * @param amount acceleration amount 0,1(double)
     */
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
    public Position getPosition(){
        return position;
    }

    /**
     * returns the direction of the car
     * @return Dir
     */
    public Dir getDir(){return dir;}

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public String test(){
        return "test";
    }


}
