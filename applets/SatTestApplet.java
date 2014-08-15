/*
Name:  Manoj Dayaram
Assignment:  SatWord
Period:  3

Description: Creates a practice SAT vocab test with the number of questions and choices you want.


I have not copied, cheated, received or given impermissible help on this
assignment. _________  (initial)
*/

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.*;
import java.applet.*;

public class SatTestApplet 	extends JApplet
							implements ActionListener{

	private JLabel titleLabel, questionLabel, answerLabel;
	private JTextArea questionArea,note;
	private JTextField answerField, numQ, numA;
	private JButton backButton, nextButton, startButton;
	private JPanel titlePanel, questionPanel, answerPanel, buttonPanel;
	private BufferedReader infile;
	private ArrayList satwords;//ArrayList od SatWord object created from file
	private ArrayList satquestions;//ArrayList of random SatQuestion objects
	private DecimalFormat three = new DecimalFormat("000");
	private String[] answer;
	private SatQuestion tempQ;
	private int numChoices, numQuestions, questions, grade;
	private double correct, total;
	private Container content = getContentPane();
	private GridLayout most, two1, three1;

	public void init(){
		answer = new String[1000];
		for(int i=0; i<1000; i++){
			answer[i]="";
		}

		questions = -1;
		titleLabel = new JLabel("\251NaW Brings SAT Vocab Test");
		questionLabel = new JLabel("Number of questions:");
		answerLabel = new JLabel("Number of answer choices (3, 4, or 5):  ");
		questionArea = new JTextArea("",60,40);
		questionArea.setLineWrap(true);
		questionArea.setWrapStyleWord(true);
		note = new JTextArea("Note:  You get points for correct answers, no points for blank answers, and deductions for wrong answers.",5,15);
		note.setLineWrap(true);
		note.setWrapStyleWord(true);
		numQ = new JTextField("",4);
		numA = new JTextField("",4);
		answerField = new JTextField("", 4);
		backButton = new JButton("<=Back");
		nextButton = new JButton("Next=>");
		startButton = new JButton("Start");

		questionArea.setVisible(false);
		answerField.setVisible(false);
		backButton.setVisible(false);
		nextButton.setVisible(false);

		answerField.setEditable(true);
		numQ.setEditable(true);
		numA.setEditable(true);
		questionArea.setEditable(false);

		titlePanel = new JPanel();
		questionPanel = new JPanel();
		answerPanel = new JPanel();
		buttonPanel = new JPanel();

		FlowLayout layout = new FlowLayout();
		GridLayout grid = new GridLayout(4,1,1,1);


		content.setLayout(grid);
		titlePanel.setLayout(layout);
		questionPanel.setLayout(layout);
		answerPanel.setLayout(layout);
		buttonPanel.setLayout(layout);

		titlePanel.add(titleLabel);
		questionPanel.add(questionLabel);
		questionPanel.add(numQ);
		questionPanel.add(questionArea);
		answerPanel.add(answerLabel);
		answerPanel.add(numA);
		answerPanel.add(answerField);
		buttonPanel.add(backButton);
		buttonPanel.add(startButton);
		buttonPanel.add(nextButton);
		buttonPanel.add(note);

		content.add(titlePanel);
		content.add(questionPanel);
		content.add(answerPanel);
		content.add(buttonPanel);
		Color c = new Color(145,240,15);
		content.setBackground(Color.black);
		titleLabel.setBackground(Color.black);
		questionLabel.setBackground(Color.black);
		numQ.setBackground(Color.black);
		questionArea.setBackground(Color.black);
		note.setBackground(Color.black);
		answerLabel.setBackground(Color.black);
		numA.setBackground(Color.black);
		backButton.setBackground(Color.black);
		startButton.setBackground(Color.black);
		nextButton.setBackground(Color.black);
		titlePanel.setBackground(Color.black);
		questionPanel.setBackground(Color.black);
		answerPanel.setBackground(Color.black);
		buttonPanel.setBackground(Color.black);

		note.setForeground(c);
		titleLabel.setForeground(c);
		questionLabel.setForeground(c);
		numQ.setForeground(c);
		numA.setForeground(c);
		questionArea.setForeground(c);
		answerLabel.setForeground(c);
		backButton.setForeground(c);
		startButton.setForeground(c);
		nextButton.setForeground(c);

		backButton.addActionListener(this);
		nextButton.addActionListener(this);
		startButton.addActionListener(this);

	}

	public void actionPerformed(ActionEvent yup){
		if(yup.getSource() == backButton){
			back();
		}else if(yup.getSource() == nextButton){
				next();
		}else if(yup.getSource() == startButton){
			if(numQ.getText().length()<=0 || numA.getText().length() <=0){
				JOptionPane.showMessageDialog(null,"Please input the number of and answer choices you'd like to have.");
			}else{
				if(numA.getText().trim().equals("3") || numA.getText().trim().equals("4") || numA.getText().trim().equals("5")){
					try{
						start(Integer.parseInt(numQ.getText().trim()), Integer.parseInt(numA.getText().trim()));
					}catch(NumberFormatException fudge){
						JOptionPane.showMessageDialog(null,"Are you a dumbass?  I hope you fail.");
					}catch(Exception e){}
				}else{
					JOptionPane.showMessageDialog(null,"3 to 5, jesus.  You're lucky this doesn't have any math in it.");
				}
			}
		}
	}

	public void start(int numquestions, int numchoices)throws Exception{
	/* instantiates ArrayLists satwords and satquestions
		invokes: readFile() and makeTest()
	*/
		questionLabel.setText("Question:  ");
		answerLabel.setText("Your Answer:  ");

		startButton.setVisible(false);
		numQ.setVisible(false);
		numA.setVisible(false);
		note.setVisible(false);
		questionArea.setVisible(true);
		answerField.setVisible(true);
		nextButton.setVisible(true);

		satwords = new ArrayList();
		satquestions = new ArrayList();
		numChoices = numchoices;
		numQuestions = numquestions;
		questionArea.setRows(100);
		total = 800;
		correct = 200;
		readFile();
		makeTest(numQuestions, numChoices);
		next();
	}

	public SatQuestion get(int i){
		return (SatQuestion)satquestions.get(i);
	}

	public void next(){
		trackAnswer();
		questions++;
		if(questions >= numQuestions){
			nextButton.setText("Finish");
			grade();
		}else{
			if(questions > 0){
				backButton.setVisible(true);
			}
			tempQ = get(questions);
			answerField.setText(answer[questions]+"");
			questionArea.setText((questions+1)+") "+tempQ.toString());
		}
	}

	public void back(){
		trackAnswer();
		questions--;
		if(questions <= 0){
			backButton.setVisible(false);
		}
		tempQ = get(questions);
		answerField.setText(answer[questions]+"");
		questionArea.setText((questions+1)+") "+tempQ.toString());
	}

	public void trackAnswer(){
		if(questions >= 0){
			answer[questions] = answerField.getText().trim();
		}
	}

	//private helper methods invoked from constructor
	private void readFile()throws IOException{
	/*reads the data file satwords.dat and stores as SatWord objects
		ArrayList satwords
    */
    	InputStream theGoods = this.getClass().getResourceAsStream("satwords.txt");
    	infile = new BufferedReader(new InputStreamReader(theGoods));
    	String line;
		while((line = infile.readLine()) != null){
			int pos1 = line.indexOf("	"), pos2 = line.indexOf(".")+1;
			String word = line.substring(0,pos1).trim(), ps = line.substring(pos1,pos2).trim(), d = line.substring(pos2).trim();
			SatWord sw = new SatWord(word, ps, d);
			satwords.add(sw);
		}
		infile.close();
	}

	private void makeTest(int numquestions, int numchoices){
	//creates an ArrayList (satquestions)of numquestions satQuestions (no duplicate words)
	// Hint: use ArrayList's contains method to check for  duplicate SatQuestions
		for(int i=0; i<numquestions; i++){
			SatQuestion sq = new SatQuestion(satwords, numchoices);
			while(satquestions.contains(sq)){
				sq = new SatQuestion(satwords, numchoices);
			}
			satquestions.add(sq);
		}
	}

	public void grade(){
	/* prints this sat vocabulary test (System.out.println()
		neatly formatted
	*/
		boolean dumb=false;
		DecimalFormat three = new DecimalFormat("000");
		for(int i=0; i<satquestions.size(); i++){
			if(answer[i].equalsIgnoreCase(get(i).getAnswer())){
				correct+= 600.0/numQuestions;
			}else if(answer[i].equalsIgnoreCase("")){

			}else{
				correct -= 200.0/numQuestions;
				dumb = !Character.isLetter(answer[i].charAt(0));
			}
		}
		grade = (int)correct;

		questionLabel.setVisible(false);
		answerLabel.setVisible(false);
		answerField.setVisible(false);
		backButton.setVisible(false);
		nextButton.setVisible(false);
		if(dumb){
			questionArea.setText("Your Score:  "+three.format(grade)+"\n\nNot what you expected?  Maybe someone \nshouldn't have been putting gibberish for answers.");
		}else{
			questionArea.setText("Your Score:  "+three.format(grade)+"\n\nAin't that something?");
		}

	}

}