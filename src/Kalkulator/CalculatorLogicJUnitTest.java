package Kalkulator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorLogicJUnitTest {

    @Test
    public void testAdd() {
        assertEquals(7.0, CalculatorLogic.add(3, 4), 0.0);
    }

    @Test
    public void testSubtract() {
        assertEquals(-1.0, CalculatorLogic.subtract(3, 4), 0.0);
    }

    @Test
    public void testMultiply() {
        assertEquals(12.0, CalculatorLogic.multiply(3, 4), 0.0);
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, CalculatorLogic.divide(8, 4), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        CalculatorLogic.divide(3, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void testSqrtNegative() {
        CalculatorLogic.sqrt(-1);
    }

    @Test
    public void testPercent() {
        assertEquals(0.2, CalculatorLogic.percent(20), 0.0);
    }
}
