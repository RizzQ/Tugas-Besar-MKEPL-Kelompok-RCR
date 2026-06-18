package Kalkulator;

public class CalculatorLogicTest {
    public static void main(String[] args) {
        int failures = 0;

        failures += assertEquals("add", 7.0, CalculatorLogic.add(3, 4));
        failures += assertEquals("subtract", -1.0, CalculatorLogic.subtract(3, 4));
        failures += assertEquals("multiply", 12.0, CalculatorLogic.multiply(3, 4));
        failures += assertEquals("divide", 2.0, CalculatorLogic.divide(8, 4));
        failures += assertEquals("percent", 0.2, CalculatorLogic.percent(20));
        failures += assertEquals("sqrt", 3.0, CalculatorLogic.sqrt(9));
        failures += assertEquals("reciprocal", 0.25, CalculatorLogic.reciprocal(4));
        failures += assertEquals("toggleSign positive", "-5", CalculatorLogic.toggleSign("5"));
        failures += assertEquals("toggleSign negative", "5", CalculatorLogic.toggleSign("-5"));
        failures += assertEquals("backspace normal", "12", CalculatorLogic.backspace("123"));
        failures += assertEquals("backspace single", "", CalculatorLogic.backspace("1"));

        failures += assertThrows("divide by zero", () -> CalculatorLogic.divide(3, 0));
        failures += assertThrows("sqrt negative", () -> CalculatorLogic.sqrt(-1));
        failures += assertThrows("reciprocal zero", () -> CalculatorLogic.reciprocal(0));

        if (failures > 0) {
            System.err.printf("%d test(s) failed.%n", failures);
            System.exit(1);
        }
        System.out.println("All CalculatorLogic tests passed.");
    }

    private static int assertEquals(String name, double expected, double actual) {
        if (Double.compare(expected, actual) != 0) {
            System.err.printf("FAIL [%s]: expected %s but got %s%n", name, expected, actual);
            return 1;
        }
        return 0;
    }

    private static int assertEquals(String name, String expected, String actual) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            System.err.printf("FAIL [%s]: expected '%s' but got '%s'%n", name, expected, actual);
            return 1;
        }
        return 0;
    }

    private static int assertThrows(String name, Runnable action) {
        try {
            action.run();
            System.err.printf("FAIL [%s]: expected exception but none thrown%n", name);
            return 1;
        } catch (ArithmeticException expected) {
            return 0;
        } catch (Exception unexpected) {
            System.err.printf("FAIL [%s]: expected ArithmeticException but got %s%n", name, unexpected.getClass().getName());
            return 1;
        }
    }

    @FunctionalInterface
    private interface RunnableWithException {
        void run() throws Exception;
    }
}
