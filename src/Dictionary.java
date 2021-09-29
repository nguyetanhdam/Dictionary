import java.util.ArrayList;

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
}