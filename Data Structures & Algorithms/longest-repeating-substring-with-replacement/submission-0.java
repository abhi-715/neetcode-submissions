class Solution {
    public int characterReplacement(String s, int k) {
     
        int start = 0;
        int maxLength = 0;
        Map<Character, Integer> mapCount = new HashMap<>();
        int longestCharLength = 0;
        for(int end = 0; end<s.length(); end++){
            char endChar = s.charAt(end);
            mapCount.put(endChar, mapCount.getOrDefault(endChar, 0) +1);
            longestCharLength = Math.max(longestCharLength, mapCount.get(endChar));
            
            if(end-start+1 - longestCharLength > k){
                mapCount.put(s.charAt(start), mapCount.getOrDefault(s.charAt(start),0)-1);
                start++;
            }
            
            maxLength = Math.max(maxLength,end-start+1 );
            
        }
        return maxLength;
    }
}