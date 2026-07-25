class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){

            if(i>0 && nums[i] == nums[i-1]) continue;

            int L = i+1, R = nums.length - 1;

            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum > 0){
                    R--;
                }else if (sum < 0){
                    L++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    L++;
                    R--;
                    while(L<R && nums[L] == nums[L-1]){
                        L++;
                    }
                }
            }
        }
        return res;
    }
}
