import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public abstract class AbstractFlashCards {
	private HashMap<String, String> flashCards;
	private ArrayList<String> unansweredCards;
	private int score;
	private Scanner scanner;
	private Random random;

	AbstractFlashCards() {
		flashCards = new HashMap<String, String>();
		unansweredCards = new ArrayList<String>();
		random = new Random();
		scanner = new Scanner(System.in);
		score = 0;
	}

	protected void addCard(String question, String answer) {
		flashCards.put(question, answer);
		unansweredCards.add(random.nextInt(unansweredCards.size() - 1), question);
	}

	public void reset() {
		unansweredCards.clear();
		for (String question : flashCards.keySet()) {
			unansweredCards.add(random.nextInt(unansweredCards.size() - 1), question);
		}
	}

	public boolean hasNext() {
		return unansweredCards.isEmpty();

	}

	public boolean nextCard() {
		if (!unansweredCards.isEmpty()){
			String question = unansweredCards.get(0);
			unansweredCards.remove(question);
			System.out.println(question);
			if (scanner.nextLine() == flashCards.get(question)) {
				score++;
			} else {
				unansweredCards.add(random.nextInt(unansweredCards.size() - 1), question);
			}
			return true;
		}
		return false;
	}

	public int getScore() {
		return score;

	}
}
