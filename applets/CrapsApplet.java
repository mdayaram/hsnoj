import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class CrapsApplet extends JApplet
			 			implements ActionListener
{
private int roll1, roll2, total;

private JLabel titleLabel, yourrollLabel, totalLabel;
private JButton die1Button, die2Button, rollButton, playagainButton;
private JTextField totalField, youneedField;
private JPanel titlePanel, gamePanel, againPanel;
private ImageIcon blank, a1, a2, a3, a4, a5, a6;
private int roll, point;

public Random random = new Random();

public void init() {


	blank = createAppletImageIcon("cblank.GIF");
	a1 = createAppletImageIcon("a1.GIF");
	a2 = createAppletImageIcon("a2.GIF");
	a3 = createAppletImageIcon("a3.GIF");
	a4 = createAppletImageIcon("a4.GIF");
	a5 = createAppletImageIcon("a5.GIF");
	a6 = createAppletImageIcon("a6.GIF");

	titleLabel = new JLabel("©NaW Brings You: Craps");
	yourrollLabel = new JLabel("Your Roll:");
	totalLabel = new JLabel("Total");

	die1Button = new JButton(blank);
	die2Button = new JButton(blank);
	rollButton = new JButton("Roll");
	playagainButton = new JButton("Play Again");
	playagainButton.setVisible(false);

	totalField = new JTextField("", 3);
	youneedField = new JTextField("", 20);
	totalField.setEditable(false);
	youneedField.setEditable(false);
	youneedField.setText("You need a 7 or 11 to win");

	titlePanel = new JPanel();
	gamePanel = new JPanel();
	againPanel = new JPanel();

	roll = 0;

	Container content = getContentPane();
	Color c = new Color(145,240,15);
	content.setBackground(Color.black);
	titlePanel.setBackground(Color.black);
	gamePanel.setBackground(Color.black);
	againPanel.setBackground(Color.black);

	totalField.setBackground(Color.black);
	youneedField.setBackground(Color.black);

	die1Button.setBackground(Color.black);
	die2Button.setBackground(Color.black);
	rollButton.setBackground(Color.black);
	playagainButton.setBackground(Color.black);

	rollButton.setForeground(c);
	playagainButton.setForeground(c);
	titleLabel.setForeground(c);
	totalField.setForeground(c);
	youneedField.setForeground(c);
	yourrollLabel.setForeground(c);
	totalLabel.setForeground(c);

	FlowLayout layout = new FlowLayout();

	titlePanel.setLayout(layout);
	gamePanel.setLayout(layout);
	againPanel.setLayout(layout);

	content.setLayout(layout);

	titlePanel.add(titleLabel);

	gamePanel.add(yourrollLabel);
	gamePanel.add(die1Button);
	gamePanel.add(die2Button);
	gamePanel.add(totalLabel);
	gamePanel.add(totalField);

	againPanel.add(youneedField);
	againPanel.add(rollButton);
	againPanel.add(playagainButton);

	content.add(titlePanel);
	content.add(gamePanel);
	content.add(againPanel);

	rollButton.addActionListener(this);
	playagainButton.addActionListener(this);
}

public void actionPerformed (ActionEvent ae) {
	if (ae.getSource() == rollButton) {
		roll();
	}else if (ae.getSource() == playagainButton) {
		again();
	}
}

public void roll() {
	roll++;
	roll1 = random.nextInt(6) + 1;
	roll2 = random.nextInt(6) + 1;
	total = roll1 + roll2;

	die1Button.setIcon(null);
	die2Button.setIcon(null);

	die1Button.setIcon(finddieFace(roll1));
	die2Button.setIcon(finddieFace(roll2));

	totalField.setText("" + total);

	if (roll == 1) {
		if (total == 7 || total == 11 || total == 2 || total == 3 || total == 12) {
			rollButton.setVisible(false);
			playagainButton.setVisible(true);
		}

		if (total == 7) {
			youneedField.setText("You rolled a 7, YOU WIN!!!");
		}else if (total == 11) {
			youneedField.setText("You rolled an 11, YOU WIN!!!");
		}else if (total ==2) {
			youneedField.setText("You rolled a 2, snake eyes, you lose.");
		}else if (total == 3) {
			youneedField.setText("You rolled a 3, craps, you lose.");
		}else if (total == 12) {
			youneedField.setText("You rolled a 12, box cars, you lose.");
		}else {
			point = total;
			youneedField.setText("You rolled a " + total + ", You need a " + point + " to win.");
		}
	}else{
		if (total == 7 || total == point) {
			rollButton.setVisible(false);
			playagainButton.setVisible(true);
		}

		if (total == 7) {
			youneedField.setText("You rolled a 7, you lose.");
		}else if (total == point) {
			youneedField.setText("You rolled a " + total + ", YOU WIN!!!");
		}else{
			youneedField.setText("You rolled a " + total + ", You need a " + point + " to win.");
		}
	}
}

public void again() {
	die1Button.setIcon(null);
	die2Button.setIcon(null);
	die1Button.setIcon(blank);
	die2Button.setIcon(blank);

	rollButton.setVisible(true);
	playagainButton.setVisible(false);

	roll = 0;
	totalField.setText("");
	youneedField.setText("You need a 7 or 11 to win.");
}

public ImageIcon finddieFace(int die) {
	if (die == 1) {
		return a1;
	}else if (die == 2) {
		return a2;
	}else if (die == 3) {
		return a3;
	}else if (die == 4) {
		return a4;
	}else if (die == 5) {
		return a5;
	}else if (die == 6) {
		return a6;
	}else{
		return blank;
	}
}

	protected static ImageIcon createAppletImageIcon(String path) {
		int MAX_IMAGE_SIZE = 2000;

		int count = 0;
		BufferedInputStream imgStream = new BufferedInputStream(CrapsApplet.class.getResourceAsStream(path));
		if (imgStream == null) return null;

		byte buf[] = new byte[MAX_IMAGE_SIZE];
		try {
			count = imgStream.read(buf);
		} catch (IOException ieo) {
			System.err.println("Couldn't read stream from file: " + path);
		}
		imgStream.close();
		if (count <= 0) {
			System.err.println("Empty file: " + path);
			return null;
		}
		return new ImageIcon(Toolkit.getDefaultToolkit().createImage(buf));

	}
}


