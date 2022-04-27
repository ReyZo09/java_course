package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointsTest {
    @Test
    public void pointRangeTest() {
        Point a = new Point(1, 2);
        Point b = new Point(3, 4);
        double result = Math.sqrt(Math.pow((b.x - a.x),2)+Math.pow((b.y - a.y),2));
        Assert.assertEquals(Point.range(a,b),result);
    }
}
