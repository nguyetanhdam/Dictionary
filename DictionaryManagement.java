public class DictionaryManagement {
    public int cnt = 0;

    public Word[] words = new Word[100000];

    public void insertFromCommandline(Word newWord) {
        words[cnt] = newWord;
        cnt++;
    }

    public String showAllWords() {
        String res = "No | English              | Vietnamese" + '\n';
        for (int i = 0; i < cnt; i++) {
            res += Integer.toString(i + 1) + "  " + words[i].showWord() + '\n';
        }
        return res;
    }

    public static void main(String[] args) {
        Word word1 = new Word();
        word1.setWord_target("Hello");
        word1.setWord_explain("Xin chao");

        Word word2 = new Word();
        word2.setWord_target("Bye");
        word2.setWord_explain("Tam biet");

        Word word3 = new Word();
        word3.setWord_target("Book");
        word3.setWord_explain("Quyen sach");

        DictionaryManagement dm = new DictionaryManagement();
        dm.insertFromCommandline(word1);
        dm.insertFromCommandline(word2);
        dm.insertFromCommandline(word3);

        String str = (String) dm.showAllWords();
        System.out.println(str);
    }
}