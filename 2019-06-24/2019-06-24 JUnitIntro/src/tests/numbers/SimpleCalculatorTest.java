package tests.numbers;

import interfaces.ICalculator;
import numbers.SimpleCalculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleCalculatorTest {

    ICalculator calculator = new SimpleCalculator();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void multiply() {
//        fail("Not yet implemented");
        assertEquals(4, calculator.multiply(2, 2));
        assertEquals(-4, calculator.multiply(-2, 2));
        assertEquals(4, calculator.multiply(-2, -2));
        assertEquals(-2, calculator.multiply(Integer.MAX_VALUE, 2));
    }

    @Test
    public void multiply1() {
        assertEquals(4.4, calculator.multiply(2.2f, 2), 0.001);
    }

    @Test
    public void divide() {
        assertEquals(2, calculator.divide(4, 2));
        assertEquals(Integer.MAX_VALUE, calculator.divide(4, 0));
        assertEquals(2, calculator.divide(5, 2));
    }

    @Test
    public void divide1() {
        assertEquals(2.2, calculator.divide(4.4f, 2), 0.1);
        assertTrue(Float.isNaN(calculator.divide(4.4f, 0)));

    }
}