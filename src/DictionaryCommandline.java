import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
    public static Scanner scanner = new Scanner(System.in);

    public static void showAllWords() {
        int i = 1;
        Dictionary dict= new Dictionary();
        System.out.println("No  | English            | Vietnamese" + '\n');
        for (Word word : dict.getDict()) {
            System.out.printf("%-4d", i);
            word.print();
            i++;
        }
    }

    public static void dictionarySearcher() {
        String s = scanner.nextLine().trim();
        System.out.println(Dictionary.BinarySearch(s));
    }

    private void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    private void dictionaryAdvanced() {
        DictionaryManagement.insertFromFile();
        showAllWords();
        DictionaryManagement.dictionaryLookup();
    }
}