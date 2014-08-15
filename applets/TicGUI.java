import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TicGUI extends JApplet
					implements ActionListener{

	private JButton[][] board;
	private boolean[][] pressed;
	private Container content;
	private JLabel scoreLabel;
	private boolean lastX;
	private int xscore, oscore;

	public void init(){
		xscore=0;
		oscore=0;
		pressed = new boolean[3][3];
		lastX = false;
		board = new JButton[3][3];
		Container content = getContentPane();
		JPanel titlePanel = new JPanel();
		JPanel scorePanel = new JPanel();
		JPanel gamePanel = new JPanel();
		JLabel titleLabel = new JLabel("Tic Tac Toe, bitch!");
		scoreLabel = new JLabel("Score   X:   "+xscore+"             O:   "+oscore);

		GridLayout gameLayout = new GridLayout(3,3);
		FlowLayout layout = new FlowLayout();
		gamePanel.setLayout(gameLayout);
		titlePanel.setLayout(layout);
		scorePanel.setLayout(layout);
		content.setLayout(layout);

		Color color = new Color(145,240,15);

		for(int r=0;r<board.length;r++)
			for(int c=0;c<board[0].length;c++){
				board[r][c] = new JButton();
				board[r][c].setText("   ");
				gamePanel.add(board[r][c]);
				board[r][c].addActionListener(this);
				board[r][c].setBackground(Color.black);
				board[r][c].setForeground(color);
			}

		scorePanel.add(scoreLabel);
		titlePanel.add(titleLabel);
		content.add(titlePanel);
		content.add(gamePanel);
		content.add(scorePanel);

		content.setBackground(Color.black);
		titlePanel.setBackground(Color.black);
		gamePanel.setBackground(Color.black);
		scorePanel.setBackground(Color.black);

		titleLabel.setForeground(color);
		scoreLabel.setForeground(color);
	}

	public void actionPerformed(ActionEvent a){
		for(int r=0;r<board.length;r++)
			for(int c=0;c<board[0].length;c++)
				if(a.getSource() == board[r][c])
					played(r,c);
	}

	public void played(int r, int c){
		if(pressed[r][c])return;
		board[r][c].setText(ch());
		pressed[r][c] = true;

		if(checkWin(r,c)) declareWin();
	}

	public String ch(){
		String ch;
		if(lastX) ch="O";
		else ch="X";
		lastX = !lastX;
		return ch;
	}

	public boolean checkWin(int r, int c){
		if(board[r][0].getText().equals(board[r][1].getText()) && board[r][0].getText().equals(board[r][2].getText()) && Character.isLetter(board[r][0].getText().charAt(0)))
			return true;
		if(board[0][c].getText().equals(board[1][c].getText()) && board[0][c].getText().equals(board[2][c].getText()) && Character.isLetter(board[0][c].getText().charAt(0)))
			return true;
		if(board[0][0].getText().equals(board[1][1].getText()) && board[0][0].getText().equals(board[2][2].getText()) && Character.isLetter(board[0][0].getText().charAt(0)))
			return true;
		if(board[0][2].getText().equals(board[1][1].getText()) && board[0][2].getText().equals(board[2][0].getText()) && Character.isLetter(board[0][2].getText().charAt(0)))
			return true;

		draw();
		return false;
	}

	public void declareWin(){
		lastX = !lastX;
		String winner = ch();
		JOptionPane.showMessageDialog(null, winner+" Player Wins!!  Loser starts next game.");
		if(lastX) xscore++;
		else oscore++;

		restart();
	}

	public void restart(){
		for(int r=0;r<board.length;r++)
			for(int c=0;c<board[0].length;c++){
				board[r][c].setText("   ");
				pressed[r][c]=false;
			}
		scoreLabel.setText("Score   X:   "+xscore+"             O:   "+oscore);
	}

	public void draw(){
		for(int r=0;r<board.length;r++)
			for(int c=0;c<board[0].length;c++)
				if(board[r][c].getText().trim().equals(""))
					return;

		JOptionPane.showMessageDialog(null, "There's a draw! Both of you must suck!");
		restart();
	}
}