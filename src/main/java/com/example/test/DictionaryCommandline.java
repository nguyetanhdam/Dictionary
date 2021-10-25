package com.example.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
        ArrayList<Word> arraylist = Dictionary.BinarySearch(s);
        arraylist.forEach(word -> System.out.println(word.getWord_target()));
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