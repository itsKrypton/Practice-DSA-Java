// https://leetcode.com/problems/excel-sheet-column-title/description/

public class ExcelSheetColumnTitle {
    /*
     * Using same logic as converting decimal to a number of base 26 but with a slight change that numbers start from 1 to 26 not 0 to 25. Thus, while considering a 
     * number, always decrement it by one and then use it for calculation to get correct answers.
     */

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while(columnNumber > 0)
        {
            int remainder = (columnNumber - 1) % 26; // - 1 to make it zero based indexing
            sb.append((char)(remainder + 'A'));
            columnNumber = (columnNumber - 1) / 26;
        }

        return sb.reverse().toString();
    }
}
