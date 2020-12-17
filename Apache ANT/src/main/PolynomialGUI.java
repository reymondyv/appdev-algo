
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class PolynomialGUI  extends JPanel{

    private JTextField polynomial1 = new JTextField();
    private JTextField polynomial2 = new JTextField();
    private JTextField finalResult = new JTextField();
    private JTextField polynomialEvaluateResult = new JTextField();
    private JTextField polynomialEvaluateResult2 = new JTextField();
    private JTextField evaluateText = new JTextField();

    private JButton addition = new JButton("Add");
    private JButton subtraction = new JButton("Subtract");
    private JButton multiplication = new JButton("Multiply");

    private JButton format = new JButton("Format");
    private JButton evaluate = new JButton("Evaluate");
    private JButton clear = new JButton("Clear");

    private JLabel polynomialLabel = new JLabel("Enter Polynomial 1:");
    private JLabel polynomialLabel2 = new JLabel("Enter Polynomial 2:");
    private JLabel result = new JLabel("Final Result:");
    private JLabel evaluateValue1 = new JLabel("Polynomial 1 P(x): ");
    private JLabel evaluateValue2 = new JLabel("Polynomial 2 P(x): ");

    private JFrame frame = new JFrame("Polynomial Calculator");
    private JFrame nFrame = new JFrame("Evaluate Result");

    public PolynomialGUI() {

        result.setSize(90, 25);
        result.setLocation(20, 70);

        polynomial1.setHorizontalAlignment(JTextField.LEFT);
        polynomial1.setBounds(140, 10, 250, 25);

        polynomial2.setHorizontalAlignment(JTextField.LEFT);
        polynomial2.setBounds(140, 40, 250, 25);

        polynomialLabel.setBounds(20, 10, 200, 30);
        polynomialLabel2.setBounds(20, 40, 200, 30);

        addition.setBounds(40, 130, 150, 40);
        addition.addActionListener(new ButtonHandler());

        subtraction.setBounds(240, 130, 150, 40);
        subtraction.addActionListener(new ButtonHandler());

        multiplication.setBounds(40, 180, 150, 40);
        multiplication.addActionListener(new ButtonHandler());

        evaluateText.setBounds(240, 230, 150, 40);
        evaluateText.setHorizontalAlignment(JTextField.CENTER);
        evaluateText.addActionListener(new ButtonHandler());


        evaluate.setBounds(240, 180, 150, 50);
        evaluate.addActionListener(new ButtonHandler());

        format.setBounds(40, 230, 150, 40);
        format.addActionListener(new ButtonHandler());
        clear.setBounds(140, 280, 130, 40);
        clear.addActionListener(new ButtonHandler());

        finalResult.setHorizontalAlignment(JTextField.CENTER);
        finalResult.setBounds(140, 75, 250, 50);
        finalResult.setEditable(false);


        frame.add(polynomial2);
        frame.add(polynomial1);
        frame.add(polynomialLabel);
        frame.add(polynomialLabel2);
        frame.add(addition);
        frame.add(subtraction);
        frame.add(multiplication);
        frame.add(evaluateText);
        frame.add(format);
        frame.add(clear);
        frame.add(evaluate);
        frame.add(finalResult);
        frame.setSize(450, 380);
        frame.setResizable(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(result);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {

                List<Term> termList = new ArrayList<>();
                List<Term> termList2 = new ArrayList<>();



                String firstPolynomial = polynomial1.getText();
                String[] splitPolynomial = firstPolynomial.split("[-+]");

                String secondPolynomial = polynomial2.getText();
                String[] splitPolynomial2 = secondPolynomial.split("[-+]");


                PolynomialSpliter(termList, splitPolynomial);
                PolynomialSpliter(termList2, splitPolynomial2);


                Polynomial polynomialFinal1 = new Polynomial('x', termList);
                Polynomial polynomialFinal2 = new Polynomial('x', termList2);

                String resultPolynomial = "";
                double doubleResult = 0.0;
                double doubleResult2 = 0.0;

                BufferedWriter bw = new BufferedWriter(new FileWriter("data\\transaction.txt",true));
                bw.newLine();
                bw.write("First Polynomial: "+polynomial1.getText());
                bw.newLine();
                bw.write("Second Polynomial: "+polynomial2.getText());
                bw.newLine();


                if (e.getSource() == addition) {

                    resultPolynomial = String.valueOf(polynomialFinal1.add(polynomialFinal2));
                    bw.write("Answer(addition): "+resultPolynomial);
                    bw.newLine();
                    bw.close();

                } else if (e.getSource() == subtraction) {

                    resultPolynomial = polynomialFinal1.subtract(polynomialFinal2).toString();
                    bw.write("Answer(subtraction): "+resultPolynomial);
                    bw.newLine();
                    bw.close();

                } else if (e.getSource() == multiplication) {

                    resultPolynomial = polynomialFinal1.multiply(polynomialFinal2).toString();
                    bw.write("Answer(multiplication): "+resultPolynomial);
                    bw.newLine();
                    bw.close();

                } else if (e.getSource() == evaluateText) {


                } else if (e.getSource() == evaluate) {
                    try {

                    evaluateValue1.setBounds(5, 30, 150, 30);
                    polynomialEvaluateResult.setBounds(110, 30, 100, 30);
                    polynomialEvaluateResult.setHorizontalAlignment(JTextField.CENTER);
                    polynomialEvaluateResult.setEditable(false);

                    evaluateValue2.setBounds(5, 90, 150, 30);
                    polynomialEvaluateResult2.setBounds(110, 90, 100, 30);
                    polynomialEvaluateResult2.setHorizontalAlignment(JTextField.CENTER);
                    polynomialEvaluateResult2.setEditable(false);

                    nFrame.setSize(300, 200);
                    nFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    nFrame.setResizable(true);
                    nFrame.setLayout(null);
                    nFrame.setLocationRelativeTo(null);
                    nFrame.setVisible(true);
                    nFrame.setResizable(false);

                    nFrame.add(evaluateValue2);
                    nFrame.add(evaluateValue1);
                    nFrame.add(polynomialEvaluateResult);
                    nFrame.add(polynomialEvaluateResult2);


                    double q = Double.parseDouble(evaluateText.getText());
                    doubleResult = polynomialFinal1.evaluate(q);
                    doubleResult2 = polynomialFinal2.evaluate(q);

                    polynomialEvaluateResult.setText(String.valueOf(doubleResult));
                    polynomialEvaluateResult2.setText(String.valueOf(doubleResult2));
                    finalResult.setText(String.valueOf(resultPolynomial));

                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "You must enter values to evaluate!","ERROR 002",JOptionPane.ERROR_MESSAGE);
                    }

                } else if (e.getSource() == format) {


                } else if (e.getSource() == clear) {
                    polynomial1.setText("");
                    polynomial2.setText("");
                    finalResult.setText("");
                    evaluateText.setText("");
                }

                finalResult.setText(String.valueOf(resultPolynomial));

            } catch (NumberFormatException exc){
                JOptionPane.showMessageDialog(null, "You must enter Polynomial!","ERROR 101!",JOptionPane.ERROR_MESSAGE);
                exc.printStackTrace();
            }  catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "ERROR!","ERROR 002",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }

    public void PolynomialSpliter(List<Term> termList, String[] s) {
        for (int i = 0; i < s.length; i++) {

            if (s[i].contains("^")) {
                String[] initialSplit = s[i].trim().split("x\\^");
                if (initialSplit[0].equals("")){
                    int expo = Integer.parseInt(initialSplit[1]);
                    termList.add(new Term(1,expo));
                } else {
                    int coef = Integer.parseInt(initialSplit[0]);
                    int expo = Integer.parseInt(initialSplit[1]);
                    termList.add(new Term(coef, expo));
                }
            } else if (s[i].contains("x")) {

                String[] initialSplit = s[i].trim().split("x");
                if (initialSplit.length == 0) {
                    termList.add(new Term(1, 1));
                } else {
                    int coef = Integer.parseInt(initialSplit[0]); //10x^3 + 5x^2 + 2x + 1
                    termList.add(new Term(coef, 1));
                }

            } else {
                termList.add(new Term(Integer.parseInt(s[i].trim()), 0));
            }
        }
    }


    public static void main(String[] args) {
            new PolynomialGUI();

    }
}