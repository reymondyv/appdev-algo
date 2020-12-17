
import junit.framework.TestCase;
import org.junit.Assert;

public class RelOpsTest extends TestCase {

    public void testGreaterThan() {
        Assert.assertTrue(30.40>10.30);
        Assert.assertFalse(13>20);
    }

    public void testGreaterThanOrEqualTo() {
        Assert.assertTrue(30>=30);
        Assert.assertFalse(12>=78);
    }

    public void testLesserThan() {
        Assert.assertTrue(20<30);
        Assert.assertFalse(30<12);
    }

    public void testLesserThanOrEqualTo() {
        Assert.assertTrue(40<=40);
        Assert.assertFalse(50<30);
    }

    public void testEqualTo() {
        Assert.assertTrue(30==30);
        Assert.assertFalse(40==30);
    }

    public void testNotEqualTo() {
        Assert.assertTrue(30!=50);
        Assert.assertFalse(40!=40);
    }

    public void testAnd() {
        Assert.assertTrue(10<12 && 30<50);
        Assert.assertFalse(30<12 && 40<50);
    }

    public void testOr() {
        Assert.assertTrue(10<12 || 20<30);
        Assert.assertFalse(12<12 || 30<12);
    }

    public void testNot() {
        Assert.assertTrue(10 != 12);

    }
}