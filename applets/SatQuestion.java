/* Manoj Dayaram
   encapsulates a question including the String word and randomized String
   list of answer choices
   randomly chooses an satWord and selection of other answer choices from
other satWords
*/
import java.util.*;
import java.io.*;

	public class SatQuestion{
		private SatWord word;  //the satword word for this question
		private ArrayList choices;// list of numchoices answer choices String (definitions)
		private int numChoices;  //number of answer choices
		private String ans;
		private static Random random = new Random();//random generator

		public SatQuestion(ArrayList satwords, int howmanychoices){
		/* randomly chooses a word from the satwords list and a number of random
			other definitions from the list (no duplicates!) of howmanychoices.
			Hint: use ArrayList's contains method to check for  duplicate choices
			ArrayList choices contains all defintions (String)including the correct definition
			randomize(collections.shuffle()) the choices list
		*/

			choices = new ArrayList();
			word = (SatWord)satwords.get(random.nextInt(satwords.size()));
			numChoices = howmanychoices;
			choices.add(word.getDefinition());
			for(int i=1; i<numChoices; i++){
				boolean w00t = true;
				while(w00t){
					String def = ((SatWord)satwords.get(random.nextInt(satwords.size()))).getDefinition();
					if(!choices.contains(def)){
						choices.add(def);
						w00t = false;
					}
				}
			}
			Collections.shuffle(choices);
		}

		public String getWord(){
		//returns the SAT word for this question
			return word.getWord();
		}


		public String getChoices(){
		/* returns a String of choices (definitions) for this question
		   in the form:
		   "a) ...\n
			b) ...\n
			c) ...\n
			etc.   "
		*/
			Collections.shuffle(choices);
			String choice = new String();
			for(int pos=0; pos<choices.size(); pos++){
				choice += "   "+((char)('a'+pos))+") "+choices.get(pos)+"\n";
			}
			return choice;
		}


		public String getAnswer(){
		//returns the correct answer choice letter as a String (a, b, c ...)
			for(int i=0; i<numChoices; i++){
				String cdef = (String)choices.get(i);
				char letter = (char)('a'+i);
				if(cdef.equalsIgnoreCase(word.getDefinition()))
					return Character.toUpperCase(letter)+"";

			}
			return "Error";
		}

		public boolean equals (Object obj){
		//returns true if both SatQuestions have are the same word
			if(obj instanceof SatQuestion){
				SatQuestion sq = (SatQuestion)obj;
				return sq.getWord().equalsIgnoreCase(getWord());
			}else{
				return false;
			}
		}

		public void userAnswer(String a){
			ans = a;
		}
		public String userAnswer(){
			return ans;
		}

		public String toString(){
			return Character.toUpperCase(getWord().charAt(0))+getWord().substring(1)+" means...\n"+getChoices();
		}

	}