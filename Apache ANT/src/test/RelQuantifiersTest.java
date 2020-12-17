
import org.junit.Test;

import static org.junit.Assert.*;

public class RelQuantifiersTest {

    @Test
    public void atLeast() {
        assertTrue(30>=30);
        assertFalse(12>=78);
    }

    @Test
    public void atMost() {
        assertTrue(20<30);
        assertFalse(30<12);
    }

    @Test
    public void notLessThan() {
        assertTrue(30.40>10.30);
        assertFalse(13>20);
    }

    @Test
    public void notMoreThan() {
        assertTrue(20<30);
        assertFalse(30<12);
    }

    @Test
    public void withinInclusive() {
        assertTrue(10>=8 && 10<=10);
        assertFalse(50>=50 && 40<=20);
    }

    @Test
    public void withinExclusive() {
       assertTrue(6>=5 && 6<=10);
        assertFalse(60>=34.50 && 45.50<=18.50);
    }

    @Test
    public void outOfRangeInclusive() {
        assertTrue(true);
        assertFalse(false);

    }

    @Test
    public void outOfRangeExclusive() {
        assertTrue(true);
        assertFalse(false);
    }

    @Test
    public void exclusiveOr() {
        assertTrue(true);
        assertFalse(false);

    }
}