import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class NumberGuessApplet extends JApplet
							  implements ActionListener
{
private int secret, guess;

private JLabel titleLabel,insLabel, guessLabel, resultLabel;
private JTextField guessField, resultField;
private JButton submitButton, againButton;
private JPanel titlePanel,insPanel, guessPanel, resultPanel, buttonPanel;
private static final String G = "Your guess is ";

Random random = new Random();

public void init() {
	titleLabel = new JLabel("©NaW Brings You:  Number Guess");
	insLabel = new JLabel ("I am thinking of a number between 1 and 100");
	guessLabel = new JLabel ("What do you think it is?");

	guessField = new JTextField ("", 5);
	resultField = new JTextField ("", 18);
	resultField.setEditable (false);

	submitButton = new JButton ("Submit");
	againButton = new JButton ("Play again?");
	againButton.setVisible (false);

	titlePanel = new JPanel();
	insPanel = new JPanel ();
	guessPanel = new JPanel ();
	resultPanel =  new JPanel ();
	buttonPanel = new JPanel ();

	Container content = getContentPane();

	content.setBackground (Color.black);

	titlePanel.setBackground(Color.black);
	insPanel.setBackground (Color.black);
	guessPanel.setBackground (Color.black);
	resultPanel.setBackground (Color.black);
	buttonPanel.setBackground (Color.black);
	Color c = new Color(145,240,15);
	insLabel.setForeground (c);
	guessLabel.setForeground (c);
	titleLabel.setForeground(c);

	resultField.setBackground (Color.black);
	resultField.setForeground (Color.green);

	submitButton.setBackground (Color.black);
	againButton.setBackground (Color.black);

	submitButton.setForeground (c);
	againButton.setForeground (c);

	FlowLayout layout = new FlowLayout();

	titlePanel.setLayout(layout);
	insPanel.setLayout (layout);
	guessPanel.setLayout (layout);
	resultPanel.setLayout (layout);
	buttonPanel.setLayout (layout);

	content.setLayout (layout);

	titlePanel.add(titleLabel);

	insPanel.add (insLabel);

	guessPanel.add (guessLabel);
	guessPanel.add (guessField);

	resultPanel.add (resultField);

	buttonPanel.add (submitButton);
	buttonPanel.add (againButton);

	content.add (titlePanel);
	content.add (insPanel);
	content.add (guessPanel);
	content.add (resultPanel);
	content.add (buttonPanel);

	submitButton.addActionListener (this);
	againButton.addActionListener (this);

	secret = random.nextInt(100) + 1;
	guess = 0;
}

public void actionPerformed (ActionEvent ae) {
	if (ae.getSource() == submitButton) {
		submit();
	}else if (ae.getSource() == againButton) {
		again();
		submitButton.setVisible(true);
	}
}

public void submit() {
	String s;

	s = guessField.getText();
	guess = Integer.parseInt(s.trim());

	if (guess == secret) {
		resultField.setText(G+"correct!");
		againButton.setVisible (true);
		submitButton.setVisible(false);
	}else if (guess > secret && guess <=100 && guess >=1){
		resultField.setText(G+"too high.");
	}else if (guess < secret && guess <=100 && guess >=1){
		resultField.setText(G+"too low.");
	}else{
		resultField.setText("Slut! I said between 1 and 100!");
	}
}

public void again() {
	guessField.setText ("");
	resultField.setText ("");
	againButton.setVisible (false);

	secret = random.nextInt(100) + 1;
}
}