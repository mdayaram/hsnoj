import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class CalculatorApplet extends JApplet
							 implements ActionListener
{

private JLabel op1Label, op2Label, resultLabel, insLabel, titleLabel;
private JTextField op1Field, op2Field, resultField;
private JButton plusButton, minusButton, timeButton, divButton, sqButton, rtButton;
private JPanel buttonPanel, inputPanel, resultPanel, buttonPanel2, insPanel, titlePanel;

Font f = new Font("Monospaced", Font.BOLD, 25);
DecimalFormat threedigit = new DecimalFormat ("#,##0.000");

public void init() {

	op1Label = new JLabel("x value ");
	op2Label = new JLabel("  y value ");
	resultLabel = new JLabel("Result = ");
	op1Field = new JTextField("", 4);
	op2Field = new JTextField("", 4);
	resultField = new JTextField("", 12);
	resultField.setEditable(false);
	titleLabel = new JLabel("©NaW Brings You: Calculator on Steroids");

	plusButton = new JButton("x+y");
	minusButton = new JButton("x-y");
	timeButton = new JButton("x*y");
	divButton = new JButton("x/y");
	sqButton = new JButton("x^y");
	rtButton = new JButton("xRoot[y]");

	inputPanel = new JPanel();
	resultPanel = new JPanel();
	buttonPanel = new JPanel();
	buttonPanel2 = new JPanel();
	insPanel = new JPanel();
	titlePanel = new JPanel();

	plusButton.setFont(f);
	minusButton.setFont(f);
	timeButton.setFont(f);
	divButton.setFont(f);
	sqButton.setFont(f);
	rtButton.setFont(f);

	Container content = getContentPane();

	content.setBackground(Color.black);

	inputPanel.setBackground(Color.black);
	resultPanel.setBackground(Color.black);
	buttonPanel.setBackground(Color.black);
	buttonPanel2.setBackground(Color.black);
	insPanel.setBackground(Color.black);
	titlePanel.setBackground(Color.black);
	Color c = new Color(145,240,15);
	resultField.setBackground(Color.black);
	resultField.setForeground(c);

	plusButton.setBackground(Color.black);
	minusButton.setBackground(Color.black);
	timeButton.setBackground(Color.black);
	divButton.setBackground(Color.black);
	sqButton.setBackground(Color.black);
	rtButton.setBackground(Color.black);

	plusButton.setForeground(c);
	minusButton.setForeground(c);
	timeButton.setForeground(c);
	divButton.setForeground(c);
	sqButton.setForeground(c);
	rtButton.setForeground(c);

	titleLabel.setForeground(c);
	op1Label.setForeground(c);
	resultLabel.setForeground(c);
	op2Label.setForeground(c);

	FlowLayout layout = new FlowLayout();

	inputPanel.setLayout(layout);
	resultPanel.setLayout(layout);
	buttonPanel.setLayout(layout);
	buttonPanel2.setLayout(layout);
	insPanel.setLayout(layout);
	titlePanel.setLayout(layout);

	content.setLayout(layout);

	titlePanel.add(titleLabel);

	inputPanel.add(op1Label);
	inputPanel.add(op1Field);
	inputPanel.add(op2Label);
	inputPanel.add(op2Field);

	resultPanel.add(resultLabel);
	resultPanel.add(resultField);

	buttonPanel.add(plusButton);
	buttonPanel.add(minusButton);
	buttonPanel.add(timeButton);
	buttonPanel.add(divButton);

	buttonPanel2.add(sqButton);
	buttonPanel2.add(rtButton);

	content.add(titlePanel);
	content.add(inputPanel);
	content.add(resultPanel);
	content.add(buttonPanel);
	content.add(buttonPanel2);

	minusButton.addActionListener(this);
	plusButton.addActionListener(this);
	timeButton.addActionListener(this);
	divButton.addActionListener(this);
	sqButton.addActionListener(this);
	rtButton.addActionListener(this);

}

public void actionPerformed(ActionEvent ae){
	if (ae.getSource() == plusButton){
		addOperation();
	}else if (ae.getSource() == minusButton){
		subOperation();
	}else if (ae.getSource() == timeButton){
		timeOperation();
	}else if (ae.getSource() == divButton){
		divOperation();
	}else if (ae.getSource() == rtButton){
		rtOperation();
	}else if (ae.getSource() == sqButton){
		sqOperation();
	}
}

public void addOperation(){
	String s1=op1Field.getText(), s2=op2Field.getText();
	if(s1.indexOf(".") < 0 && s2.indexOf(".") < 0){
		int operand1 = getIntValue(op1Field);
		int operand2 = getIntValue(op2Field);
		if(operand1 == Integer.MAX_VALUE || operand2 == Integer.MAX_VALUE)return;
		resultField.setText("" + (operand1+operand2));
	}else{
		double operand1 = getDoubleValue(op1Field);
		double operand2 = getDoubleValue(op2Field);
		if(operand1 == Double.MAX_VALUE || operand2 == Double.MAX_VALUE)return;
		resultField.setText("" + (operand1+operand2));
	}

}

public void subOperation(){
	String s1=op1Field.getText(), s2=op2Field.getText();
	if(s1.indexOf(".") < 0 && s2.indexOf(".") < 0){
		int operand1 = getIntValue(op1Field);
		int operand2 = getIntValue(op2Field);
		if(operand1 == Integer.MAX_VALUE || operand2 == Integer.MAX_VALUE)return;
		resultField.setText ("" + (operand1-operand2));
	}else{
		double operand1 = getDoubleValue(op1Field);
		double operand2 = getDoubleValue(op2Field);
		if(operand1 == Double.MAX_VALUE || operand2 == Double.MAX_VALUE)return;
		resultField.setText ("" + (operand1-operand2));
	}

}

public void timeOperation(){
	String s1=op1Field.getText(), s2=op2Field.getText();
	if(s1.indexOf(".") < 0 && s2.indexOf(".") < 0){
		int operand1 = getIntValue(op1Field);
		int operand2 = getIntValue(op2Field);
		if(operand1 == Integer.MAX_VALUE || operand2 == Integer.MAX_VALUE)return;
		resultField.setText ("" + (operand1*operand2));
	}else{
		double operand1 = getDoubleValue(op1Field);
		double operand2 = getDoubleValue(op2Field);
		if(operand1 == Double.MAX_VALUE || operand2 == Double.MAX_VALUE)return;
		resultField.setText ("" + (operand1*operand2));
	}

}

public void divOperation(){
	double operand1 = getDoubleValue(op1Field);
	double operand2 = getDoubleValue(op2Field);
	if(operand1 == Double.MAX_VALUE || operand2 == Double.MAX_VALUE)return;
	if (operand2 == 0){
		resultField.setText("Error, division by zero.");
	}else{
		resultField.setText("" + threedigit.format(operand1/operand2));
	}

}

/*public void rtOperation()
    {
        double operand1 = getDoubleValue(op1Field);
        if(operand1 == Double.MAX_VALUE)return;
        double result = Math.sqrt(operand1);
        if(result * result == operand1)
            resultField.setText("" + threedigit.format(result));
        else
            resultField.setText("~" + threedigit.format(result));
    }
*/

public void rtOperation(){
	String sign = "";
	double x = getDoubleValue(op1Field);
	double y = getDoubleValue(op2Field);
	if(x == Double.MAX_VALUE || y == Double.MAX_VALUE) {
		resultField.setText("User Error.");
		return;
	}
	if(x == 0) {
		resultField.setText("Error: zero root.");
		return;
	}
	if(y < 0 && x%2 == 0){
		resultField.setText("Error: no real solution.");
		return;
	}
	if(y < 0 && x%2 != 0) {
		y = Math.abs(y);
		sign = "-";
	}
	double result = Math.pow(y, 1 / x);
	resultField.setText(sign+threedigit.format(result));

}

public void sqOperation()
    {
       	double result;
       	double operand1 = getDoubleValue(op1Field);
       	double operand2 = getDoubleValue(op2Field);
       	if(operand1 == Double.MAX_VALUE || operand2 == Double.MAX_VALUE)return;
		result = Math.pow(operand1, operand2);
		resultField.setText(""+threedigit.format(result));
    }

private int getIntValue(JTextField jtf){
	String s = jtf.getText();
	int value;
	try{
		value = Integer.parseInt(s.trim());
	}catch(Exception e){
		System.err.println(e.toString());
		resultField.setText("User Error.");
		return Integer.MAX_VALUE;
	}
	return value;
}

private double getDoubleValue(JTextField jtf){
	String s = jtf.getText();
	double value;
	try{
		value = Double.parseDouble(s.trim());
	}catch(Exception e){
		System.err.println(e.toString());
		resultField.setText("User Error.");
		return Double.MAX_VALUE;
	}
	return value;
}

}