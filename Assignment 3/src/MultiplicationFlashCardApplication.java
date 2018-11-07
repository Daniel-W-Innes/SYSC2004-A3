import java.util.Scanner;

public class MultiplicationFlashCardApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Which times tables would you like to test? (Between 1 and 12 inclusive)");
		String input = scanner.nextLine();
		MultiplicationFlashCards multiplicationFlashCards = null;
		if (input.contains(" ")) {
			String[] inputs = input.split(" ");
			int[] multipliers = new int[inputs.length];
			for (int i =0; i < inputs.length;++i) {
				multipliers[i] = Integer.parseInt(inputs[i]);
			}
			multiplicationFlashCards = new MultiplicationFlashCards(multipliers);	
		}else {
			multiplicationFlashCards = new MultiplicationFlashCards(Integer.parseInt(input));	
		}
		boolean c = true;
		while (c&&multiplicationFlashCards.nextCard()) {
			System.out.println("Next? (Y or N)");
			if (scanner.nextLine().toLowerCase().equals("n")) {
				c = false;
			}
		}
		scanner.close();
	}

}
