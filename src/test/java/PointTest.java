import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void CreatePoint(){
        Point point = new Point(1,2);

        assertEquals(1,point.x);
        assertEquals(2, point.y);
    }

}