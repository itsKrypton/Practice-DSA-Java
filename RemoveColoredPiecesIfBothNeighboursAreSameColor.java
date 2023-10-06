// https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/description/?envType=daily-question&envId=2023-10-02

/*
 * Count the number of (A's - 2) and (B's - 2) that are in a group of 3 or more same characters. At the end, if number of A > B then return true, else B.
 */

public class RemoveColoredPiecesIfBothNeighboursAreSameColor {
    public boolean winnerOfGame(String colors) {
        int numOfAs = 0, numOfBs = 0;

        for(int i = 0; i < colors.length(); i++)
        {
            int currentLength = 1;
            while(i < colors.length() - 1 && colors.charAt(i) == colors.charAt(i + 1))
            {
                currentLength++;
                i++;

                if(currentLength >= 3)
                {
                    if(colors.charAt(i) == 'A')
                        numOfAs++;

                    else
                        numOfBs++;
                }
            }
        }

        return (numOfAs > numOfBs);
    }
}
