import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class PolynomialTest {

    @Test
    public void testInitialStateZeroPolynomial() {
        List <Term> terms = new ArrayList <> (3);
        Term t1 = new Term (0, 0);
        terms.add(t1);
        Polynomial p1 = new Polynomial ('x', terms);

        assertEquals("",p1.toString());
    }

    @Test
    public void testMonomialAddition() {
        List <Term> terms = new ArrayList <> (3);
        Term t1 = new Term (10, 3);
        terms.add (t1);
        Term t2 = new Term (5, 2);
        terms.add (t2);
        Term t3 = new Term (1, 1);
        terms.add (t3);


        List <Term> terms2 = new ArrayList <> (3);
        Term tt1 = new Term (4, 3);
        terms2.add (tt1);
        Term tt2 = new Term (1, 2);
        terms2.add (tt2);
        Term tt3 = new Term (-1, 1);
        terms2.add (tt3);

        Polynomial p1 = new Polynomial ('x', terms);
        Polynomial p2 = new Polynomial ('x', terms2);
        Polynomial equals = p1.add (p2);

        assertEquals ("14x^3 + 6x^2 + x", equals.toString ());

    }


    @Test
    public void testPolynomialAddition() {
        List <Term> terms = new ArrayList <> (3);
        Term t1 = new Term (10, 3);
        terms.add (t1);
        Term t2 = new Term (5, 2);
        terms.add (t2);
        Term t3 = new Term (1, 1);
        terms.add (t3);


        List <Term> terms2 = new ArrayList <> (3);
        Term tt1 = new Term (4, 3);
        terms2.add (tt1);
        Term tt2 = new Term (-1, 2);
        terms2.add (tt2);
        Term tt3 = new Term (-1, 1);
        terms2.add (tt3);

        Polynomial p1 = new Polynomial ('x', terms);
        Polynomial p2 = new Polynomial ('x', terms2);
        Polynomial equals = p1.add (p2);

        assertEquals ("14x^3 + 4x^2 + x", equals.toString ());
    }

    @Test
    public void testPolynomialSubtraction() {
        List <Term> terms = new ArrayList <> (3);
        Term m1 = new Term (19, 3);
        terms.add (m1);
        Term m2 = new Term (7, 2);
        terms.add (m2);
        Term m3 = new Term (7, 1);
        terms.add (m3);


        List <Term> terms2 = new ArrayList <> (3);
        Term mm1 = new Term (3, 3);
        terms2.add (mm1);
        Term mm2 = new Term (2, 2);
        terms2.add (mm2);
        Term mm3 = new Term (-1, 1);
        terms2.add (mm3);

        Polynomial p1 = new Polynomial ('x', terms);
        Polynomial p2 = new Polynomial ('x', terms2);
        Polynomial equals = p1.subtract (p2);

        assertEquals ("16x^3 + 5x^2 + 8x", equals.toString ());
    }


    @Test
    public void testPolynomialMultiplication() {
        List <Term> terms = new ArrayList <> (3);
        Term d1 = new Term (19, 3);
        terms.add (d1);
        Term d2 = new Term (4, 2);
        terms.add (d2);
        Term d3 = new Term (1, 1);
        terms.add (d3);


        List <Term> terms2 = new ArrayList <> (3);
        Term dd1 = new Term (4, 3);
        terms2.add (dd1);
        Term dd2 = new Term (5, 2);
        terms2.add (dd2);
        Term dd3 = new Term (1, 1);
        terms2.add (dd3);

        Polynomial p1 = new Polynomial ('x', terms);
        Polynomial p2 = new Polynomial ('x', terms2);
        Polynomial equals = p1.multiply (p2);

        assertEquals ("76x^6 + 111x^5 + 43x^4 + 9x^3 + x^2", equals.toString ());

    }
    @Test
    public void testPolynomialMultiplication2() {
        List <Term> terms3 = new ArrayList <> (3);
        Term d1 = new Term (9, 3);
        terms3.add (d1);
        Term d2 = new Term (4, 3);
        terms3.add (d2);
        Term d3 = new Term (11, 2);
        terms3.add (d3);


        List <Term> terms4 = new ArrayList <> (3);
        Term dd1 = new Term (7, 3);
        terms4.add (dd1);
        Term dd2 = new Term (-5, 2);
        terms4.add (dd2);
        Term dd3 = new Term (3, 2);
        terms4.add (dd3);

        Polynomial p1 = new Polynomial ('x', terms3);
        Polynomial p2 = new Polynomial ('x', terms4);
        Polynomial equals2 = p1.multiply (p2);

        assertEquals ("91x^6 + 51x^5 - 22x^4", equals2.toString ());

    }
    @Test
    public void testPolynomialEvaluate() {
        List <Term> terms = new ArrayList <> (3);
        Term d1 = new Term (19, 3);
        terms.add (d1);
        Term d2 = new Term (4, 2);
        terms.add (d2);
        Term d3 = new Term (1, 1);
        terms.add (d3);


        List <Term> terms2 = new ArrayList <> (3);
        Term dd1 = new Term (4, 3);
        terms2.add (dd1);
        Term dd2 = new Term (5, 2);
        terms2.add (dd2);
        Term dd3 = new Term (1, 1);
        terms2.add (dd3);

        List <Term> terms3 = new ArrayList <> (3);
        Term ddd1 = new Term (4, 3);
        terms3.add (dd1);
        Term ddd2 = new Term (5, 2);
        terms3.add (dd2);
        Term ddd3 = new Term (1, 1);
        terms3.add (dd3);

        List <Term> terms4 = new ArrayList <> (3);
        Term dddd1 = new Term (4, 3);
        terms4.add (dd1);
        Term dddd2 = new Term (5, 2);
        terms4.add (dd2);
        Term dddd3 = new Term (1, 1);
        terms4.add (dd3);

        Polynomial p1 = new Polynomial ('x', terms);
        Polynomial p2 = new Polynomial ('x', terms2);
        Polynomial p3 = new Polynomial ('x', terms4);
        Polynomial p4 = new Polynomial ('x', terms4);


        double equals = p1.evaluate (2);
        double equals2 = p2.evaluate (3);
        double equals3 = p3.evaluate (6);
        double equals4 = p4.evaluate (-5);
        assertEquals (54938.0,equals,0.0);
        assertEquals (1956.0,equals2,0.0);
        assertEquals (14730.0,equals3,0.0);
        assertEquals (-7380.0,equals4,0.0);

    }
}



