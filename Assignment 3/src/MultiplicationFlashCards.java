
/**
 * The Class MultiplicationFlashCards.
 * 
 * @author Daniel Innes 101067175
 */
public class MultiplicationFlashCards extends AbstractFlashCards {

	/**
	 * Instantiates a new multiplication flash cards deck.
	 *
	 * @param multiplier the multiplier
	 */
	MultiplicationFlashCards(int multiplier) {
		for (int i = 0; i <= 12; ++i) {
			addCard(multiplier + " * " + i, Integer.toString(multiplier * i));
		}
	}

	/**
	 * Instantiates a new multiplication flash cards deck.
	 *
	 * @param multipliers the multipliers
	 */
	MultiplicationFlashCards(int[] multipliers) {
		for (int i = 0; i < multipliers.length; ++i) {
			for (int j = 0; j <= 12; ++j) {
				addCard(multipliers[i] + " * " + j, Integer.toString(multipliers[i] * j));
			}
		}
	}
}
