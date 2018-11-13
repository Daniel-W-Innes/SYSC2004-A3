import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * The Class AbstractFlashCards.
 */
public abstract class AbstractFlashCards {
	
	/** The flash cards. */
	private HashMap<String, String> flashCards;
	
	/** The unanswered cards. */
	private ArrayList<String> unansweredCards;
	
	/** The score. */
	private int score;
	
	/** The scanner. */
	private Scanner scanner;
	
	/** The random. */
	private Random random;

	/**
	 * Instantiates a new abstract flash cards.
	 */
	AbstractFlashCards() {
		flashCards = new HashMap<String, String>();
		unansweredCards = new ArrayList<String>();
		random = new Random();
		scanner = new Scanner(System.in);
		score = 0;
	}

	/**
	 * Adds a new card.
	 *
	 * @param question the question
	 * @param answer the answer
	 */
	protected void addCard(String question, String answer) {
		flashCards.put(question, answer);
		unansweredCards.add(random.nextInt(unansweredCards.size()+1), question);
	}

	/**
	 * Reset unansweredCards.
	 */
	public void reset() {
		unansweredCards.clear();
		for (String question : flashCards.keySet()) {
			unansweredCards.add(random.nextInt(unansweredCards.size()+1), question);
		}
	}

	/**
	 * Checks if unansweredCards is empty.
	 *
	 * @return true, if empty
	 */
	public boolean hasNext() {
		return unansweredCards.isEmpty();

	}

	/**
	 * print question, check If answer is correct, and print score.
	 *
	 * @return true, if unansweredCards is empty
	 */
	public boolean nextCard() {
		if (!unansweredCards.isEmpty()){
			String question = unansweredCards.get(0);
			unansweredCards.remove(question);
			System.out.println(question);
			if (scanner.nextLine().toLowerCase().equals(flashCards.get(question).toLowerCase())) {
				score++;
				System.out.println("You're correct!");
			} else {
				unansweredCards.add(random.nextInt(unansweredCards.size()+1), question);
				System.out.println("Sorry, please try again");
			}
			System.out.println("Score = " + score);
			return true;
		}
		return false;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;

	}
}
