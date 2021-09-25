import java.util.ArrayList;

public class DictionaryCommandline {
    public static void showAllWords() {
        int i = 1;
        DictionaryManagement dim = new DictionaryManagement();
        ArrayList<Word> WordList = dim.getWordList();

        System.out.println("No  | English            | Vietnamese" + '\n');
        for (Word word : WordList) {
            System.out.print(i + "   ");
            word.print();
            i++;
        }
    }

    public static void dictionarySearcher() {

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