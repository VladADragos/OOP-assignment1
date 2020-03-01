import org.junit.Test;

import static org.junit.Assert.*;
import carsnstuff.*;
// all tests done 02-10-22:58
public class WorkshopTest {
    Workshop<Car> generalWorkshop = new Workshop<Car>(8);
    Workshop<Volvo240> volvo240Workshop = new Workshop<Volvo240>(8);

    @Test
    public void addCar() {
        generalWorkshop.addCar(new Volvo240());
        generalWorkshop.addCar(new Saab95());
        //generalWorkshop.addCar(new Scania());
        //generalWorkshop.addCar(new BigTruck());

        assertEquals(generalWorkshop.getCars().size(),2,0);

        volvo240Workshop.addCar(new Volvo240());
        assertEquals(volvo240Workshop.getCars().size(),1,0);
    }

    @Test
    public void removeCar() {
        Saab95 saab95 = new Saab95();
        generalWorkshop.removeCar(saab95);
        //volvo240Workshop.addCar(saab95);
        assertEquals(generalWorkshop.getCars().size(),0,0);

    }
}