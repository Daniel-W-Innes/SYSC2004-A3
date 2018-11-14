import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Class LanguageFlashCards.
 * 
 * @author Daniel Innes 101067175
 */
public class LanguageFlashCards extends AbstractFlashCards {
	private final String COMMA_DELIMITER = ",";
	@SuppressWarnings("unused")
	private String filename;

	/**
	 * Instantiates a new language flashcards deck.
	 *
	 * @param filename the filename
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	LanguageFlashCards(String filename) throws IOException {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String line = "";
		String[] columnHeadings = null;
		try {
			/** read and add all cards from file */
			fileReader = new FileReader(filename);
			bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				columnHeadings = line.split(COMMA_DELIMITER);
				addCard(columnHeadings[0], columnHeadings[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			fileReader.close();
		}
	}
}
