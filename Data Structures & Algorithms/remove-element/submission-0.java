class Solution {
    public int removeElement(int[] nums, int val) {
        int ptr2 = 0;
        for(int ptr1 = 0; ptr1 < nums.length; ptr1++){
            if(nums[ptr1] != val){
                nums[ptr2++] = nums[ptr1];
            }
        }
        return ptr2;
    }
}