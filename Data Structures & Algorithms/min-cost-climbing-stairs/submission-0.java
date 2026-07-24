class Solution {
    int memo[];
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(minCostClimbingStairsRecursive(cost, 0,memo),
        minCostClimbingStairsRecursive(cost, 1,memo));
    }

    private int minCostClimbingStairsRecursive(int[] cost, int index, int[] memo){
        //Base case
        if(index >= cost.length){
            return 0;
        }
        
        if(memo[index]!= -1){
            return memo[index];
        }
        memo[index] =  cost[index] + Math.min(minCostClimbingStairsRecursive(cost, index+1,memo), minCostClimbingStairsRecursive(cost, index+2, memo));
        return memo[index];
    }
}
