import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.awt.event.ActionEvent;


@RunWith(JUnit4.class)
public class CalcUnitTesting {

    Calculator os;

    @Before
    public void init(){
        new Calculator();
    }

    private void setNumber(double number) {
        String numStr = String.valueOf(number);
        for (char digit : numStr.toCharArray()) {
            os.actionPerformed(new ActionEvent(os.numberButtons[Character.getNumericValue(digit)], ActionEvent.ACTION_PERFORMED, ""));
        }
    }

    @Test
    public void testAddition() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.addButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(5);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Addition failed", 15.0, Double.parseDouble(os.textField.getText()), 0.001);
    }

    @Test
    public void testSubtraction() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.subButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(5);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Subtraction failed", 5.0, Double.parseDouble(os.textField.getText()), 0.001);
    }

    @Test
    public void testMultiplication() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.mulButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(5);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Multiplication failed", 50.0, Double.parseDouble(os.textField.getText()), 0.001);
    }

    @Test
    public void testDivision() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.divButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(5);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Division failed", 2.0, Double.parseDouble(os.textField.getText()), 0.001);
    }

    @Test
    public void testDivisionByZero() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.divButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(0);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertTrue("Division by zero did not handle properly", os.textField.getText().equals("Infinity") || os.textField.getText().equals("NaN"));
    }

    @Test
    public void testExponentiation() {
        setNumber(2);
        os.actionPerformed(new ActionEvent(os.expoButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(3);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Exponentiation failed", 8.0, Double.parseDouble(os.textField.getText()), 0.001);
    }

    @Test
    public void testSquareRoot() {
        setNumber(16);
        os.actionPerformed(new ActionEvent(os.sqrtButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Square root failed", 4.0, Double.parseDouble(os.textField.getText()), 0.001);
    }

    @Test
    public void testSquareRootOfNegative() {
        setNumber(-16);
        os.actionPerformed(new ActionEvent(os.sqrtButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertTrue("Square root of negative number did not handle properly", os.textField.getText().equals("NaN") || os.textField.getText().contains("Invalid"));
    }

    // Additional tests can be added for other functionality, such as clear, delete, or negative toggling.


}
