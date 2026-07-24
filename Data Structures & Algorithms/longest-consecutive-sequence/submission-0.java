class Solution {
    public int longestConsecutive(int[] nums) {
        
        int maxLength = 0;
        Set numSet = new HashSet();
        for(int i : nums){
            numSet.add(i);
        }
        
        for(int i : nums){
            int currentNum = i;
            int currentLength = 0;
            if(!numSet.contains(currentNum-1)){
                currentLength=1;
                while(numSet.contains(currentNum+1)){
                    currentLength++;
                    currentNum++;
                }
            }
            
           
            
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}