package com.example.test;

import java.util.ArrayList;
import java.util.HashSet;

public class Dictionary {
    public static ArrayList<Word> dict = new ArrayList<>();

    public ArrayList<Word> getDict() {
        return dict;
    }

    public void setDict(ArrayList<Word> dict) {
        this.dict = dict;
    }


    public static Word binaryLookup(int start, int end, String eng) {
        if(end<start) {
            return null;
        }
        int mid= start + (end-start)/2;
        Word word= dict.get(mid);
        String s= word.getWord_target();
        int compare = s.compareTo(eng);
        if(compare ==0) return word;
        if(compare > 0) return binaryLookup(start, mid-1, eng);
        return binaryLookup(mid+1,end, eng);
    }

    public void pushword(Word word) {
//        int length = dict.size();
//        Word check = binaryLookup(0, length - 1, word.getWord_target());
            dict.add(word);
       // System.out.println(word.getWord_target());
    }

    public static ArrayList BinarySearch(String search) {
        Dictionary dict= new Dictionary();
        ArrayList<Word> arr = new ArrayList<>();
        dict.getDict().removeIf(w -> w.getWord_target().length() < search.length());
        dict.getDict().sort((o1,o2)->(o1.getWord_target().compareTo(o2.getWord_target())));

        int low = 0, high = dict.getDict().size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (dict.getDict().get(mid).getWord_target().contains(search)) {
                 arr.add (dict.getDict().get(mid));
                dict.getDict().remove(dict.getDict().get(mid));
            }
            else if (dict.getDict().get(mid).getWord_target().compareTo(search) > 0) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return arr;
    }

    public static ArrayList<Word> getListWord(){
        return dict;
    }

}