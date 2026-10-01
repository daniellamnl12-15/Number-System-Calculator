//Daniella C. Manalo BSCS 2B
//OOP Prelim Java Project

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class NumSysCalc extends JFrame {

    int n1;
    int n2;

    static ArrayList<String> history = new ArrayList<>();

    JPanel mainPanel;
    JPanel contentPanel;
    JLabel title;
    JLabel modeLabel;
    JTextField display;

    double firstNumber = 0;
    String operator = "";
    boolean newNumber = true;

    // Default constructor
    public NumSysCalc() {
        n1 = 0;
        n2 = 0;
    }

    // Overloaded constructor
    public NumSysCalc(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    // Arithmetic methods
    public int add() {
        return n1 + n2;
    }

    public int sub() {
        return n1 - n2;
    }

    public int multi() {
        return n1 * n2;
    }

    public double divi() {
        return (double) n1 / n2;
    }

    public int mod() {
        return n1 % n2;
    }

    // Number conversion methods
    public String toBinary(int num) {
        return Integer.toBinaryString(num);
    }

    public String toOctal(int num) {
        return Integer.toOctalString(num);
    }

    public String toHex(int num) {
        return Integer.toHexString(num).toUpperCase();
    }

    public int toDecimal(String num, int base) {
        return Integer.parseInt(num, base);
    }

    // Even or Odd
    public String evenOdd(int num) {
        if (num % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    // Prime checker
    public boolean isPrime(int num) {

        if (num <= 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {

            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    // GUI constructor
    public NumSysCalc(boolean gui) {

        this();

        createGUI();
    }

    // Create GUI
    public void createGUI() {

        setTitle("Number System Calculator");

        setSize(500, 700);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout(6, 6));

        mainPanel.setBackground(new Color(18, 18, 18));

        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(12, 12, 10, 12)
        );

        // Header
        JPanel headerPanel = new JPanel();

        headerPanel.setLayout(
            new BoxLayout(headerPanel, BoxLayout.Y_AXIS)
        );

        headerPanel.setBackground(new Color(18, 18, 18));

        title = new JLabel("NUMBER SYSTEM CALCULATOR");

        title.setForeground(Color.WHITE);

        title.setFont(
            new Font("Monospaced", Font.BOLD, 21)
        );

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        modeLabel = new JLabel("ARITHMETIC MODE");

        modeLabel.setForeground(
            new Color(100, 220, 140)
        );

        modeLabel.setFont(
            new Font("Monospaced", Font.BOLD, 13)
        );

        modeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(title);

        headerPanel.add(
            Box.createVerticalStrut(5)
        );

        headerPanel.add(modeLabel);

        mainPanel.add(
            headerPanel,
            BorderLayout.NORTH
        );

        // Content
        contentPanel = new JPanel(
            new BorderLayout(5, 5)
        );

        contentPanel.setBackground(
            new Color(18, 18, 18)
        );

        mainPanel.add(
            contentPanel,
            BorderLayout.CENTER
        );

        // Menu buttons
        JPanel menuPanel = new JPanel(
            new GridLayout(2, 3, 4, 4)
        );

        menuPanel.setBackground(
            new Color(18, 18, 18)
        );

        JButton arithmeticButton =
            createMenuButton("ARITHMETIC");

        JButton convertButton =
            createMenuButton("CONVERT");

        JButton numSysButton =
            createMenuButton("NUM SYS");

        JButton infoButton =
            createMenuButton("INFO");

        JButton historyButton =
            createMenuButton("HISTORY");

        JButton exitButton =
            createMenuButton("EXIT");

        menuPanel.add(arithmeticButton);
        menuPanel.add(convertButton);
        menuPanel.add(numSysButton);
        menuPanel.add(infoButton);
        menuPanel.add(historyButton);
        menuPanel.add(exitButton);

        arithmeticButton.addActionListener(
            e -> createArithmeticMode()
        );

        convertButton.addActionListener(
            e -> createConversionMode()
        );

        numSysButton.addActionListener(
            e -> createNumberSystemMode()
        );

        infoButton.addActionListener(
            e -> createInfoMode()
        );

        historyButton.addActionListener(
            e -> createHistoryMode()
        );

        exitButton.addActionListener(
            e -> System.exit(0)
        );

        mainPanel.add(
            menuPanel,
            BorderLayout.SOUTH
        );

        add(mainPanel);

        createArithmeticMode();
    }

    // Menu button design
    public JButton createMenuButton(String text) {

        JButton button = new JButton(text);

        button.setFocusPainted(false);

        button.setBackground(
            new Color(45, 45, 45)
        );

        button.setForeground(Color.WHITE);

        button.setFont(
            new Font("Monospaced", Font.BOLD, 10)
        );

        button.setMargin(
            new Insets(3, 5, 3, 5)
        );

        return button;
    }

    // Calculator button design
    public JButton createCalcButton(String text) {

        JButton button = new JButton(text);

        button.setFocusPainted(false);

        button.setBackground(
            new Color(45, 45, 45)
        );

        button.setForeground(Color.WHITE);

        button.setFont(
            new Font("Monospaced", Font.BOLD, 17)
        );

        button.setMargin(
            new Insets(2, 2, 2, 2)
        );

        return button;
    }

    // Arithmetic Mode
    public void createArithmeticMode() {

        modeLabel.setText("ARITHMETIC MODE");

        contentPanel.removeAll();

        JPanel calculatorPanel =
            new JPanel(new BorderLayout(5, 5));

        calculatorPanel.setBackground(
            new Color(18, 18, 18)
        );

        display = new JTextField("0");

        display.setHorizontalAlignment(
            JTextField.RIGHT
        );

        display.setFont(
            new Font("Monospaced", Font.BOLD, 34)
        );

        display.setBackground(
            new Color(25, 25, 25)
        );

        display.setForeground(Color.WHITE);

        display.setCaretColor(Color.WHITE);

        display.setEditable(false);

        display.setPreferredSize(
            new Dimension(0, 75)
        );

        display.setBorder(
            BorderFactory.createEmptyBorder(
                8, 12, 8, 12
            )
        );

        calculatorPanel.add(
            display,
            BorderLayout.NORTH
        );

        JPanel buttonPanel =
            new JPanel(
                new GridLayout(5, 4, 3, 3)
            );

        buttonPanel.setBackground(
            new Color(18, 18, 18)
        );

        String[] buttons = {

            "AC", "⌫", "%", "÷",

            "7", "8", "9", "×",

            "4", "5", "6", "−",

            "1", "2", "3", "+",

            "0", ".", "=", "ENTER"
        };

        for (String text : buttons) {

            JButton button =
                createCalcButton(text);

            if (
                text.equals("+") ||
                text.equals("−") ||
                text.equals("×") ||
                text.equals("÷") ||
                text.equals("%") ||
                text.equals("=")
            ) {

                button.setBackground(
                    new Color(65, 65, 65)
                );
            }

            buttonPanel.add(button);

            button.addActionListener(
                new CalculatorListener(text)
            );
        }

        calculatorPanel.add(
            buttonPanel,
            BorderLayout.CENTER
        );

        contentPanel.add(
            calculatorPanel,
            BorderLayout.CENTER
        );

        contentPanel.revalidate();

        contentPanel.repaint();

        clearCalculation();
    }

    // Arithmetic calculator listener
    class CalculatorListener
        implements ActionListener {

        String value;

        CalculatorListener(String value) {
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            // Clear
            if (value.equals("AC")) {

                clearCalculation();

                return;
            }

            // Backspace
            if (value.equals("⌫")) {

                if (
                    !newNumber &&
                    display.getText().length() > 0
                ) {

                    String current =
                        display.getText();

                    if (current.length() == 1) {

                        display.setText("0");

                        newNumber = true;

                    } else {

                        display.setText(
                            current.substring(
                                0,
                                current.length() - 1
                            )
                        );
                    }
                }

                return;
            }

            // Numbers
            if (value.matches("[0-9]")) {

                if (
                    newNumber ||
                    display.getText().equals("0")
                ) {

                    display.setText(value);

                    newNumber = false;

                } else {

                    display.setText(
                        display.getText() + value
                    );
                }

                return;
            }

            // Decimal point
            if (value.equals(".")) {

                if (newNumber) {

                    display.setText("0.");

                    newNumber = false;

                } else if (
                    !display.getText().contains(".")
                ) {

                    display.setText(
                        display.getText() + "."
                    );
                }

                return;
            }

            // Operators
            if (
                value.equals("+") ||
                value.equals("−") ||
                value.equals("×") ||
                value.equals("÷") ||
                value.equals("%")
            ) {

                try {

                    firstNumber =
                        Double.parseDouble(
                            display.getText()
                        );

                    operator = value;

                    newNumber = true;

                } catch (Exception ex) {

                    display.setText("ERROR");
                }

                return;
            }

            // Calculate
            if (
                value.equals("=") ||
                value.equals("ENTER")
            ) {

                if (operator.equals("")) {
                    return;
                }

                try {

                    double secondNumber =
                        Double.parseDouble(
                            display.getText()
                        );

                    double result = 0;

                    if (operator.equals("+")) {

                        result =
                            firstNumber +
                            secondNumber;
                    }

                    else if (
                        operator.equals("−")
                    ) {

                        result =
                            firstNumber -
                            secondNumber;
                    }

                    else if (
                        operator.equals("×")
                    ) {

                        result =
                            firstNumber *
                            secondNumber;
                    }

                    else if (
                        operator.equals("÷")
                    ) {

                        if (secondNumber == 0) {

                            display.setText(
                                "ERROR"
                            );

                            return;
                        }

                        result =
                            firstNumber /
                            secondNumber;
                    }

                    else if (
                        operator.equals("%")
                    ) {

                        if (secondNumber == 0) {

                            display.setText(
                                "ERROR"
                            );

                            return;
                        }

                        result =
                            firstNumber %
                            secondNumber;
                    }

                    String resultText =
                        formatNumber(result);

                    display.setText(
                        resultText
                    );

                    history.add(
                        formatNumber(firstNumber)
                        + " "
                        + operator
                        + " "
                        + formatNumber(secondNumber)
                        + " = "
                        + resultText
                    );

                    operator = "";

                    firstNumber = result;

                    newNumber = true;

                } catch (Exception ex) {

                    display.setText("ERROR");
                }
            }
        }
    }

    // Format arithmetic result
    public String formatNumber(double number) {

        if (number == (int) number) {

            return String.valueOf(
                (int) number
            );
        }

        return String.valueOf(number);
    }

    // Clear arithmetic calculator
    public void clearCalculation() {

        firstNumber = 0;

        operator = "";

        newNumber = true;

        if (display != null) {

            display.setText("0");
        }
    }

    // Conversion Mode
    public void createConversionMode() {

        modeLabel.setText(
            "CONVERSION MODE"
        );

        contentPanel.removeAll();

        JPanel panel =
            new JPanel(new BorderLayout(5, 5));

        panel.setBackground(
            new Color(18, 18, 18)
        );

        display = new JTextField();

        display.setHorizontalAlignment(
            JTextField.RIGHT
        );

        display.setFont(
            new Font("Monospaced", Font.BOLD, 30)
        );

        display.setBackground(
            new Color(25, 25, 25)
        );

        display.setForeground(Color.WHITE);

        display.setCaretColor(Color.WHITE);

        display.setPreferredSize(
            new Dimension(0, 75)
        );

        display.setBorder(
            BorderFactory.createEmptyBorder(
                8, 12, 8, 12
            )
        );

        panel.add(
            display,
            BorderLayout.NORTH
        );

        JPanel buttons =
            new JPanel(
                new GridLayout(3, 2, 3, 3)
            );

        buttons.setBackground(
            new Color(18, 18, 18)
        );

        String[] conversions = {

            "DECIMAL → BINARY",

            "DECIMAL → OCTAL",

            "DECIMAL → HEXADECIMAL",

            "BINARY → DECIMAL",

            "OCTAL → DECIMAL",

            "HEXADECIMAL → DECIMAL"
        };

        for (String conversion : conversions) {

            JButton button =
                createCalcButton(conversion);

            button.setFont(
                new Font(
                    "Monospaced",
                    Font.BOLD,
                    11
                )
            );

            buttons.add(button);

            button.addActionListener(
                e -> performConversion(conversion)
            );
        }

        panel.add(
            buttons,
            BorderLayout.CENTER
        );

        contentPanel.add(
            panel,
            BorderLayout.CENTER
        );

        contentPanel.revalidate();

        contentPanel.repaint();
    }

    // Perform conversion
    public void performConversion(
        String conversion
    ) {

        try {

            String input =
                display.getText().trim();

            if (input.isEmpty()) {

                display.setText(
                    "ENTER NUMBER"
                );

                return;
            }

            String result = "";

            if (
                conversion.equals(
                    "DECIMAL → BINARY"
                )
            ) {

                int number =
                    Integer.parseInt(input);

                if (number < 0) {

                    result =
                        "-" +
                        Integer.toBinaryString(
                            Math.abs(number)
                        );

                } else {

                    result =
                        Integer.toBinaryString(
                            number
                        );
                }
            }

            else if (
                conversion.equals(
                    "DECIMAL → OCTAL"
                )
            ) {

                int number =
                    Integer.parseInt(input);

                if (number < 0) {

                    result =
                        "-" +
                        Integer.toOctalString(
                            Math.abs(number)
                        );

                } else {

                    result =
                        Integer.toOctalString(
                            number
                        );
                }
            }

            else if (
                conversion.equals(
                    "DECIMAL → HEXADECIMAL"
                )
            ) {

                int number =
                    Integer.parseInt(input);

                if (number < 0) {

                    result =
                        "-" +
                        Integer.toHexString(
                            Math.abs(number)
                        ).toUpperCase();

                } else {

                    result =
                        Integer.toHexString(
                            number
                        ).toUpperCase();
                }
            }

            else if (
                conversion.equals(
                    "BINARY → DECIMAL"
                )
            ) {

                result =
                    String.valueOf(
                        convertNegativeToDecimal(
                            input,
                            2
                        )
                    );
            }

            else if (
                conversion.equals(
                    "OCTAL → DECIMAL"
                )
            ) {

                result =
                    String.valueOf(
                        convertNegativeToDecimal(
                            input,
                            8
                        )
                    );
            }

            else if (
                conversion.equals(
                    "HEXADECIMAL → DECIMAL"
                )
            ) {

                result =
                    String.valueOf(
                        convertNegativeToDecimal(
                            input,
                            16
                        )
                    );
            }

            history.add(
                input + " → " + result
            );

            display.setText(result);

        } catch (Exception ex) {

            display.setText("INVALID");
        }
    }

    // Convert positive and negative values
    public int convertNegativeToDecimal(
        String input,
        int base
    ) {

        if (input.startsWith("-")) {

            String number =
                input.substring(1);

            return -Integer.parseInt(
                number,
                base
            );
        }

        return Integer.parseInt(
            input,
            base
        );
    }

    // Number System Mode
    public void createNumberSystemMode() {

        modeLabel.setText(
            "NUMBER SYSTEM MODE"
        );

        contentPanel.removeAll();

        JPanel panel =
            new JPanel(new BorderLayout(5, 5));

        panel.setBackground(
            new Color(18, 18, 18)
        );

        // Input boxes
        JPanel inputPanel =
            new JPanel(
                new GridLayout(2, 2, 4, 4)
            );

        inputPanel.setBackground(
            new Color(18, 18, 18)
        );

        JTextField firstInput =
            new JTextField();

        JTextField secondInput =
            new JTextField();

        firstInput.setFont(
            new Font(
                "Monospaced",
                Font.BOLD,
                18
            )
        );

        secondInput.setFont(
            new Font(
                "Monospaced",
                Font.BOLD,
                18
            )
        );

        firstInput.setPreferredSize(
            new Dimension(0, 45)
        );

        secondInput.setPreferredSize(
            new Dimension(0, 45)
        );

        JLabel firstLabel =
            new JLabel("FIRST NUMBER");

        JLabel secondLabel =
            new JLabel("SECOND NUMBER");

        firstLabel.setForeground(Color.WHITE);

        secondLabel.setForeground(Color.WHITE);

        firstLabel.setFont(
            new Font(
                "Monospaced",
                Font.BOLD,
                11
            )
        );

        secondLabel.setFont(
            new Font(
                "Monospaced",
                Font.BOLD,
                11
            )
        );

        inputPanel.add(firstLabel);

        inputPanel.add(firstInput);

        inputPanel.add(secondLabel);

        inputPanel.add(secondInput);

        panel.add(
            inputPanel,
            BorderLayout.NORTH
        );

        // Selection area
        JPanel centerPanel =
            new JPanel(
                new GridLayout(3, 1, 4, 4)
            );

        centerPanel.setBackground(
            new Color(18, 18, 18)
        );

        String[] systems = {

            "Binary",
            "Octal",
            "Decimal",
            "Hexadecimal"
        };

        JComboBox<String> systemBox =
            new JComboBox<>(systems);

        String[] operations = {

            "Addition",
            "Subtraction",
            "Multiplication",
            "Division",
            "Remainder"
        };

        JComboBox<String> operationBox =
            new JComboBox<>(operations);

        JButton calculateButton =
            createCalcButton("CALCULATE");

        centerPanel.add(systemBox);

        centerPanel.add(operationBox);

        centerPanel.add(calculateButton);

        panel.add(
            centerPanel,
            BorderLayout.CENTER
        );

        // Result box
        JTextArea resultArea =
            new JTextArea();

        resultArea.setFont(
            new Font(
                "Monospaced",
                Font.BOLD,
                20
            )
        );

        resultArea.setBackground(
            new Color(25, 25, 25)
        );

        resultArea.setForeground(
            new Color(100, 220, 140)
        );

        resultArea.setEditable(false);

        resultArea.setLineWrap(true);

        resultArea.setBorder(
            BorderFactory.createEmptyBorder(
                10, 12, 10, 12
            )
        );

        JScrollPane scrollPane =
            new JScrollPane(resultArea);

        scrollPane.setPreferredSize(
            new Dimension(0, 100)
        );

        panel.add(
            scrollPane,
            BorderLayout.SOUTH
        );

        // Calculate button
        calculateButton.addActionListener(e -> {

            try {

                String first =
                    firstInput.getText().trim();

                String second =
                    secondInput.getText().trim();

                String system =
                    (String) systemBox.getSelectedItem();

                String operation =
                    (String) operationBox.getSelectedItem();

                int base = 10;

                if (system.equals("Binary")) {

                    base = 2;

                }

                else if (system.equals("Octal")) {

                    base = 8;

                }

                else if (
                    system.equals("Hexadecimal")
                ) {

                    base = 16;
                }

                // Convert input numbers to decimal
                int num1 =
                    convertNegativeToDecimal(
                        first,
                        base
                    );

                int num2 =
                    convertNegativeToDecimal(
                        second,
                        base
                    );

                int result = 0;

                // Perform operation
                if (
                    operation.equals("Addition")
                ) {

                    result =
                        num1 + num2;
                }

                else if (
                    operation.equals("Subtraction")
                ) {

                    result =
                        num1 - num2;
                }

                else if (
                    operation.equals("Multiplication")
                ) {

                    result =
                        num1 * num2;
                }

                else if (
                    operation.equals("Division")
                ) {

                    if (num2 == 0) {

                        resultArea.setText(
                            "CANNOT DIVIDE BY ZERO"
                        );

                        return;
                    }

                    result =
                        num1 / num2;
                }

                else if (
                    operation.equals("Remainder")
                ) {

                    if (num2 == 0) {

                        resultArea.setText(
                            "CANNOT DIVIDE BY ZERO"
                        );

                        return;
                    }

                    result =
                        num1 % num2;
                }

                // Convert result back to selected base
                String resultString;

                if (result < 0) {

                    if (base == 2) {

                        resultString =
                            "-" +
                            Integer.toBinaryString(
                                Math.abs(result)
                            );
                    }

                    else if (base == 8) {

                        resultString =
                            "-" +
                            Integer.toOctalString(
                                Math.abs(result)
                            );
                    }

                    else if (base == 16) {

                        resultString =
                            "-" +
                            Integer.toHexString(
                                Math.abs(result)
                            ).toUpperCase();
                    }

                    else {

                        resultString =
                            String.valueOf(result);
                    }

                } else {

                    if (base == 2) {

                        resultString =
                            Integer.toBinaryString(
                                result
                            );
                    }

                    else if (base == 8) {

                        resultString =
                            Integer.toOctalString(
                                result
                            );
                    }

                    else if (base == 16) {

                        resultString =
                            Integer.toHexString(
                                result
                            ).toUpperCase();
                    }

                    else {

                        resultString =
                            String.valueOf(result);
                    }
                }

                // Show result
                resultArea.setText(
                    "RESULT\n\n" +
                    resultString
                );

                // Add to history
                history.add(
                    first
                    + " "
                    + operation
                    + " "
                    + second
                    + " = "
                    + resultString
                    + " ("
                    + system
                    + ")"
                );

            } catch (Exception ex) {

                resultArea.setText(
                    "INVALID INPUT"
                );
            }
        });

        contentPanel.add(
            panel,
            BorderLayout.CENTER
        );

        contentPanel.revalidate();

        contentPanel.repaint();
    }

    // Number Information Mode
    public void createInfoMode() {

        modeLabel.setText(
            "NUMBER INFORMATION"
        );

        contentPanel.removeAll();

        JPanel panel =
            new JPanel(new BorderLayout(5, 5));

        panel.setBackground(
            new Color(18, 18, 18)
        );

        JTextField input =
            new JTextField();

        input.setFont(
            new Font(
                "Monospaced",
                Font.BOLD,
                20
            )
        );

        JButton check =
            createCalcButton(
                "CHECK NUMBER"
            );

        check.setFont(
            new Font(
                "Monospaced",
                Font.BOLD,
                12
            )
        );

        JTextArea result =
            new JTextArea();

        result.setFont(
            new Font(
                "Monospaced",
                Font.PLAIN,
                16
            )
        );

        result.setBackground(
            new Color(25, 25, 25)
        );

        result.setForeground(Color.WHITE);

        result.setEditable(false);

        JPanel topPanel =
            new JPanel(
                new BorderLayout(4, 4)
            );

        topPanel.setBackground(
            new Color(18, 18, 18)
        );

        topPanel.add(
            input,
            BorderLayout.CENTER
        );

        topPanel.add(
            check,
            BorderLayout.EAST
        );

        panel.add(
            topPanel,
            BorderLayout.NORTH
        );

        panel.add(
            new JScrollPane(result),
            BorderLayout.CENTER
        );

        check.addActionListener(e -> {

            try {

                int num =
                    Integer.parseInt(
                        input.getText()
                    );

                StringBuilder info =
                    new StringBuilder();

                info.append(
                    "DECIMAL: "
                ).append(num);

                info.append("\n\n");

                info.append(
                    "BINARY: "
                ).append(
                    toBinary(num)
                );

                info.append("\n\n");

                info.append(
                    "OCTAL: "
                ).append(
                    toOctal(num)
                );

                info.append("\n\n");

                info.append(
                    "HEXADECIMAL: "
                ).append(
                    toHex(num)
                );

                info.append("\n\n");

                info.append(
                    "TYPE: "
                ).append(
                    evenOdd(num)
                );

                info.append("\n\n");

                info.append(
                    "PRIME: "
                ).append(
                    isPrime(num)
                    ? "Yes"
                    : "No"
                );

                result.setText(
                    info.toString()
                );

                history.add(
                    "Number Info: " + num
                );

            } catch (Exception ex) {

                result.setText(
                    "INVALID NUMBER"
                );
            }
        });

        contentPanel.add(
            panel,
            BorderLayout.CENTER
        );

        contentPanel.revalidate();

        contentPanel.repaint();
    }

    // History Mode
    public void createHistoryMode() {

        modeLabel.setText(
            "CALCULATION HISTORY"
        );

        contentPanel.removeAll();

        JPanel panel =
            new JPanel(new BorderLayout(5, 5));

        panel.setBackground(
            new Color(18, 18, 18)
        );

        JTextArea historyArea =
            new JTextArea();

        historyArea.setFont(
            new Font(
                "Monospaced",
                Font.PLAIN,
                15
            )
        );

        historyArea.setBackground(
            new Color(25, 25, 25)
        );

        historyArea.setForeground(
            Color.WHITE
        );

        historyArea.setEditable(false);

        if (history.isEmpty()) {

            historyArea.setText(
                "No calculation history."
            );

        } else {

            StringBuilder text =
                new StringBuilder();

            for (
                int i = 0;
                i < history.size();
                i++
            ) {

                text.append(
                    i + 1
                )
                .append(". ")
                .append(
                    history.get(i)
                )
                .append("\n");
            }

            historyArea.setText(
                text.toString()
            );
        }

        panel.add(
            new JScrollPane(historyArea),
            BorderLayout.CENTER
        );

        JButton clearButton =
            createCalcButton(
                "CLEAR HISTORY"
            );

        clearButton.setFont(
            new Font(
                "Monospaced",
                Font.BOLD,
                13
            )
        );

        panel.add(
            clearButton,
            BorderLayout.SOUTH
        );

        clearButton.addActionListener(e -> {

            history.clear();

            historyArea.setText(
                "No calculation history."
            );
        });

        contentPanel.add(
            panel,
            BorderLayout.CENTER
        );

        contentPanel.revalidate();

        contentPanel.repaint();
    }

    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            NumSysCalc gui =
                new NumSysCalc(true);

            gui.setVisible(true);
        });
    }
}
