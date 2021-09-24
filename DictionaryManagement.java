import java.util.ArrayList;
import java.util.Scanner;
public class DictionaryManagement {
    public static int cnt = 0;

    public static Word[] words = new Word[100000];

    public static void insertFromCommandline(Word newWord) {
        words[cnt] = newWord;
        cnt++;
    }

    public void showAllWords() {
        String res = "No  | English            | Vietnamese" + '\n';
        System.out.println(res);
        for(int i=0;i<cnt;i++){
            System.out.print((i + 1) + "   ");
            words[i].print();
        }
    }

    public static void main(String[] args) {
        ArrayList<Word> dict= new ArrayList<Word>();
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter number of words: ");
        int t= Integer.parseInt(scanner.nextLine().trim());
        for(int i=0;i<t;i++){
            Word word= new Word();
            System.out.print("Enter English word: ");
            word.setWord_target(scanner.nextLine());
            System.out.print("Enter Vietnamese explanation: ");
            word.setWord_explain(scanner.nextLine());
            dict.add(word);
        }
        DictionaryManagement dm = new DictionaryManagement();
        for(int i=0;i<t;i++){
            dm.insertFromCommandline(dict.get(i));
        }

        dm.showAllWords();

    }
}
