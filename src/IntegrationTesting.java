import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTesting {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    /*
     * Input: 2 + 3
     * Expected Output: 5.0 */
    @Test
    void testAdditionIntegration() {
     calculator.textField.setText("2");
     calculator.addButton.doClick();
     calculator.textField.setText("3");
     calculator.equButton.doClick();
     assertEquals("5.0",calculator.textField.getText());
    }
    /*
    * Input: 3!
    * Expected Output: 6.0 */
    @Test
    void testFactorialIntegration() {
        calculator.textField.setText("3");
        calculator.factButton.doClick();
        calculator.equButton.doClick();
        assertEquals("6.0",calculator.textField.getText());
    }
    /*
     * Input: 3^2
     * Expected Output: 9.0 */
    @Test
    void testExponentIntegration() {
        calculator.textField.setText("3");
        calculator.expoButton.doClick();
        calculator.textField.setText("2");
        calculator.equButton.doClick();
        assertEquals("9.0", calculator.textField.getText());

    }
    /*
     * Input: 5%
     * Expected Output: 0.05 */
    @Test
    void testPercentageIntegration() {
        calculator.textField.setText("5");
        calculator.percButton.doClick();
        calculator.equButton.doClick();
        assertEquals("0.05",calculator.textField.getText());
    }
    /*
     * Input: sqrt(16)
     * Expected Output: 4 */
    @Test
    void testSquareRootIntegration() {
        calculator.textField.setText("16");
        calculator.sqrtButton.doClick();
        calculator.equButton.doClick();
        assertEquals("4.0",calculator.textField.getText());
    }
}
