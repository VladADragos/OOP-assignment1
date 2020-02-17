class Position {
    private double y = 0;
    private double x = 0;

    Position(double y,double x){
        this.y = y;
        this.x = x;
    }

    double getY() {
        return y;
    }
    double getX() {
        return x;
    }

    void setX(double x) {
        this.x = x;
    }

    void setY(double y) {
        this.y = y;
    }

    void setPosition(double y, double x){
        setY(y);
        setX(x);
    }

    Position getPosition(){
        return new Position(this.getY(),this.getX());
    }

    boolean isClose(Position p, float range){
        return Math.abs(getX()-p.getX())<range && Math.abs(getY()-p.getY())<range;

    }

}
