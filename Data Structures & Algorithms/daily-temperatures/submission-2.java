public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // Check if the stack is not empty and the current temperature is greater than that at stack's top index
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index; // The difference in days
            }
            // Push the current index onto the stack
            stack.push(i);
        }
        
        return result;
    }
}