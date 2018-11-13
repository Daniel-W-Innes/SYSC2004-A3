import java.util.Scanner;

/**
 * The Class MultiplicationFlashCardApplication.
 */
public class MultiplicationFlashCardApplication {

	/**
	 * The Client for multiplication flash cards.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		/** get multiplication(s) */
		System.out.println("Which times tables would you like to test? (Between 1 and 12 inclusive)");
		String input = scanner.nextLine();
		MultiplicationFlashCards multiplicationFlashCards = null;
		/** Determine if there is multiple multiplications, if so purse them */
		if (input.contains(" ")) {
			String[] inputs = input.split(" ");
			int[] multipliers = new int[inputs.length];
			for (int i = 0; i < inputs.length; ++i) {
				multipliers[i] = Integer.parseInt(inputs[i]);
			}
			multiplicationFlashCards = new MultiplicationFlashCards(multipliers);
		} else {
			multiplicationFlashCards = new MultiplicationFlashCards(Integer.parseInt(input));
		}
		/** Main loop */
		boolean c = true;
		while (c && multiplicationFlashCards.nextCard()) {
			System.out.println("Next? (Y or N)");
			if (scanner.nextLine().toLowerCase().equals("n")) {
				c = false;
			}
		}
		/** Final print statement */
		System.out.println("You've got a score of " + multiplicationFlashCards.getScore() + " so far");
		scanner.close();
	}

}
