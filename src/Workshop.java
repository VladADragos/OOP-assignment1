import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.List;

/**
 * Workshop that can take in cars
 * @param <T> must inherit from car class
 */
class Workshop<T extends Car> {
    /**
     * max amount of cars that can be in the workshop
     */
    private int maxCars;
    /**
     * list of all cars. The type can be set for solely one class or any car that inherits car class
     */
    List<T> cars = new ArrayList<T>(maxCars);


    /**
     * constructor
     * @param maxCars how many cars is the maximum capacity of workshop
     */
    Workshop(int maxCars){
        this.maxCars = maxCars;
    }


    /**
     * add car to workshop
     * @param car what car to add to the workshop
     */
    void addCar(T car){
        if(cars.size() < maxCars)
            cars.add(car);
    }


    /**
     * remove car from workshop
     * @param car what car to remove from workshop
     */
    void removeCar(T car){

            cars.remove(car);


    }
}




