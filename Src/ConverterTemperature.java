package ConverterTemperature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterTemperature extends JFrame implements ActionListener {
    private JLabel titleLabel, inputLabel, outputLabel;
    private JTextField inputField, outputField;
    private JButton fahrenheitToCelsiusButton, celsiusToFahrenheitButton;

    public ConverterTemperature() 
    {
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLayout(new GridLayout(4, 2));
        getContentPane().setBackground(Color.blue);

        titleLabel = new JLabel("Temperature Converter");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        inputLabel = new JLabel("Enter Temperature:");
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        inputLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        outputLabel = new JLabel("Converted Temperature:");
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        outputLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 22));

        outputField = new JTextField();
        outputField.setFont(new Font("Arial", Font.PLAIN, 22));
        outputField.setEditable(false);

        fahrenheitToCelsiusButton = new JButton("Fahrenheit to Celsius");
        fahrenheitToCelsiusButton.addActionListener(this);
        fahrenheitToCelsiusButton.setBackground(Color.WHITE);
        fahrenheitToCelsiusButton.setForeground(Color.BLACK);
        fahrenheitToCelsiusButton.setFont(new Font("Arial", Font.BOLD, 22));

        celsiusToFahrenheitButton = new JButton("Celsius to Fahrenheit");
        celsiusToFahrenheitButton.addActionListener(this);
        celsiusToFahrenheitButton.setBackground(Color.WHITE);
        celsiusToFahrenheitButton.setForeground(Color.BLACK);
        celsiusToFahrenheitButton.setFont(new Font("Arial", Font.BOLD, 22));

        add(titleLabel);
        add(new JLabel());
        add(inputLabel);
        add(inputField);
        add(outputLabel);
        add(outputField);
        add(fahrenheitToCelsiusButton);
        add(celsiusToFahrenheitButton);

        setVisible(true);
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fahrenheitToCelsiusButton) {
            String inputText = inputField.getText();
            if (!inputText.isEmpty()) {
                try {
                    double fahrenheit = Double.parseDouble(inputText);
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    outputField.setText(String.format("%.2f", celsius));
                } catch (NumberFormatException ex) {
                    showErrorDialog("Invalid input! Please enter a valid temperature in Fahrenheit.");
                }
            } else {
                showErrorDialog("Please enter a temperature in Fahrenheit.");
            }
        } else if (e.getSource() == celsiusToFahrenheitButton) {
            String inputText = inputField.getText();
            if (!inputText.isEmpty()) {
                try {
                    double celsius = Double.parseDouble(inputText);
                    double fahrenheit = celsius * 9 / 5 + 32;
                    outputField.setText(String.format("%.2f", fahrenheit));
                } catch (NumberFormatException ex) {
                    showErrorDialog("Invalid input! Please enter a valid temperature in Celsius.");
                }
            } else {
                showErrorDialog("Please enter a temperature in Celsius.");
            }
        }
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConverterTemperature());
    }
}
