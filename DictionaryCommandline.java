import java.util.ArrayList;

public class DictionaryCommandline {
    public void showAllWords() {
        int i = 1;
        DictionaryManagement dim = new DictionaryManagement();
        ArrayList<Word> WordList = dim.getWordList();
        dim.insertFromCommandline();

        System.out.println("No  | English            | Vietnamese" + '\n');
        for (Word word : WordList) {
            System.out.print(i + "   ");
            word.print();
            i++;
        }
    }

    public void dictionaryBasic() {

    }

    public static void main(String[] args) {
        DictionaryCommandline dcl = new DictionaryCommandline();
        dcl.showAllWords();
    }
}
