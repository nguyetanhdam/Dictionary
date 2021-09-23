public class Word {
    private String word_target;
    private String word_explain;

    public Word() {
        word_target = "English";
        word_explain = "Tieng viet";
    }

    Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    // constructor copy

    public Word(Word newWord) {
        this.word_explain = newWord.getWord_explain();;
        this.word_target = newWord.word_target;
    }

    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String showWord() {
        return "| " + this.word_target + "   | " + this.word_explain;
    }
}

// DONE