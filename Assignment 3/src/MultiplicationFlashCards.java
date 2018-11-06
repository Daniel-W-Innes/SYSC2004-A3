
public class MultiplicationFlashCards extends AbstractFlashCards {
	MultiplicationFlashCards(int multiplier) {
		for (int i = 1; i <= 12; ++i) {
			addCard(multiplier + " * " + i, Integer.toString(multiplier * i));
		}
	}

	MultiplicationFlashCards(int[] multipliers) {
		for (int i = 0; i < multipliers.length;++i) {
			for (int j = 1; j <= 12; ++j) {
				addCard(multipliers[i] + " * " + j, Integer.toString(multipliers[i] * j));
			}
		}
	}
}
