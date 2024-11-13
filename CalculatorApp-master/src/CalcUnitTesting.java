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
        os = new Calculator();
    }

    private void setNumber(double number) {
        if (number == (int) number) {
            os.textField.setText(String.valueOf((int) number)); // Set as an integer if there's no decimal
        } else {
            os.textField.setText(String.valueOf(number));       // Set as double otherwise
        }
    }


    //Tests addition button
    @Test
    public void testAddition() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.addButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(5);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Addition failed", 15.0, Double.parseDouble(os.textField.getText()), 0.001);
    }


    //Tests subtraction button
    @Test
    public void testSubtraction() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.subButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(5);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Subtraction failed", 5.0, Double.parseDouble(os.textField.getText()), 0.001);
    }


    //Tests multiplication button
    @Test
    public void testMultiplication() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.mulButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(5);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Multiplication failed", 50.0, Double.parseDouble(os.textField.getText()), 0.001);
    }


    //Tests division button
    @Test
    public void testDivision() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.divButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(5);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Division failed", 2.0, Double.parseDouble(os.textField.getText()), 0.001);
    }


    //Tests division by zero
    @Test
    public void testDivisionByZero() {
        setNumber(10);
        os.actionPerformed(new ActionEvent(os.divButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(0);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertTrue("Division by zero did not handle properly", os.textField.getText().equals("Infinity") || os.textField.getText().equals("NaN"));
    }


    //Tests exponent button
    @Test
    public void testExponentiation() {
        setNumber(2);
        os.actionPerformed(new ActionEvent(os.expoButton, ActionEvent.ACTION_PERFORMED, ""));
        setNumber(3);
        os.actionPerformed(new ActionEvent(os.equButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Exponentiation failed", 8.0, Double.parseDouble(os.textField.getText()), 0.001);
    }


    //Tests square root button
    @Test
    public void testSquareRoot() {
        setNumber(16);
        os.actionPerformed(new ActionEvent(os.sqrtButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Square root failed", 4.0, Double.parseDouble(os.textField.getText()), 0.001);
    }


    //Tests square root for a negative number
    @Test
    public void testSquareRootOfNegative() {
        setNumber(-16);
        os.actionPerformed(new ActionEvent(os.sqrtButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertTrue("Square root of negative number did not handle properly", os.textField.getText().equals("NaN") || os.textField.getText().contains("Invalid"));
    }


    //Tests Clear button
    @Test
    public void testClear() {
        setNumber(123);
        os.actionPerformed(new ActionEvent(os.clrButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Clear failed", "", os.textField.getText());
    }


    // Tests delete button
    @Test
    public void testDelete() {
        setNumber(12345);
        os.actionPerformed(new ActionEvent(os.delButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Delete failed", "1234", os.textField.getText());
    }


    //Tests negative button
    @Test
    public void testNegate() {
        setNumber(123);
        os.actionPerformed(new ActionEvent(os.negButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Negation failed", "-123.0", os.textField.getText());
    }


    //Tests percentage button
    @Test
    public void testPercent(){
        setNumber(56);
        os.actionPerformed(new ActionEvent(os.percButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Percentage failed", "0.56", os.textField.getText());
    }


    //Tests factorial button
    @Test
    public void testFact(){
        setNumber(5);
        os.actionPerformed(new ActionEvent(os.factButton, ActionEvent.ACTION_PERFORMED, ""));
        Assert.assertEquals("Factorial failed", "120.0", os.textField.getText());
    }


}
