class Solution {
    int memo[];
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, 0,memo);
    }

    private int rob(int[] nums, int index, int[] memo){
        //base case
        if(index>=nums.length){
            return 0;
        }
        if(memo[index]!= -1){
            return memo[index];
        }
        memo[index] =  Math.max(rob(nums, index+1,memo),
        nums[index]+ rob(nums, index+2, memo));
        return memo[index];
    }
}