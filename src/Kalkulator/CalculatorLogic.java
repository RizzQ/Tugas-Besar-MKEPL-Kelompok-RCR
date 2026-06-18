package Kalkulator;

public class CalculatorLogic {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0.0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static double percent(double a) {
        return a / 100.0;
    }

    public static double sqrt(double a) {
        if (a < 0.0) {
            throw new ArithmeticException("Cannot take square root of negative number");
        }
        return Math.sqrt(a);
    }

    public static double reciprocal(double a) {
        if (a == 0.0) {
            throw new ArithmeticException("Cannot take reciprocal of zero");
        }
        return 1.0 / a;
    }

    public static String toggleSign(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }
        if (value.startsWith("-")) {
            return value.substring(1);
        }
        return "-" + value;
    }

    public static String backspace(String value) {
        if (value == null || value.isEmpty()) {
            return "";
        }
        if (value.length() == 1) {
            return "";
        }
        return value.substring(0, value.length() - 1);
    }
}
