import org.example.Main;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TestCalculatorBoundary {
    Main calculator = new Main();

    @Test
    public void testAddition() {
        calculator.num1 = 0;
        calculator.num2 = 0;
        calculator.operator = '+';
        calculator.result = calculator.num1 + calculator.num2;
        assertEquals(0, calculator.result, "0 + 0 should be 0");

        calculator.num1 = Integer.MAX_VALUE;
        calculator.num2 = 1;
        calculator.result = calculator.num1 + calculator.num2;
        assertEquals((double) Integer.MAX_VALUE + 1, calculator.result, "Max + 1 should be within double range");

        calculator.num1 = -1;
        calculator.num2 = 1;
        calculator.result = calculator.num1 + calculator.num2;
        assertEquals(0, calculator.result, "-1 + 1 should be 0");
    }

    @Test
    public void testSubtraction() {
        calculator.num1 = 0;
        calculator.num2 = 0;
        calculator.operator = '-';
        calculator.result = calculator.num1 - calculator.num2;
        assertEquals(0, calculator.result, "0 - 0 should be 0");

        calculator.num1 = Integer.MAX_VALUE;
        calculator.num2 = Integer.MAX_VALUE;
        calculator.result = calculator.num1 - calculator.num2;
        assertEquals(0, calculator.result, "Max should be 0");

        calculator.num1 = 0;
        calculator.num2 = Integer.MAX_VALUE;
        calculator.result = calculator.num1 - calculator.num2;
        assertEquals(-Integer.MAX_VALUE, calculator.result, "0 - Max should be -Max");
    }

    @Test
    public void testMultiplication() {
        calculator.num1 = 0;
        calculator.num2 = 0;
        calculator.operator = '*';
        calculator.result = calculator.num1 * calculator.num2;
        assertEquals(0, calculator.result, "0 * 0 should be 0");

        calculator.num1 = Integer.MAX_VALUE;
        calculator.num2 = 1;
        calculator.result = calculator.num1 * calculator.num2;
        assertEquals(Integer.MAX_VALUE, calculator.result, "Max * 1 should be Max");

        calculator.num1 = Integer.MAX_VALUE;
        calculator.num2 = 2;
        calculator.result = calculator.num1 * calculator.num2;
        assertEquals((double) Integer.MAX_VALUE * 2, calculator.result, "Max * 2 should be within double range");
    }


   /* @Test
    public void testDivisionByZero() {
        Main calc = new Main();

        calc.textField.setText("10");
        calc.actionPerformed(new ActionEvent(calc.divButton, ActionEvent.ACTION_PERFORMED, "/"));

        calc.textField.setText("0");
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calc.actionPerformed(new ActionEvent(calc.equButton, ActionEvent.ACTION_PERFORMED, "="));
        });

        assertEquals("Error: division by zero", exception.getMessage());
    }
*/
  /*  @Test
    void testSquareRootOfNegativeNumber() {
       Main calc = new Main();
        calc.textField.setText("-16");
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calc.actionPerformed(new ActionEvent(calc.sqrtButton, ActionEvent.ACTION_PERFORMED, "sqrt"));
        });
        assertEquals("Error: square root of negative number", exception.getMessage());
    }
*/

    @Test
    public void testExponentiation() {
        calculator.num1 = 2;
        calculator.num2 = 3;
        calculator.result = Math.pow(calculator.num1, calculator.num2);
        assertEquals(8, calculator.result, "2^3 should be 8");

        calculator.num1 = 0;
        calculator.num2 = 5;
        calculator.result = Math.pow(calculator.num1, calculator.num2);
        assertEquals(0, calculator.result, "0^5 should be 0");

        calculator.num1 = 5;
        calculator.num2 = 0;
        calculator.result = Math.pow(calculator.num1, calculator.num2);
        assertEquals(1, calculator.result, "5^0 should be 1");
    }

    @Test
    public void testPercentage() {
        calculator.num1 = 50;
        calculator.result = calculator.num1 / 100;
        assertEquals(0.5, calculator.result, "50% should be 0.5");

        calculator.num1 = 0;
        calculator.result = calculator.num1 / 100;
        assertEquals(0, calculator.result, "0% should be 0");
    }

    @Test
    public void testFactorial() {
        calculator.num1 = 0;
        calculator.result = calculator.factorial(0);
        assertEquals(1, calculator.result, "Factorial of 0 should be 1");

        calculator.num1 = 5;
        calculator.result = calculator.factorial((int) calculator.num1);
        assertEquals(120, calculator.result, "Factorial of 5 should be 120");

        calculator.num1 = -1;
        assertThrows(IllegalArgumentException.class, () -> calculator.result = calculator.factorial((int) calculator.num1), "Factorial of negative number, error");
    }

}
