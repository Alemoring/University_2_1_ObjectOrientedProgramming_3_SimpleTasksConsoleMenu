public class Sentence {
    private String str;
    private int len;

    public Sentence() {
        str = new String("May the force be with you.");
        len = str.length() - 1;
    }

    public Sentence(String s) {
        str = s;
        len = str.length() - 1;
    }

    public String reverseSentence() {
        String reverse = "";
        char c = Character.toLowerCase(str.charAt(0));
        int i = 0;
        while (i < len) {
            Word word = new Word();
            while (c != ' ' && c != '.') {
                word.buildWord(c);
                i++;
                c = str.charAt(i);
            }
            if (c != '.') {
                i++;
                c = str.charAt(i);
            }
            reverse = word + " " + reverse;
        }

        String firstch = reverse.substring(0, 1);
        String restofs = reverse.substring(1);
        firstch = firstch.toUpperCase();
        reverse = firstch + restofs;
        reverse = reverse.trim();
        reverse += ".";

        return reverse;
    }

    public Word consonantLetterSwapDefis() {
        int i = 0;
        char c = str.charAt(i);
        Word result = new Word();
        String wrong = "a e i o u y A E I O U Y. у е э о а ы я и ю У Е Э О А Ы Я И Ю";
        while (i < len) {
            if (wrong.indexOf(c) < 0) {
                c = '-';
            }
            result.buildWord(c);
            i++;
            c = str.charAt(i);
        }
        result.buildWord('.');
        return result;
    }

    public int findCountOfSameWord() {
        return findCountOfSameWord(5);
    }

    public int findCountOfSameWord(int length) {
        int i = 0;
        char c = str.charAt(i);
        int k = 0;
        while (i < len) {
            Word dops = new Word();
            while (c != ' ' && c != '.') {
                dops.buildWord(c);
                i++;
                c = str.charAt(i);
            }
            if (dops.len == length) {
                k++;
                if (c != '.') {
                    i++;
                    c = str.charAt(i);
                }
            } else if (c != '.') {
                i++;
                c = str.charAt(i);
            }
        }
        return k;
    }

    @Override
    public String toString() {
        return str;
    }
}
