import carsnstuff.position.Position;
import org.junit.Test;

import static org.junit.Assert.*;

// all tests passed 02-10-21:44
public class PositionTest {
    double testY = 42d;
    double testX = 69d;
    Position position = new Position(testY,testX);
    @Test
    public void getY() {
        assertEquals(position.getY(),testY,0);
    }

    @Test
    public void getX() {
        assertEquals(position.getX(),testX,0);
    }

    @Test
    public void setX() {
        position.setX(9.82);
        assertEquals(position.getX(),9.82,0);
    }

    @Test
    public void setY() {
        position.setX(3.14);
        assertEquals(position.getX(),3.14,0);
    }

    @Test
    public void setPosition() {
        position.setPosition(6.62607,271.15);
        assertEquals(position.getPosition().getY(),6.62607,0);
        assertEquals(position.getPosition().getX(),271.15,0);
    }

    @Test
    public void getPosition() {
        assertEquals(position.getPosition().getY(),42,0);
        assertEquals(position.getPosition().getX(),69,0);
    }
}