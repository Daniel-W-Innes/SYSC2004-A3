import java.io.IOException;
import java.util.Scanner;

public class LanguageFlashCardApplication {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the filename containing your flashcards? Exact letters!");
		LanguageFlashCards languageFlashCards = new LanguageFlashCards(scanner.nextLine());
		//LanguageFlashCards languageFlashCards = new LanguageFlashCards("EFdictionary.csv");
		boolean c = true;
		while (c&&languageFlashCards.nextCard()) {
			System.out.println("Next? (Y or N)");
			if (scanner.nextLine().toLowerCase().equals("n")) {
				c = false;
			}
		}
	}
}
