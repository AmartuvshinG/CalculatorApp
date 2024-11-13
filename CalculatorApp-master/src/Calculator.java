import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[13];
    JButton[] functionButtons = new JButton[13];
    JButton addButton, subButton, mulButton, divButton, expoButton, sqrtButton, percButton, factButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 600);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");
        expoButton = new JButton("^");
        sqrtButton = new JButton("√");
        percButton = new JButton("%");
        factButton = new JButton("!");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = expoButton;
        functionButtons[10] = sqrtButton;
        functionButtons[11] = percButton;
        functionButtons[12] = factButton;

        for (int i = 0; i < 13; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(5, 5, 10, 10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(expoButton);
        panel.add(sqrtButton);
        panel.add(percButton);
        panel.add(factButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Error: Factorial of negative number");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == expoButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '^';
            textField.setText("");
        }
        if (e.getSource() == sqrtButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '√';
            textField.setText("");
            if (num1 < 0) {
                textField.setText("Invalid square root of a negative");
            } else {
                result = Math.sqrt(num1);
                textField.setText(String.valueOf(result));
                num1 = result;
            }
        }

        if (e.getSource() == percButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
            result = num1 / 100;
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == factButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '!';
            textField.setText("");
            int intNum1 = (int) num1;
            result = factorial(intNum1);
            textField.setText(String.valueOf(result));
        }

        if (e.getSource() == equButton && !textField.getText().isEmpty()) {
            num2 = Double.parseDouble(textField.getText());

            if (operator == '/' && num2 == 0) {
                textField.setText("Error: Division by zero");
            }

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '^':
                    result = Math.pow(num1, num2);
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String text = textField.getText();
            if (!text.isEmpty()) {
                textField.setText(text.substring(0, text.length() - 1)); // Remove the last character
            }

            if (e.getSource() == negButton) {
                double temp = Double.parseDouble(textField.getText());
                temp *= -1;
                textField.setText(String.valueOf(temp));
            }
        }
    }
}
