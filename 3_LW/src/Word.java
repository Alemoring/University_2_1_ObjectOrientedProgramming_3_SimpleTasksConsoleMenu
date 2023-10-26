public class Word {
    String word;
    int len;

    public Word() {
        word = "";
        len = 0;
    }

    public String buildWord(char c) {
        word += c;
        len += 1;
        return word;
    }

    @Override
    public String toString() {
        return word;
    }
}
