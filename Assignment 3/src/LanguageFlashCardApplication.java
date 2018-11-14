import java.io.IOException;
import java.util.Scanner;

/**
 * The Class LanguageFlashCardApplication.
 * 
 * @author Daniel Innes 101067175
 */
public class LanguageFlashCardApplication {

	/**
	 * The Client for language flash cards.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		/**get flashcards dictionary */
		System.out.println("What is the filename containing your flashcards? Exact letters!");
		LanguageFlashCards languageFlashCards = new LanguageFlashCards(scanner.nextLine());
		/**Main loop*/
		boolean c = true;
		while (c && languageFlashCards.nextCard()) {
			System.out.println("Next? (Y or N)");
			if (scanner.nextLine().toLowerCase().equals("n")) {
				c = false;
			}
		}
		/** Final print statement */
		System.out.println("You've got a score of " + languageFlashCards.getScore() + " so far");
		scanner.close();
	}
}
