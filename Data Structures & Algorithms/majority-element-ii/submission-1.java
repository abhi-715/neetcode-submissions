class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0; int count2 = 0;
        Integer element1 = Integer.MIN_VALUE;
        Integer element2 = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){

            if(count1 == 0 && element2 != nums[i]){
                element1 = nums[i];
                count1 = 1;
            }else if(count2 == 0 && element1 != nums[i]){
                element2 = nums[i];
                count2 = 1;
            }else if(element1 == nums[i]){
                count1++;
            }else if(element2 == nums[i]){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == element1) count1++;
            else if (num == element2) count2++;
        }

        int threshold = nums.length / 3;
        if (count1 > threshold) result.add(element1);
        if (count2 > threshold) result.add(element2);

        return result;
    
    }
}