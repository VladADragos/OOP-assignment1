public class Position {
    private double y = 0;
    private double x = 0;

    Position(double y,double x){
        this.y = y;
        this.x = x;
    }

    public double getY() {
        return y;
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setPosition(double y,double x){
        setY(y);
        setX(x);
    }

    public Position getPosition(){
        return new Position(this.getY(),this.getX());
    }
}
