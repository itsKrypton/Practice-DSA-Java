public class DetermineIfACellIsReachableInGivenTime {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dx = Math.abs(fx - sx);
        int dy = Math.abs(fy - sy);
        
        // Edge case, if both, start and finish are the same points, and t == 1, then it's false.
        if(dx == 0 && dy == 0 && t == 1) return false;
        
        /* 
         * Else, The minimum time taken would be min of dx and dy distance diagonally and the rest of the distance horizontally
         * or vertically to reach our target. This time should be less than or equal to the given time t.
         */
        
        return (Math.min(dx, dy) + Math.abs(dx - dy) <= t);
    }
}
