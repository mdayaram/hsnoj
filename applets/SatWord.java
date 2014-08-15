//Manoj Dayaram
//Stores all the important parts of a word; the word, definition, and part of speech.

public class SatWord{
  private String myword, myps, mydef;

  public SatWord(String word, String partspeach, String Definition){
  //initializes all private instance identifiers
	  myword = word;
	  myps = partspeach;
	  mydef = Definition;
  }

  public SatWord(SatWord st){
	  myword = st.getWord();
	  myps = st.getPartSpeach();
	  mydef = st.getDefinition();
  }

  public String getWord(){
  //returns myword
	  return myword;
  }

  public String getPartSpeach(){
  //returns myps
	  return myps;
  }

  public String getDefinition(){
  //returns mydef
	  return mydef;
  }

  public boolean equals (Object obj){
  //returns true if both SatWords have are the same word
	  if(obj instanceof SatWord){
		  SatWord sw = (SatWord)obj;
		  if(sw.getDefinition().equals(getDefinition()) &&
sw.getPartSpeach().equals(getPartSpeach()) &&
sw.getWord().equals(getWord())){
			  return true;
			  }else{
			  return false;
		  }
	  }else{
		  return false;
	  }

  }

}