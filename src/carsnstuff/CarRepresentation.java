package carsnstuff;

import carsnstuff.position.Position;

public class CarRepresentation {

    Position position;
    CarType carType;

    CarRepresentation(CarType carType, Position position){
        this.position = position;
        this.carType = carType;
    }

    public Position getPosition(){
        return this.position;
    }

    public CarType getCarType(){
        return this.carType;
    }

}
