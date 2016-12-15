package test;

import code.Helpers.Rectangle;
import org.junit.Test;
import code.RectangleIntersection;
import static org.junit.Assert.assertEquals;

public class RectangleIntersectionTest {
    @Test
    public void validate_intersection_expect2022() {
        Rectangle r1 = new Rectangle(0, 0, 6, 2);
        Rectangle r2 = new Rectangle(2, -1, 2, 4);
        RectangleIntersection tester = new RectangleIntersection();
        Rectangle result = tester.getOverlap(r1, r2);

        assertEquals((Integer)2, result.leftX);
        assertEquals((Integer)0, result.bottomY);
        assertEquals((Integer)2, result.width);
        assertEquals((Integer)2, result.height);
    }
}
