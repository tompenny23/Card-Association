import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;
public class cardClass {
	public String cardNumber;
	public String cardSuit;
	public String personName;
	public static int score;
	
	public cardClass(String name, String suit, String number){
		cardNumber = number;
		cardSuit = suit;
		personName = name;
	}
	
	public String checkAnswer(String answer) {
		String output;
		if(answer.equals(personName)) {
			output = "Correct";
			score++;
		}
		else {
			output = "Incorrect, answer is " + personName;
		}
		return output;
	}

	public static void main(String[] args) {
		
		///String[] namesList = {"Ace Hearts Name", "Two Hearts Name", "Three Hearts Name", "Four Hearts Name", "Five Hearts Name", "Six Hearts Name", "Seven Hearts Name", "Eight Hearts Name", "Nine Hearts Name", "Ten Hearts Name", "Jack Hearts Name", "Queen Hearts Name", "King Hearts Name", "Ace Diamonds Name", "Two Diamonds Name", "Three Diamonds Name", "Four Diamonds Name", "Five Diamonds Name", "Six Diamonds Name", "Seven Diamonds Name", "Eight Diamonds Name", "Nine Diamonds Name", "Ten Diamonds Name", "Jack Diamonds Name", "Queen Diamonds Name", "King Diamonds Name", "Ace Spades Name", "Two Spades Name", "Three Spades Name", "Four Spades Name", "Five Spades Name", "Six Spades Name", "Seven Spades Name", "Eight Spades Name", "Nine Spades Name", "Ten Spades Name", "Jack Spades Name", "Queen Spades Name", "King Spades Name", "Ace Clubs Name", "Two Clubs Name", "Three Clubs Name", "Four Clubs Name", "Five Clubs Name", "Six Clubs Name", "Seven Clubs Name", "Eight Clubs Name", "Nine Clubs Name", "Ten Clubs Name", "Jack Clubs Name", "Queen Clubs Name", "King Clubs Name"};
		String[] suitList = {"Hearts", "Hearts", "Hearts", "Hearts", "Hearts", "Hearts", "Hearts", "Hearts", "Hearts", "Hearts", "Hearts", "Hearts", "Hearts", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Diamonds", "Spades", "Spades", "Spades", "Spades", "Spades", "Spades", "Spades", "Spades", "Spades", "Spades", "Spades", "Spades", "Spades", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs", "Clubs"};
		String[] numberList = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		ArrayList<String> namesList = new ArrayList<String>();
		try {
			Scanner s;
			s = new Scanner(new File("cardList.txt"));
			while (s.hasNextLine()){
			    namesList.add(s.nextLine());
			}
			s.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<cardClass> cardInstanceList = new ArrayList<cardClass>();

		for(int i = 0 ; i < 52 ; i++) {
			cardInstanceList.add(new cardClass(namesList.get(i), suitList[i], numberList[i]));
		}
		Collections.shuffle(cardInstanceList);

		for (cardClass i:cardInstanceList) {
			ImageIcon icon = new ImageIcon("cardImages/" + i.cardNumber + i.cardSuit + ".png");
			String cardName = (String)JOptionPane.showInputDialog(null, "Card is " + i.cardNumber + " of " + i.cardSuit, "Card Association", JOptionPane.QUESTION_MESSAGE, icon, null, null);
			String output = i.checkAnswer(cardName);
			JOptionPane.showMessageDialog(null, output , "Results", JOptionPane.PLAIN_MESSAGE );
		}
		String output = "Score is " + score + "/52";
		JOptionPane.showMessageDialog(null, output , "Results", JOptionPane.PLAIN_MESSAGE );
		System.exit(0);
		
	}

}


