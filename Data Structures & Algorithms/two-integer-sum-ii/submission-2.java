class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int L = 0;
        int R = numbers.length-1;

        while(L<R){
            if(numbers[L] + numbers[R] == target){
                return new int[]{L+1, R+1};
            }else if (numbers[L] + numbers[R] > target){
                R--;
            }else if (numbers[L] + numbers[R] < target){
                L++;
            }
        }
        return new int[]{};
        
    }
}
