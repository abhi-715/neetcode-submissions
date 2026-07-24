class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // Only one house
        if (n == 2) return Math.max(nums[0], nums[1]); // Two houses, pick the maximum
        
        // Solve the problem for two cases
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, start, end, memo);
    }

    private int rob(int[] nums, int index, int end, int[] memo) {
        // Base case: If index goes beyond the valid range
        if (index > end) {
            return 0;
        }

        // If already computed, return the result
        if (memo[index] != -1) {
            return memo[index];
        }

        // Recurrence relation
        memo[index] = Math.max(
            rob(nums, index + 1, end, memo), // Skip the current house
            nums[index] + rob(nums, index + 2, end, memo) // Rob the current house
        );
        return memo[index];
    }
}
