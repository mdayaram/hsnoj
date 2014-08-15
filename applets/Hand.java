import java.io.*;
import java.util.*;
import javax.swing.*;
import java.net.*;

public class Hand{
	private Card a,b,c,d,e,highCard1, highCard2, highCard3, highCard4, highCard5;
	private ArrayList s;
	private int shitPosition1, shitPosition2, shitPosition3;
	private String win;

public Hand(ArrayList q){
	shitPosition1 = 8;
	shitPosition2 = 8;
	shitPosition3 = 8;
	win = new String();
	s = new ArrayList(q);
	Collections.sort(s);
	if (s.size() == 5){
		a = (Card)s.get(0);
		b = (Card)s.get(1);
		c = (Card)s.get(2);
		d = (Card)s.get(3);
		e = (Card)s.get(4);

		highCard1 = new Card(e);
		highCard2 = new Card(d);
		highCard3 = new Card(c);
		highCard4 = new Card(b);
		highCard5 = new Card(a);
	}else{
		JOptionPane.showMessageDialog(null,"Someone didn't use the correct Array List...");
		System.exit(0);
	}

}


public boolean isRoyalFlush(){
	//if it is a straight flush and the hand carries the card A and K.
	if(isStraightFlush() && (a.getFaceInt() == 14 || b.getFaceInt() ==14 || c.getFaceInt() ==14 || d.getFaceInt() ==14 || e.getFaceInt() ==14) && (a.getFaceInt() == 13 || b.getFaceInt() ==13 || c.getFaceInt() ==13 || d.getFaceInt() ==13 || e.getFaceInt() ==13)){
		highCard1.setCard(e);
		highCard2.setCard(d);
		highCard3.setCard(c);
		highCard4.setCard(b);
		highCard5.setCard(a);
		shitPosition1 = 8;
		shitPosition2 = 8;
		shitPosition3 = 8;
		return true;
	}else{
		return false;
	}
}


public boolean isStraightFlush(){
	if(isFlush() && isStraight()){
		highCard1.setCard(e);
		highCard2.setCard(d);
		highCard3.setCard(c);
		highCard4.setCard(b);
		highCard5.setCard(a);
		shitPosition1 = 8;
		shitPosition2 = 8;
		shitPosition3 = 8;
		return true;
	}else{
		return false;
	}
}


public boolean isFourKind(){
	//if the first four cards or last four cards have the same Face value.
	if (a.getFaceInt() == b.getFaceInt() && a.getFaceInt() == c.getFaceInt() && a.getFaceInt() == d.getFaceInt()){
		highCard1.setCard(a);
		highCard2.setCard(b);
		highCard3.setCard(c);
		highCard4.setCard(d);
		highCard5.setCard(e);
		shitPosition1 = 4;
		shitPosition2 = 8;
		shitPosition3 = 8;
		return true;
 	}else if (b.getFaceInt() == c.getFaceInt() && b.getFaceInt() == d.getFaceInt() && b.getFaceInt() == e.getFaceInt()){
 		highCard1.setCard(a);
 		highCard2.setCard(b);
 		highCard3.setCard(c);
 		highCard4.setCard(d);
		highCard5.setCard(e);
		shitPosition1 = 0;
		shitPosition2 = 8;
		shitPosition3 = 8;
 		return true;
 	}else{
		return false;
	}
}


public boolean isFullHouse(){
	//if the first three cards are the same and the last two cards are the same or if the first two cards are the same and the last three cards are the same.
	if ((a.getFaceInt() == b.getFaceInt() && a.getFaceInt() == c.getFaceInt()) && (d.getFaceInt() == e.getFaceInt())){
		highCard1.setCard(a);
		highCard2.setCard(b);
		highCard3.setCard(c);
		highCard4.setCard(d);
		highCard5.setCard(e);
		shitPosition1 = 8;
		shitPosition2 = 8;
		shitPosition3 = 8;
		return true;
	}else if ((a.getFaceInt() == b.getFaceInt()) && (c.getFaceInt() == d.getFaceInt() && c.getFaceInt() == e.getFaceInt())){
		highCard1.setCard(e);
		highCard2.setCard(d);
		highCard3.setCard(c);
		highCard4.setCard(b);
		highCard5.setCard(a);
		shitPosition1 = 8;
		shitPosition2 = 8;
		shitPosition3 = 8;
		return true;
	}else{
		return false;
	}
}


public boolean isFlush(){
	//if the suit value is the same for all.
	if (a.getSuitInt() == b.getSuitInt() && a.getSuitInt()== c.getSuitInt() && a.getSuitInt() == d.getSuitInt() && a.getSuitInt() == e.getSuitInt()){
		highCard1.setCard(e);
		highCard2.setCard(d);
		highCard3.setCard(c);
		highCard4.setCard(b);
		highCard5.setCard(a);
		shitPosition1 = 8;
		shitPosition2 = 8;
		shitPosition3 = 8;
		return true;
	}else{
		return false;
	}
}


public boolean isStraight(){
	//if the hand includes an Ace and 2, true only if first to fifth goes 2 3 4 5 A.
	if(a.getFaceInt() == 2 && b.getFaceInt() == 3 && c.getFaceInt() == 4 && d.getFaceInt() == 5 && e.getFaceInt() == 14 ){
		highCard1.setCard(e);
		highCard2.setCard(d);
		highCard3.setCard(c);
		highCard4.setCard(b);
		highCard5.setCard(a);
		shitPosition1 = 8;
		shitPosition2 = 8;
		shitPosition3 = 8;
		return true;
	//if there is no Ace and 2 in the hand substract the first card minus the second, second minus third, third minus fourth, and fourth minus fifth.  All should equal to -1.
	}else if((a.getFaceInt() - b.getFaceInt()) == -1 && (b.getFaceInt()-c.getFaceInt()) == -1 && (c.getFaceInt()-d.getFaceInt()) == -1 && (d.getFaceInt()-e.getFaceInt()) == -1){
		highCard1.setCard(e);
		highCard2.setCard(d);
		highCard3.setCard(c);
		highCard4.setCard(b);
		highCard5.setCard(a);
		shitPosition1 = 8;
		shitPosition2 = 8;
		shitPosition3 = 8;
		return true;
	}else{
		return false;
	}
}


public boolean isThreeKind(){
	//if first three cards, middle three, or last three are equal face value.
	if (a.getFaceInt() == b.getFaceInt() && a.getFaceInt() == c.getFaceInt()){
		highCard1.setCard(a);
		highCard2.setCard(b);
		highCard3.setCard(c);
		highCard4.setCard(e);
		highCard5.setCard(d);
		shitPosition1 = 3;
		shitPosition2 = 4;
		shitPosition3 = 8;
		return true;
	}else if (b.getFaceInt() == c.getFaceInt() && b.getFaceInt() == d.getFaceInt()){
		highCard1.setCard(b);
		highCard2.setCard(c);
		highCard3.setCard(d);
		highCard4.setCard(e);
		highCard5.setCard(a);
		shitPosition1 = 0;
		shitPosition2 = 4;
		shitPosition3 = 8;
		return true;
	}else if (c.getFaceInt() == d.getFaceInt() && c.getFaceInt() == e.getFaceInt()){
		highCard1.setCard(e);
		highCard2.setCard(d);
		highCard3.setCard(c);
		highCard4.setCard(b);
		highCard5.setCard(a);
		shitPosition1 = 0;
		shitPosition2 = 1;
		shitPosition3 = 8;
		return true;
	}else{
		return false;
	}
}


public boolean isTwoPair(){
	//if first two are equal and last two are equals, or first two and second two, or second two and last two.
	if(a.getFaceInt() == b.getFaceInt() && d.getFaceInt() == e.getFaceInt()){
		highCard1.setCard(e);
		highCard2.setCard(d);
		highCard3.setCard(a);
		highCard4.setCard(b);
		highCard5.setCard(c);
		shitPosition1 = 2;
		shitPosition2 = 8;
		shitPosition3 = 8;
		return true;
	}else if(a.getFaceInt() == b.getFaceInt() && c.getFaceInt() == d.getFaceInt()){
		highCard1.setCard(c);
		highCard2.setCard(d);
		highCard3.setCard(a);
		highCard4.setCard(b);
		highCard5.setCard(e);
		shitPosition1 = 4;
		shitPosition2 = 8;
		shitPosition3 = 8;
		return true;
	}else if(b.getFaceInt() == c.getFaceInt() && d.getFaceInt() == e.getFaceInt()){
		highCard1.setCard(e);
		highCard2.setCard(d);
		highCard3.setCard(c);
		highCard4.setCard(b);
		highCard5.setCard(a);
		shitPosition1 = 0;
		shitPosition2 = 8;
		shitPosition3 = 8;
		return true;
	}else{
		return false;
	}
}


public boolean isPair(){
	//if first is equal to second, or second to third, or third to fourth, or fourth to fifth.
	if (a.getFaceInt() == b.getFaceInt()){
		highCard1.setCard(a);
		highCard2.setCard(b);
		highCard3.setCard(e);
		highCard4.setCard(d);
		highCard5.setCard(c);
		shitPosition1 = 2;
		shitPosition2 = 3;
		shitPosition3 = 4;
		return true;
	}else if (b.getFaceInt() == c.getFaceInt()){
		highCard1.setCard(b);
		highCard2.setCard(c);
		highCard3.setCard(e);
		highCard4.setCard(d);
		highCard5.setCard(a);
		shitPosition1 = 0;
		shitPosition2 = 3;
		shitPosition3 = 4;
		return true;
	}else if (c.getFaceInt() == d.getFaceInt()){
		highCard1.setCard(c);
		highCard2.setCard(d);
		highCard3.setCard(e);
		highCard4.setCard(b);
		highCard5.setCard(a);
		shitPosition1 = 0;
		shitPosition2 = 1;
		shitPosition3 = 4;
		return true;
	}else if (d.getFaceInt() == e.getFaceInt()){
		highCard1.setCard(e);
		highCard2.setCard(d);
		highCard3.setCard(c);
		highCard4.setCard(b);
		highCard5.setCard(a);
		shitPosition1 = 0;
		shitPosition2 = 1;
		shitPosition3 = 2;
		return true;
	}else{
		return false;
	}
}

public String getWinningMessage(){
	return win;
}

public int getShitPosition1(){
	return shitPosition1;
}


public int getShitPosition2(){
	return shitPosition2;
}

public int getShitPosition3(){
	return shitPosition3;
}

public int getHighCard1(){
	return highCard1.getFaceInt();
}
public int getHighCardS1(){
	return highCard1.getSuitInt();
}

public int getHighCard2(){
	return highCard2.getFaceInt();
}
public int getHighCardS2(){
	return highCard2.getSuitInt();
}

public int getHighCard3(){
	return highCard3.getFaceInt();
}
public int getHighCardS3(){
	return highCard3.getSuitInt();
}

public int getHighCard4(){
	return highCard4.getFaceInt();
}
public int getHighCardS4(){
	return highCard4.getSuitInt();
}

public int getHighCard5(){
	return highCard5.getFaceInt();
}
public int getHighCardS5(){
	return highCard5.getSuitInt();
}

public boolean winsOver(Hand h){
	if(isRoyalFlush()){
		if(h.isRoyalFlush()){
			return false;
		}else{
			win="Royal Flush.";
			return true;
		}
	}else if(isStraightFlush()){
		if(h.isRoyalFlush()){
			return false;
		}else if(h.isStraightFlush()){
			if(getHighCard1()>h.getHighCard1()){
				win="better Straight Flush.";
				return true;
			}else if(getHighCard1()<=h.getHighCard1()){
				return false;
			}
		}else{
			win="Straight Flush.";
			return true;
		}
	}else if(isFourKind()){
		if(h.isRoyalFlush() || h.isStraightFlush()){
			return false;
		}else if(h.isFourKind()){
			if(getHighCard1()>h.getHighCard1()){
				win="better Four of a Kind.";
				return true;
			}else if(getHighCard1()<h.getHighCard1()){
				return false;
			}
		}else{
			win="Four of a Kind.";
			return true;
		}
	}else if(isFullHouse()){
		if(h.isRoyalFlush() || h.isStraightFlush() || h.isFourKind()){
			return false;
		}else if(h.isFullHouse()){
			if(getHighCard1() > h.getHighCard1()){
				win="better Full House.";
				return true;
			}else if(getHighCard1() < h.getHighCard1()){
				return false;
			}
		}else{
			win="Full House.";
			return true;
		}
	}else if(isFlush()){
		if(h.isRoyalFlush() || h.isStraightFlush() || h.isFourKind() || h.isFullHouse()){
			return false;
		}else if(h.isFlush()){
			if(getHighCard1()>h.getHighCard1()){
				win="better Flush.";
				return true;
			}else if(getHighCard1()<h.getHighCard1()){
				return false;
			}else if(getHighCard1()==h.getHighCard1()){
				if(getHighCard2()>h.getHighCard2()){
					win="better Flush.";
					return true;
				}else if(getHighCard2()<h.getHighCard2()){
					return false;
				}else if(getHighCard2()==h.getHighCard2()){
					if(getHighCard3()>h.getHighCard3()){
						win="better Flush.";
						return true;
					}else if(getHighCard3()<h.getHighCard3()){
						return false;
					}else if(getHighCard3()==h.getHighCard3()){
						if(getHighCard4()>h.getHighCard4()){
							win="better Flush.";
							return true;
						}else if(getHighCard4()<h.getHighCard4()){
							return false;
						}else if(getHighCard4()==h.getHighCard4()){
							if(getHighCard5()>h.getHighCard5()){
								win="better Flush.";
								return true;
							}else if(getHighCard5()<=h.getHighCard5()){
								return false;
							}
						}
					}
				}
			}
		}else{
			win="Flush.";
			return true;
		}
	}else if(isStraight()){
		if(h.isRoyalFlush() || h.isStraightFlush() || h.isFourKind() || h.isFullHouse() || h.isFlush()){
			return false;
		}else if(h.isStraight()){
			if(getHighCard1()>h.getHighCard1()){
				win="better Straight.";
				return true;
			}else if(getHighCard1()<=h.getHighCard1()){
				return false;
			}
		}else{
			win="Straight.";
			return true;
		}
	}else if(isThreeKind()){
		if(h.isRoyalFlush() || h.isStraightFlush() || h.isFourKind() || h.isFullHouse() || h.isFlush() || h.isStraight()){
			return false;
		}else if(h.isThreeKind()){
			if(getHighCard1()>h.getHighCard1()){
				win="better Three of a Kind.";
				return true;
			}else if(getHighCard1()<h.getHighCard1()){
				return false;
			}
		}else{
			win="Three of a Kind.";
			return true;
		}
	}else if(isTwoPair()){
		if(h.isRoyalFlush() || h.isStraightFlush() || h.isFourKind() || h.isFullHouse() || h.isFlush() || h.isStraight() || h.isThreeKind()){
			return false;
		}else if(h.isTwoPair()){
			if(getHighCard1()>h.getHighCard1()){
				win="better Two Pair.";
				return true;
			}else if(getHighCard1()<h.getHighCard1()){
				return false;
			}else if(getHighCard1()==h.getHighCard1()){
				if(getHighCard3()>h.getHighCard3()){
					win="better Two Pair.";
					return true;
				}else if(getHighCard3()<h.getHighCard3()){
					return false;
				}else if(getHighCard3()==h.getHighCard3()){
					if(getHighCard5()>h.getHighCard5()){
						win="better Two Pair.";
						return true;
					}else if(getHighCard5()<=h.getHighCard5()){
						return false;
					}
				}
			}
		}else{
			win="Two Pair.";
			return true;
		}
	}else if(isPair()){
		if(h.isRoyalFlush() || h.isStraightFlush() || h.isFourKind() || h.isFullHouse() || h.isFlush() || h.isStraight() || h.isThreeKind() || h.isTwoPair()){
			return false;
		}else if(h.isPair()){
			if(getHighCard1()>h.getHighCard1()){
				win="better Pair.";
				return true;
			}else if(getHighCard1()<h.getHighCard1()){
				return false;
			}else if(getHighCard1()==h.getHighCard1()){
				if(getHighCard3()>h.getHighCard3()){
					win="better Pair.";
					return true;
				}else if(getHighCard3()<h.getHighCard3()){
					return false;
				}else if(getHighCard3()==h.getHighCard3()){
					if(getHighCard4()>h.getHighCard4()){
						win="better Pair.";
						return true;
					}else if(getHighCard4()<h.getHighCard4()){
						return false;
					}else if(getHighCard4()==h.getHighCard4()){
						if(getHighCard5()>h.getHighCard5()){
							win="better Pair.";
							return true;
						}else if(getHighCard5()<=h.getHighCard5()){
							return false;
						}
					}
				}
			}
		}else{
			win="Pair.";
			return true;
		}
	}else{
		if(h.isRoyalFlush() || h.isStraightFlush() || h.isFourKind() || h.isFullHouse() || h.isFlush() || h.isStraight() || h.isThreeKind() || h.isTwoPair() || h.isPair()){
			return false;
		}else{
			if(getHighCard1()>h.getHighCard1()){
				win="better High Card.";
				return true;
			}else if(getHighCard1()<h.getHighCard1()){
				return false;
			}else if(getHighCard1()==h.getHighCard1()){
				if(getHighCard2()>h.getHighCard2()){
					win="better High Card.";
					return true;
				}else if(getHighCard2()<h.getHighCard2()){
					return false;
				}else if(getHighCard2()==h.getHighCard2()){
					if(getHighCard3()>h.getHighCard3()){
						win="better High Card.";
						return true;
					}else if(getHighCard3()<h.getHighCard3()){
						return false;
					}else if(getHighCard3()==h.getHighCard3()){
						if(getHighCard4()>h.getHighCard4()){
							win="better High Card.";
							return true;
						}else if(getHighCard4()<h.getHighCard4()){
							return false;
						}else if(getHighCard4()==h.getHighCard4()){
							if(getHighCard5()>h.getHighCard5()){
								win="better High Card.";
								return true;
							}else if(getHighCard5()<=h.getHighCard5()){
								return false;
							}
						}
					}
				}
			}
		}
	}
	return false;
}

public static void main(String[]args){
	ArrayList c = new ArrayList();
	c.add(new Card(5,1));
	c.add(new Card(4,2));
	c.add(new Card(3,2));
	c.add(new Card(2,1));
	c.add(new Card(14,3));
	Hand h = new Hand(c);

	System.out.println(h.isStraight());

	ArrayList b = new ArrayList();
	b.add(new Card(4,1));
	b.add(new Card(3,2));
	b.add(new Card(2,2));
	b.add(new Card(5,1));
	b.add(new Card(6,3));
	Hand h2 = new Hand(b);
	System.out.println(h2.isStraight());
}


}