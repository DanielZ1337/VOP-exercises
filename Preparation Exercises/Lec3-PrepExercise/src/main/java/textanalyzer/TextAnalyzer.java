package textanalyzer;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAnalyzer {

	private File file;

	public TextAnalyzer(String fileName) {
		file = new File(fileName);
	}



	// Opgave 2:   Nearly as Listing 21.9 from Liang
	//
	public Map<String, Integer> countWords() throws FileNotFoundException {
		Map<String, Integer> map = new HashMap<>();

			//map = //create hashmap instance

		// gennemlæs filen "alice30.txt" et ord ad gangen
		Scanner scanner = new Scanner(file);
		// kald clean() metoden på hvert ord
		while(scanner.hasNext()){
			String word = clean(scanner.next());
			if(map.containsKey(word)){
				map.replace(word, map.get(word)+1);
			} else {
				map.put(word, 1);
			}
		}
		// benyt mappe til at tælle forekomsten af hvert ord


		return map;
	}



	// Denne metode forsøger at fjerne alt 'snavs' fra en String,
	// så kun bogstaver bevares og store gøres til små
	private String clean(String s) {
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				r = r + c;
			}
		}
		return r.toLowerCase();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException{

		TextAnalyzer ta = new TextAnalyzer("Preparation Exercises/Lec3-PrepExercise/alice30.txt");


		// Opgave 2. Tæl forekomster af ord
		Map<String, Integer> map = ta.countWords();
		System.out.println(map);

		System.out.println("\n------------------------------------------------------------------\n");

	}

}
