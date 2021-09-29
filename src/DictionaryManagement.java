import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class DictionaryManagement {
    public static Scanner scanner = new Scanner(System.in);

    // public static ArrayList<Word> dict = new ArrayList<>();
    public static Dictionary dict= new Dictionary();
    public static void insertFromCommandline() {
        System.out.print("Enter number of words: ");
        int word_cnt = Integer.parseInt(scanner.nextLine().trim());
        for(int i = 0; i < word_cnt; i++) {
            Word word = new Word();
            System.out.print("Enter English word: ");
            word.setWord_target(scanner.nextLine());
            System.out.print("Enter Vietnamese explanation: ");
            word.setWord_explain(scanner.nextLine());
            dict.getDict().add(word);
        }
    }

    public static void insertFromFile() {
        File myFile = new File("dictionaries.txt");
        try {
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                Word new_word = new Word();
                String line = scanner.nextLine();
                String[] word = line.split("\\t");
                new_word.setWord_target(word[0]);
                new_word.setWord_explain(word[1]);
                dict.getDict().add(new_word);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        dict.getDict().sort((o1,o2)->(o1.getWord_target().compareTo(o2.getWord_target())));
    }

    public static void dictionaryExportToFile() {
        try {
            FileWriter fileWriter = new FileWriter("dictionaries.txt");
            for (Word w : dict.getDict()) {
                fileWriter.write(w.getWord_target() + '\t' + w.getWord_explain() + '\n');
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dictionaryLookup() {
        String s= scanner.nextLine().trim();
        Word word = dict.binaryLookup(0,dict.getDict().size()-1,s);
        System.out.println(word.getWord_explain());
    }
    public static void editDictionary() {
        System.out.print("Please press T to edit the Vietnamese explanation of Word Target or E to edit the English of Word Explain: ");
        String yourChoose = scanner.nextLine();

        System.out.print("Please enter a word: ");
        String word_before_edit = scanner.nextLine();

        Word word = null;

        if (yourChoose.equals("T")) {
            for (Word w : dict.getDict()) {
                if (w.getWord_target().equals(word_before_edit)) {
                    word = w;
                    break;
                }
            }
            if (word != null) {
                System.out.print("Please enter the replacement: ");
                word.setWord_explain(scanner.nextLine());
            }
            else System.out.println("The word does not exist!");
        }
        if (yourChoose.equals("E")) {
            for (Word w : dict.getDict()) {
                if (w.getWord_explain().equals(word_before_edit)) {
                    word = w;
                    break;
                }
            }
            if (word != null) {
                System.out.print("Please enter the replacement: ");
                word.setWord_target(scanner.nextLine());
            }
            else System.out.println("The word does not exist!");
        }
    }

    // brute force
    public static void removeWordInDictionary() {
        System.out.print("Please enter a word: ");
        String str = scanner.nextLine();

        Word word = null;
        for (Word w : dict.getDict()) {
            if (w.getWord_target().equals(str)) {
                word = w;
                break;
            }
        }
        if (word != null) {
            dict.getDict().remove(word);
            System.out.println("Remove " + str + " successful!");
        }
        else {
            System.out.println("The word does not exist!");
        }
    }
}

