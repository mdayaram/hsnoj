import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.applet.Applet.*;
import java.applet.*;
import java.net.*;

public class PokerApp extends JApplet
						implements ActionListener{

private JButton dealercard1Button, dealercard2Button, dealercard3Button, dealercard4Button, dealercard5Button;
private JLabel playerLabel, dealerLabel, titleLabel;
private JButton playercard1Button, playercard2Button, playercard3Button, playercard4Button, playercard5Button;
private JButton discard1Button, discard2Button, discard3Button, discard4Button, discard5Button;
private JButton dealButton, drawButton, endTurnButton, winButton;
private JTextField winnerField;
private JPanel dealerPanel, playerPanel, cardPanel, discardPanel, buttonPanel, titlePanel, winnerPanel;
private ArrayList deck=new ArrayList(Card.deck()), player=new ArrayList(), dealer=new ArrayList();
private boolean draw, playerTurn, discard1, discard2, discard3, discard4, discard5, deal;
private int numDiscards;
private ImageIcon cover,blank,a21,a31,a41,a51,a61,a71,a81,a91,a101,a111,a121,a131,a141,a22,a32,a42,a52,a62,a72,a82,a92,a102,a112,a122,a132,a142,a23,a33,a43,a53,a63,a73,a83,a93,a103,a113,a123,a133,a143,a24,a34,a44,a54,a64,a74,a84,a94,a104,a114,a124,a134,a144;
private String deckcover;
private Container content = getContentPane();

public void init() {
    createGUI();

}

public void createGUI(){
        draw = false;
        playerTurn = true;
        numDiscards = 0;
        deal = false;

        cover = createAppletImageIcon("poker.gif", "");
        blank = createAppletImageIcon("pblank.GIF", "");
        a21 = createAppletImageIcon("2c.GIF", "");
        a31 = createAppletImageIcon("3c.GIF", "");
        a41 = createAppletImageIcon("4c.GIF", "");
        a51 = createAppletImageIcon("5c.GIF", "");
        a61 = createAppletImageIcon("6c.GIF", "");
        a71 = createAppletImageIcon("7c.GIF", "");
        a81 = createAppletImageIcon("8c.GIF", "");
        a91 = createAppletImageIcon("9c.GIF", "");
        a101 = createAppletImageIcon("10c.GIF", "");
        a111 = createAppletImageIcon("Jc.GIF", "");
        a121 = createAppletImageIcon("Qc.GIF", "");
        a131 = createAppletImageIcon("Kc.GIF", "");
        a141 = createAppletImageIcon("Ac.GIF", "");
        a22 = createAppletImageIcon("2d.GIF", "");
        a32 = createAppletImageIcon("3d.GIF", "");
        a42 = createAppletImageIcon("4d.GIF", "");
        a52 = createAppletImageIcon("5d.GIF", "");
        a62 = createAppletImageIcon("6d.GIF", "");
        a72 = createAppletImageIcon("7d.GIF", "");
        a82 = createAppletImageIcon("8d.GIF", "");
        a92 = createAppletImageIcon("9d.GIF", "");
        a102 = createAppletImageIcon("10d.GIF", "");
        a112 = createAppletImageIcon("Jd.GIF", "");
        a122 = createAppletImageIcon("Qd.GIF", "");
        a132 = createAppletImageIcon("Kd.GIF", "");
        a142 = createAppletImageIcon("Ad.GIF", "");
        a23 = createAppletImageIcon("2h.GIF", "");
        a33 = createAppletImageIcon("3h.GIF", "");
        a43 = createAppletImageIcon("4h.GIF", "");
        a53 = createAppletImageIcon("5h.GIF", "");
        a63 = createAppletImageIcon("6h.GIF", "");
        a73 = createAppletImageIcon("7h.GIF", "");
        a83 = createAppletImageIcon("8h.GIF", "");
        a93 = createAppletImageIcon("9h.GIF", "");
        a103 = createAppletImageIcon("10h.GIF", "");
        a113 = createAppletImageIcon("Jh.GIF", "");
        a123 = createAppletImageIcon("Qh.GIF", "");
        a133 = createAppletImageIcon("Kh.GIF", "");
        a143 = createAppletImageIcon("Ah.GIF", "");
        a24 = createAppletImageIcon("2s.GIF", "");
        a34 = createAppletImageIcon("3s.GIF", "");
        a44 = createAppletImageIcon("4s.GIF", "");
        a54 = createAppletImageIcon("5s.GIF", "");
        a64 = createAppletImageIcon("6s.GIF", "");
        a74 = createAppletImageIcon("7s.GIF", "");
        a84 = createAppletImageIcon("8s.GIF", "");
        a94 = createAppletImageIcon("9s.GIF", "");
        a104 = createAppletImageIcon("10s.GIF", "");
        a114 = createAppletImageIcon("Js.GIF", "");
        a124 = createAppletImageIcon("Qs.GIF", "");
        a134 = createAppletImageIcon("Ks.GIF", "");
        a144 = createAppletImageIcon("As.GIF", "");

        titleLabel = new JLabel("\251NaW Brings You 5 Card Draw");

        dealerLabel = new JLabel("Dealer:");
        dealercard1Button = new JButton(blank);
        dealercard2Button = new JButton(blank);
        dealercard3Button = new JButton(blank);
        dealercard4Button = new JButton(blank);
        dealercard5Button = new JButton(blank);

        playerLabel = new JLabel("Your Cards:");
        playercard1Button = new JButton(blank);
        playercard2Button = new JButton(blank);
        playercard3Button = new JButton(blank);
        playercard4Button = new JButton(blank);
        playercard5Button = new JButton(blank);

        discard1Button = new JButton("Discard");
        discard2Button = new JButton("Discard");
        discard3Button = new JButton("Discard");
        discard4Button = new JButton("Discard");
        discard5Button = new JButton("Discard");

        dealButton = new JButton(" Deal ");
        drawButton = new JButton(" Draw ");
        endTurnButton = new JButton(" End Turn ");
        winButton = new JButton(" Show ");

        winnerField = new JTextField("", 50);
        winnerField.setEditable(false);

        titlePanel = new JPanel();
        dealerPanel = new JPanel();
        playerPanel = new JPanel();
        cardPanel = new JPanel();
        discardPanel = new JPanel();
        buttonPanel = new JPanel();
        winnerPanel = new JPanel();

		content.removeAll();
		Color c = new Color(145,240,15);
        content.setBackground(Color.black);
        titlePanel.setBackground(Color.black);
        dealerPanel.setBackground(Color.black);
        playerPanel.setBackground(Color.black);
        cardPanel.setBackground(Color.black);
        discardPanel.setBackground(Color.black);
        buttonPanel.setBackground(Color.black);
        winnerPanel.setBackground(Color.black);

        dealerLabel.setBackground(Color.black);
        dealerLabel.setForeground(c);

        titleLabel.setBackground(Color.black);
        titleLabel.setForeground(c);

        dealercard1Button.setBackground(Color.black);
        dealercard2Button.setBackground(Color.black);
        dealercard3Button.setBackground(Color.black);
        dealercard4Button.setBackground(Color.black);
        dealercard5Button.setBackground(Color.black);

        playerLabel.setBackground(Color.black);
        playerLabel.setForeground(c);

        playercard1Button.setBackground(Color.black);
        playercard2Button.setBackground(Color.black);
        playercard3Button.setBackground(Color.black);
        playercard4Button.setBackground(Color.black);
        playercard5Button.setBackground(Color.black);

        dealButton.setBackground(Color.black);
        drawButton.setBackground(Color.black);
        endTurnButton.setBackground(Color.black);
        winButton.setBackground(Color.black);
        dealButton.setForeground(c);
        drawButton.setForeground(c);
        endTurnButton.setForeground(c);
        winButton.setForeground(c);

        discard1Button.setBackground(Color.black);
        discard2Button.setBackground(Color.black);
        discard3Button.setBackground(Color.black);
        discard4Button.setBackground(Color.black);
        discard5Button.setBackground(Color.black);

        discard1Button.setForeground(c);
        discard2Button.setForeground(c);
        discard3Button.setForeground(c);
        discard4Button.setForeground(c);
        discard5Button.setForeground(c);

        winnerField.setBackground(Color.black);
        winnerField.setForeground(c);

        FlowLayout flowlayout = new FlowLayout();

        titlePanel.setLayout(flowlayout);
        dealerPanel.setLayout(flowlayout);
        playerPanel.setLayout(flowlayout);
        cardPanel.setLayout(flowlayout);
        discardPanel.setLayout(flowlayout);
        buttonPanel.setLayout(flowlayout);
        winnerPanel.setLayout(flowlayout);
        content.setLayout(flowlayout);

        titlePanel.add(titleLabel);
        dealerPanel.add(dealerLabel);
        dealerPanel.add(dealercard1Button);
        dealerPanel.add(dealercard2Button);
        dealerPanel.add(dealercard3Button);
        dealerPanel.add(dealercard4Button);
        dealerPanel.add(dealercard5Button);
        playerPanel.add(playerLabel);

        cardPanel.add(playercard1Button);
        cardPanel.add(playercard2Button);
        cardPanel.add(playercard3Button);
        cardPanel.add(playercard4Button);
        cardPanel.add(playercard5Button);

        discardPanel.add(discard1Button);
        discardPanel.add(discard2Button);
        discardPanel.add(discard3Button);
        discardPanel.add(discard4Button);
        discardPanel.add(discard5Button);

        buttonPanel.add(dealButton);
        buttonPanel.add(drawButton);
        buttonPanel.add(endTurnButton);
        buttonPanel.add(winButton);

        winnerPanel.add(winnerField);

        content.add(titlePanel);
        content.add(dealerPanel);
        content.add(playerPanel);
        content.add(cardPanel);
        content.add(discardPanel);
        content.add(buttonPanel);
        content.add(winnerPanel);

        discard1Button.addActionListener(this);
        discard2Button.addActionListener(this);
        discard3Button.addActionListener(this);
        discard4Button.addActionListener(this);
        discard5Button.addActionListener(this);
        dealButton.addActionListener(this);
        drawButton.addActionListener(this);
        endTurnButton.addActionListener(this);
        winButton.addActionListener(this);

}

//Assigns action for each button.
public void actionPerformed(ActionEvent ae){
	if (ae.getSource() == discard1Button){
		discard1();
	}else if (ae.getSource() == discard2Button){
		discard2();
	}else if (ae.getSource() == discard3Button){
		discard3();
	}else if (ae.getSource() == discard4Button){
		discard4();
	}else if (ae.getSource() == discard5Button){
		discard5();
	}else if (ae.getSource() == dealButton){
		deal();
	}else if (ae.getSource() == drawButton){
		draw();
	}else if(ae.getSource() == endTurnButton){
		endPlayerTurn();
	}else if (ae.getSource() == winButton){
		winner();
	}
}

//Discards player's first card.
public void discard1() {
	if(draw && playerTurn && discard1){
		if(numDiscards < 3){
			discard1=false;
			numDiscards++;
			playercard1Button.setIcon(null);
			playercard1Button.setIcon(blank);
			deck.add(player.set(0, new String("[ ]")));  //remove the card from the player's array list, add it to the bottom of the deck, and replace the spot on the player's array list with a string object of "[ ]"
		}else{
			JOptionPane.showMessageDialog(null,"You can't discard more than three cards...dumbass.");
		}
	}else{
		JOptionPane.showMessageDialog(null,"You fucking cunt! You can't trade cards again!");
	}
}

//Discards player's second card
public void discard2() {
	if(draw && playerTurn && discard2){
		if(numDiscards < 3){
			discard2=false;
			numDiscards++;
			playercard2Button.setIcon(null);
			playercard2Button.setIcon(blank);
			deck.add(player.set(1, new String("[ ]")));
		}else{
			JOptionPane.showMessageDialog(null,"You can't discard more than three cards...dumbass.");
		}
	}else{
		JOptionPane.showMessageDialog(null,"You fucking cunt! You can't trade cards again!");
	}
}

//Discards player's third card
public void discard3() {
	if(draw && playerTurn && discard3){
		if(numDiscards < 3){
			discard3=false;
			numDiscards++;
			playercard3Button.setIcon(null);
			playercard3Button.setIcon(blank);
			deck.add(player.set(2, new String("[ ]")));
		}else{
			JOptionPane.showMessageDialog(null,"You can't discard more than three cards...dumbass.");
		}
	}else{
		JOptionPane.showMessageDialog(null,"You fucking cunt! You can't trade cards again!");
	}
}

//Discards player's fourth card
public void discard4() {
	if(draw && playerTurn && discard4){
		if(numDiscards < 3){
			discard4=false;
			numDiscards++;
			playercard4Button.setIcon(null);
			playercard4Button.setIcon(blank);
			deck.add(player.set(3, new String("[ ]")));
		}else{
			JOptionPane.showMessageDialog(null,"You can't discard more than three cards...dumbass.");
		}
	}else{
		JOptionPane.showMessageDialog(null,"You fucking cunt! You can't trade cards again!");
	}
}

//Discards player's fifth card
public void discard5() {
	if(draw && playerTurn && discard5){
		if(numDiscards < 3){
			discard5=false;
			numDiscards++;
			playercard5Button.setIcon(null);
			playercard5Button.setIcon(blank);
			deck.add(player.set(4, new String("[ ]")));
		}else{
			JOptionPane.showMessageDialog(null,"You can't discard more than three cards...dumbass.");
		}
	}else{
		JOptionPane.showMessageDialog(null,"You fucking cunt! You can't trade cards again!");
	}
}

public void deal() {
	deal=true;
//make it possible to draw cards.
	discard1 = true;
	discard2 = true;
	discard3 = true;
	discard4 = true;
	discard5 = true;
	numDiscards = 0;
	draw = true;
	playerTurn = true;
//Put dealer and player's old cards back in the deck.
    int d = dealer.size();
	int p = player.size();
	for(int i=0; i<d; i++){
	    deck.add(dealer.remove(0));
	}
	for(int i=0; i<p; i++){
		deck.add(player.remove(0));
	}

    Collections.shuffle(deck);
//give five cards to the player and the dealer.
    for(int i=0; i<5; i++){
        player.add(deck.remove(0));
        dealer.add(deck.remove(0));
    }

    winnerField.setText("");

//Empty dealer's buttons
	dealercard1Button.setIcon(null);
	dealercard2Button.setIcon(null);
	dealercard3Button.setIcon(null);
	dealercard4Button.setIcon(null);
	dealercard5Button.setIcon(null);

//Show cover.gif on dealer's buttons
	dealercard1Button.setIcon(cover);
	dealercard2Button.setIcon(cover);
	dealercard3Button.setIcon(cover);
	dealercard4Button.setIcon(cover);
	dealercard5Button.setIcon(cover);

//Show player's cards
	playerRefresh();
}

//Replaces cards discarded
public void draw() {
	if(draw && playerTurn){
		if(!discard1 || !discard2 || !discard3 || !discard4 || !discard5){
			while(player.contains("[ ]")){                         //if the player's array list contains any string objects of "[ ]"
				player.set(player.indexOf("[ ]"),deck.remove(0));  // replace them with the top card of the deck
			}
			playerRefresh();  //show player's new cards.
			draw = false;     //make it impossible to discard or draw again.
		}else{
			JOptionPane.showMessageDialog(null,"You didn't discard any cards dumbass.");
		}
	}else{
		JOptionPane.showMessageDialog(null,"You fucking cunt! You can't draw cards again!");
	}
}

//Ends player's turn, he can't discard/draw/do anything else. Begins dealer's turn.
public void endPlayerTurn(){
	if(playerTurn && deal){
		if(!discard1 || !discard2 || !discard3 || !discard4 || !discard5){
			if(!draw){
				playerTurn = false;
				dealerTrade();
			}else{
				JOptionPane.showMessageDialog(null,"You need to draw cards.");
			}
		}else if(discard1 && discard2 && discard3 && discard4 && discard5){
			playerTurn = false;
			dealerTrade();
		}
	}else{
		JOptionPane.showMessageDialog(null,"You already ended your turn.");
	}
}

//Shows dealer's cards and declares winner
public void winner() {
	if(!playerTurn){
		Card a = (Card)dealer.get(0);
		Card b = (Card)dealer.get(1);
		Card c = (Card)dealer.get(2);
		Card d = (Card)dealer.get(3);
    	Card e = (Card)dealer.get(4);

		dealercard1Button.setIcon(null);
		dealercard2Button.setIcon(null);
		dealercard3Button.setIcon(null);
		dealercard4Button.setIcon(null);
		dealercard5Button.setIcon(null);

		dealercard1Button.setIcon(findCard(a));
		dealercard2Button.setIcon(findCard(b));
		dealercard3Button.setIcon(findCard(c));
		dealercard4Button.setIcon(findCard(d));
    	dealercard5Button.setIcon(findCard(e));

		Hand playerHand = new Hand(player);
		Hand dealerHand = new Hand(dealer);

		if(playerHand.winsOver(dealerHand)){
			winnerField.setText("You have won with a "+playerHand.getWinningMessage());
		}else if(dealerHand.winsOver(playerHand)){
			winnerField.setText("Dealer has won with a "+dealerHand.getWinningMessage());
		}else{
			winnerField.setText("Game is a tie.");
		}

	}else{
		JOptionPane.showMessageDialog(null,"You fucking weasel, end your turn first.\nGod should smite you for trying to cheat.");
	}

}

//Shows the player's current cards.
public void playerRefresh(){
	Card a = (Card)player.get(0);
	Card b = (Card)player.get(1);
	Card c = (Card)player.get(2);
	Card d = (Card)player.get(3);
    Card e = (Card)player.get(4);

	playercard1Button.setIcon(null);
	playercard2Button.setIcon(null);
	playercard3Button.setIcon(null);
	playercard4Button.setIcon(null);
	playercard5Button.setIcon(null);

	playercard1Button.setIcon(findCard(a));
	playercard2Button.setIcon(findCard(b));
	playercard3Button.setIcon(findCard(c));
	playercard4Button.setIcon(findCard(d));
    playercard5Button.setIcon(findCard(e));
}

//dealer trades it's cards
public void dealerTrade() {
	Collections.sort(dealer);
	Hand dealercards = new Hand(dealer);
	if (dealercards.isRoyalFlush()) {
		winnerField.setText("Dealer traded 0 card(s).");
	}else if (dealercards.isStraightFlush()) {
		winnerField.setText("Dealer traded 0 card(s).");
	}else if (dealercards.isStraight()) {
		winnerField.setText("Dealer traded 0 card(s).");
	}else if (dealercards.isFlush()) {
		winnerField.setText("Dealer traded 0 card(s).");
	}else if (dealercards.isFourKind()) {
		int numTraded=0;
		if(dealercards.getShitPosition1() < 5 && dealercards.getHighCard5() < 10){
			deck.add(dealer.remove(dealercards.getShitPosition1()));
			dealer.add(deck.remove(0));
			numTraded++;
		}
		winnerField.setText("Dealer traded "+numTraded+" card(s).");
	}else if (dealercards.isFullHouse()) {
		winnerField.setText("Dealer traded 0 card(s).");
	}else if (dealercards.isThreeKind()) {
		int numTraded=0;
		if(dealercards.getShitPosition1() < 5){
			deck.add(dealer.remove(dealercards.getShitPosition1()));
			dealer.add(deck.remove(0));
			numTraded++;
		}
		if(dealercards.getShitPosition2() < 5){
			deck.add(dealer.remove(dealercards.getShitPosition2()));
			dealer.add(deck.remove(0));
			numTraded++;
		}
		winnerField.setText("Dealer traded "+numTraded+" card(s).");
	}else if (dealercards.isTwoPair()) {
		int numTraded=0;
		if(dealercards.getShitPosition1() < 5){
			deck.add(dealer.remove(dealercards.getShitPosition1()));
			dealer.add(deck.remove(0));
			numTraded++;
		}
		winnerField.setText("Dealer traded "+numTraded+" card(s).");
	}else if (dealercards.isPair()){
		int numTraded=0;
		if(dealercards.getShitPosition1() < 5){
			deck.add(dealer.remove(dealercards.getShitPosition1()));
			dealer.add(deck.remove(0));
			numTraded++;
		}
		if(dealercards.getShitPosition2() < 5){
			deck.add(dealer.remove(dealercards.getShitPosition2()));
			dealer.add(deck.remove(0));
			numTraded++;
		}
		if(dealercards.getShitPosition3() < 5){
			deck.add(dealer.remove(dealercards.getShitPosition3()));
			dealer.add(deck.remove(0));
			numTraded++;
		}
		winnerField.setText("Dealer traded "+numTraded+" card(s).");
	}else{
		deck.add(dealer.remove(0));
		deck.add(dealer.remove(1));
		deck.add(dealer.remove(2));
		dealer.add(deck.remove(0));
		dealer.add(deck.remove(0));
		dealer.add(deck.remove(0));
		winnerField.setText("Dealer traded 3 card(s).");
	}
}

//gets the corresponding image icon given a card.
public ImageIcon findCard(Card card) {

	if (card.getRank() == 21) {
		return a21;
	}else if (card.getRank() == 31) {
		return a31;
	}else if (card.getRank() == 41) {
		return a41;
	}else if (card.getRank() == 51) {
		return a51;
	}else if (card.getRank() == 61) {
		return a61;
	}else if (card.getRank() == 71) {
		return a71;
	}else if (card.getRank() == 81) {
		return a81;
	}else if (card.getRank() == 91) {
		return a91;
	}else if (card.getRank() == 101) {
		return a101;
	}else if (card.getRank() == 111) {
		return a111;
	}else if (card.getRank() == 121) {
		return a121;
	}else if (card.getRank() == 131) {
		return a131;
	}else if (card.getRank() == 141) {
		return a141;
	}else if (card.getRank() == 22) {
		return a22;
	}else if (card.getRank() == 32) {
		return a32;
	}else if (card.getRank() == 42) {
		return a42;
	}else if (card.getRank() == 52) {
		return a52;
	}else if (card.getRank() == 62) {
		return a62;
	}else if (card.getRank() == 72) {
		return a72;
	}else if (card.getRank() == 82) {
		return a82;
	}else if (card.getRank() == 92) {
		return a92;
	}else if (card.getRank() == 102) {
		return a102;
	}else if (card.getRank() == 112) {
		return a112;
	}else if (card.getRank() == 122) {
		return a122;
	}else if (card.getRank() == 132) {
		return a132;
	}else if (card.getRank() == 142) {
		return a142;
	}else if (card.getRank() == 23) {
		return a23;
	}else if (card.getRank() == 33) {
		return a33;
	}else if (card.getRank() == 43) {
		return a43;
	}else if (card.getRank() == 53) {
		return a53;
	}else if (card.getRank() == 63) {
		return a63;
	}else if (card.getRank() == 73) {
		return a73;
	}else if (card.getRank() == 83) {
		return a83;
	}else if (card.getRank() == 93) {
		return a93;
	}else if (card.getRank() == 103) {
		return a103;
	}else if (card.getRank() == 113) {
		return a113;
	}else if (card.getRank() == 123) {
		return a123;
	}else if (card.getRank() == 133) {
		return a133;
	}else if (card.getRank() == 143) {
		return a143;
	}else if (card.getRank() == 24) {
		return a24;
	}else if (card.getRank() == 34) {
		return a34;
	}else if (card.getRank() == 44) {
		return a44;
	}else if (card.getRank() == 54) {
		return a54;
	}else if (card.getRank() == 64) {
		return a64;
	}else if (card.getRank() == 74) {
		return a74;
	}else if (card.getRank() == 84) {
		return a84;
	}else if (card.getRank() == 94) {
		return a94;
	}else if (card.getRank() == 104) {
		return a104;
	}else if (card.getRank() == 114) {
		return a114;
	}else if (card.getRank() == 124) {
		return a124;
	}else if (card.getRank() == 134) {
		return a134;
	}else if (card.getRank() == 144) {
		return a144;
	}else if(card.getFaceInt() == 15){
		return blank;
	}else{
		return cover;
	}
}

protected static ImageIcon createAppletImageIcon(String path,
                                              String description) {
        int MAX_IMAGE_SIZE = 50000; //Change this to the size of
                                    //your biggest image, in bytes.


//		try{
/*		URL imageURL = PokerApp.class.getResource(path);
		ImageIcon icon = new ImageIcon(imageURL);
		if (imageURL != null) {
		    return icon;
		}else{
			return null;
		}
*///		}catch(MalformedURLException e){return null;}
      int count = 0;
        BufferedInputStream imgStream = new BufferedInputStream(
           PokerApp.class.getResourceAsStream(path));
        if (imgStream != null) {
            byte buf[] = new byte[MAX_IMAGE_SIZE];
            try {
                count = imgStream.read(buf);
            } catch (IOException ieo) {
                System.err.println("Couldn't read stream from file: " + path);
            }

            try {
                imgStream.close();
            } catch (IOException ieo) {
                 System.err.println("Can't close file " + path);
            }

            if (count <= 0) {
                System.err.println("Empty file: " + path);
                return null;
            }
            return new ImageIcon(Toolkit.getDefaultToolkit().createImage(buf),
                                 description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}





