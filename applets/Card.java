import java.util.*;
import java.net.*;

public class Card implements Comparable{

  private  int myface;  //2-14 (ace=14, king =13, queen=12, jack=11)
  private  int mysuit;  //1-4 (1 = club, 2=diamond, 3=heart, 4=spade)
  private  static Random random = new Random();//random generator

  //2 constructors
  public Card (){
  //generate a a random Card myface(2-14), mysuit(1-4)
    myface = random.nextInt(13)+2;
    mysuit = random.nextInt(4)+1;
  }

  public Card (Card a){
	  this(a.getFaceInt(),a.getSuitInt());
  }

  public Card(int face, int suit){
  //create Card given face and suit
  //abort program if bad values for face or suit-System.exit(0)
   myface = face;
   mysuit = suit;

   if(myface>15 || myface<1 || mysuit>4 || mysuit<1){
       System.exit(0);
       System.out.println("Bad values");
   }

  }

  public void setCard(Card a){
	  myface=a.getFaceInt();
	  mysuit=a.getSuitInt();
  }

  public int getRank(){
  //rank card ace spades..2 clubs
  //multiply face value by ten and add suit
  //ie king of hearts = 13 x 10 + 3 = 133
  int rank;
  rank = myface*10 + mysuit;
  return rank;

  }

  public String getFace(){
  //return String value of myface - 2..10, jack, queen, king, ace
  if(myface==11){
	  return "Jack";
  }else if(myface==12){
	  return "Queen";
  }else if(myface==13){
	  return "King";
  }else if(myface==14){
	  return "Ace";
  }else{
	  return myface+"";
  }

  }

/*
switch (mysuit) {
case 1: //Card.SUIT_CLUBS:
return "Clubs";
break;
case 2:
return "Diamonds";
break;
case 3:
return "Hearts";
break;
case 4:
return "Spades";
break;
default:
return "error";
}
}*/

  public int getFaceInt(){
      return myface;
  }

  public int getSuitInt(){
      return mysuit;
  }

  public String getSuit(){
  //return String value of mysuit clubs. diamonds, hearts or spades
  if(mysuit ==1 ){
	  return "Clubs";
  }else if(mysuit==2){
	  return "Diamonds";
  }else if(mysuit==3){
	  return "Hearts";
  }else if(mysuit==4){
	  return "Spades";
  }else{
	  return "Error";
  }

   }

  public boolean equals(Object obj){
  //true if the card object and parameter are the same and false otherwise
  if(obj==null) return false;
  Card c = (Card)obj;
  return c.getFace().equals(getFace()) && c.getSuit().equals(getSuit());

  }

  public static ArrayList deck(){
      ArrayList deck = new ArrayList();
      for(int s=1; s<5; s++){
         for(int f=2; f<15; f++){
            deck.add(new Card(f, s));
         }
       }
      return deck;
  }

  public String toString(){
  //return String value of Card ie "king of hearts" or "9 of spades"
  return "["+getFace()+" of "+getSuit()+"]";

  }

  public int compareTo(Object o) {
      Card c = (Card)o;
      return this.getRank()-c.getRank();
  }

 }