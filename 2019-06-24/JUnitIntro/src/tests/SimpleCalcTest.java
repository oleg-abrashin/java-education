package tests;

import numbers.ICalculator;
import numbers.SimpleCalc;
import org.junit.Assert;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.*;

public class SimpleCalcTest {

    ICalculator calculator = new SimpleCalc();

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

//    @org.junit.Test
//    public void hashCode() {
//    }

    @org.junit.Test
    public void equals() {
    }

//    @org.junit.Test
//    public void clone() {
//    }

    //@org.junit.Test
    //public void toString() {
    //}

    @org.junit.Test
    public void finalize() {
    }

    @org.junit.Test
    public void multiplyInt() {
        Assert.assertEquals(4,calculator.multiply(2,2));
        Assert.assertEquals(-4,calculator.multiply(-2,2));
        Assert.assertEquals(-2,calculator.multiply(Integer.MAX_VALUE,2));
        Assert.assertEquals(4,calculator.multiply(-2,-2));
    }

    @org.junit.Test
    public void multiplyFloat() {
        Assert.assertEquals(4.4,calculator.multiply((2.2f),2),0.1);
    }

    @org.junit.Test
    public void divideInt() {
        Assert.assertEquals(2,calculator.divide(4,2));
        Assert.assertEquals(Integer.MAX_VALUE,calculator.divide(4,0));
        Assert.assertEquals(2,calculator.divide(5,2));
    }

    @org.junit.Test
    public void divideFloat() {
        Assert.assertEquals(2.2,calculator.divide(4.4f,2),0.1);
        Assert.assertEquals(2.2,calculator.divide(4.4f,2),0.01);
        Assert.assertEquals(2.2,calculator.divide(4.4f,2),0.001);
        Assert.assertFalse(Float.isFinite(calculator.divide(4.4f,0)));
        Assert.assertTrue(Float.isNaN(calculator.divide(4.0f,0)));
    }


}