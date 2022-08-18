// https://leetcode.com/problems/find-the-winner-of-the-circular-game/submissions/

/* Josephus problem, here we keep reducing the n value till it reaches 1, at that position return 1 and next returned value will be based on,
 * y = (x + k) % n;
 * Draw the recursion pattern to visualize this.
 */

public class WinnerOfCircularGame {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 5));
    }

    public static int findTheWinner(int n, int k) {
        if(n == 1)
        return 1;

        int y = (findTheWinner(n-1, k) + k) % n; // If 0 based indexing is used then directly return this.

        return (y == 0) ? n : y; // For 1 based indexing if the returned value is 0 then return n otherwise return the normal value.
    }
}
