import org.junit.Test;

import static org.junit.Assert.*;
// all tests done 02-10-22:58
public class WorkshopTest {
    Workshop<Car> generalWorkshop = new Workshop<Car>(8);
    Workshop<Volvo240> volvo240Workshop = new Workshop<Volvo240>(8);

    @Test
    public void addCar() {
        generalWorkshop.addCar(new Volvo240());
        generalWorkshop.addCar(new Saab95());
        generalWorkshop.addCar(new Scania());
        generalWorkshop.addCar(new BigTruck());

        assertEquals(generalWorkshop.cars.size(),4,0);

        volvo240Workshop.addCar(new Volvo240());
        assertEquals(volvo240Workshop.cars.size(),1,0);
    }

    @Test
    public void removeCar() {
        Saab95 saab95 = new Saab95();
        generalWorkshop.addCar(saab95);
        generalWorkshop.removeCar(saab95);
        assertEquals(generalWorkshop.cars.size(),0,0);

    }
}