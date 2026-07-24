class Solution {
    int memo[];
    public int climbStairs(int n) {
        memo = new int[n];
        Arrays.fill(memo, -1);
        return climbStairsRecursive(n, 0,memo);
    }

    private int climbStairsRecursive(int numStairs, int index, int[] memo){
        
        if(index == numStairs){
            return 1;
        }
        if(index>numStairs){
            return 0;
        }

        if(memo[index]!= -1){
            return memo[index];
        }

        memo[index] =  climbStairsRecursive(numStairs, index+1,memo) +climbStairsRecursive(numStairs, index+2, memo);
        return memo[index];
    }

    
}
