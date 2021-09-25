import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Scanner;

public class DictionaryManagement {
    public static Scanner scanner = new Scanner(System.in);

    String url = "D:\\IdeaProjects\\Dictionary\\src\\dictionaries.txt";

    public static ArrayList<Word> WordList = new ArrayList<>();

    public static void insertFromCommandline() {
        System.out.print("Enter number of words: ");
        int word_cnt = Integer.parseInt(scanner.nextLine().trim());
        for(int i = 0; i < word_cnt; i++) {
            Word word = new Word();
            System.out.print("Enter English word: ");
            word.setWord_target(scanner.nextLine());
            System.out.print("Enter Vietnamese explanation: ");
            word.setWord_explain(scanner.nextLine());
            WordList.add(word);
        }
    }

    public ArrayList<Word> getWordList() {
        return WordList;
    }

    public static void insertFromFile() {

    }

    public static void dictionaryLookup() {

    }
}