package visualCalculatorProgram;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.*;

public class VisualCalculatorProgram {

    public static void main(String[] args) {
    	
    	//Set frame size and layout and text field
        JFrame frame = new JFrame("Calculator");
        frame.setSize(150, 260);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField textField = new JTextField(8);
        textField.setEditable(false);
        
        //Create and add buttons

        JButton button0 = new JButton("0");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton buttonAdd = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonDivide = new JButton("/");
        JButton buttonMultiply = new JButton("*");
        JButton buttonEquals = new JButton("=");
        JButton buttonClear = new JButton("C");

        frame.add(textField);
        frame.add(buttonClear);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(buttonAdd);
        frame.add(button0);
        frame.add(buttonMinus);
        frame.add(buttonMultiply);
        frame.add(buttonDivide);
        frame.add(buttonEquals);
        

        frame.setVisible(true);
        
        //Action listener to get the numbers
        
        
        ActionListener numberListener = e -> {
            String currentText = textField.getText();
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            textField.setText(currentText + buttonText);
        };

        button0.addActionListener(numberListener);
        button1.addActionListener(numberListener);
        button2.addActionListener(numberListener);
        button3.addActionListener(numberListener);
        button4.addActionListener(numberListener);
        button5.addActionListener(numberListener);
        button6.addActionListener(numberListener);
        button7.addActionListener(numberListener);
        button8.addActionListener(numberListener);
        button9.addActionListener(numberListener);
        
        //Action listener for operations

        ActionListener operatorListener = e -> {
            String currentText = textField.getText();
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            textField.setText(currentText + " " + buttonText + " ");
        };

        buttonAdd.addActionListener(operatorListener);
        buttonMinus.addActionListener(operatorListener);
        buttonMultiply.addActionListener(operatorListener);
        buttonDivide.addActionListener(operatorListener);

        //Action listener for results from operations
        
        buttonEquals.addActionListener(e -> {
            String expression = textField.getText();
            String[] parts = expression.split(" ");
            if (parts.length == 3) {
                double num1 = Double.parseDouble(parts[0]);
                double num2 = Double.parseDouble(parts[2]);
                double result = 0;
                switch (parts[1]) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            JOptionPane.showMessageDialog(frame, "Error: Division by zero");
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "Error: Invalid operator");
                }
                textField.setText(Double.toString(result));
            } else {
                JOptionPane.showMessageDialog(frame, "Error: Invalid expression");
            }
        });

        buttonClear.addActionListener(e -> textField.setText(""));
    }
}

