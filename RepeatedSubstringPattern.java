public class RepeatedSubstringPattern {
    /*
     * Double the input string and remove the first and the last characters. If the input string still is a part of the doubled string then the answer is true.
     */

    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String doubleWithoutFirstAndLastChar = doubled.substring(1, doubled.length() - 1);
        return doubleWithoutFirstAndLastChar.contains(s);
    }
}
