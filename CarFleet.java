// https://leetcode.com/problems/car-fleet/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*
 * Sort cars on the basis of their position in descending order. Find the time it will require to reach the target, if stack is empty or the stack.peek() time is less 
 * than the current time that means that this car is behind the other cars in the stack and it's slower than all of them, thus it will never be able to catch up with
 * those cars. Hence, push it into the stack which means it's a new fleet.
 */

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<int[]> posAndSpeed = new ArrayList<>();

        for(int i = 0; i < position.length; i++)
        posAndSpeed.add(new int[]{position[i], speed[i]});

        Collections.sort(posAndSpeed, (a,b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for(int[] car : posAndSpeed)
        {
            double currentTime = (double)(target - car[0]) / car[1];

            if(stack.isEmpty() || currentTime > stack.peek())
            stack.push(currentTime);
        }

        return stack.size();
    }
}
