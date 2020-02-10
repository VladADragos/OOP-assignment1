import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.List;

/**
 * Workshop that can take in cars
 * @param <T> must inherit from car class
 */
public class Workshop<T extends Car> {
    /**
     * max amount of cars that can be in the workshop
     */
    int maxCars;
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
    public void addCar(T car){
        if(cars.size() < maxCars)
            cars.add(car);
    }


    /**
     * remove car from workshop
     * @param car what car to remove from workshop
     */
    public void removeCar(T car){
        if (cars.indexOf(car) >=0 ){
            cars.remove(cars.indexOf(car));
        }

    }
}




