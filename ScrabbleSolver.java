import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 //Word finder program that takes a list of letters and finds all english words that can be formed from the user-inputed pool of letters
 public class ScrabbleSolver {
    public static void main (String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter your letters: ");
        String letters = scanner.nextLine().toUpperCase();

        Map<Character, Integer> lettersCountMap = getCharacterCountMap(letters);

        BufferedReader reader = new BufferedReader(new FileReader("C:/Users/jamie/Documents/Java Program Files/Personal Projects/ScrabbleSolver/dictionary.txt"));
        System.out.println("\nAll possible words based on given pool of letters: ");

        // Logic to see if we have enough letters in our pool to be equal to or greater than the letters of the word in the dictionary
        // If so, then print out the word from the dictionary has a plausible word to use
        for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) {
            Map<Character, Integer> currentWordMap = getCharacterCountMap(currentWord);
            
            boolean canMakeCurrentWord = true;
            for (Character character : currentWordMap.keySet()) {
                int currentWordCharCount = currentWordMap.get(character);
                int lettersCharCount = lettersCountMap.containsKey(character) ?
                                       lettersCountMap.get(character) : 0;
                
                if (currentWordCharCount > lettersCharCount) {
                    canMakeCurrentWord = false;
                    break;
                }
            }
            if (canMakeCurrentWord) {
                System.out.println(currentWord);
            }
        }
        scanner.close();
        reader.close();
    }

    // Gets the count for the available letters and stores in a map
    private static Map<Character, Integer> getCharacterCountMap(String letters) {
        Map<Character, Integer> lettersCountMap = new HashMap<>();
        
        for (int i=0; i < letters.length(); i++) {
            char currentChar = letters.charAt(i);

            int count = lettersCountMap.containsKey(currentChar) ?
                        lettersCountMap.get(currentChar) : 0;
            
            lettersCountMap.put(currentChar, count + 1);
        }

        return lettersCountMap;
    }
}