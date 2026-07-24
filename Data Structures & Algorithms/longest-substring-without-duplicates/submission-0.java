class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int L = 0, res = 0;

        for(int R = 0; R<s.length(); R++){
            if(freqMap.containsKey(s.charAt(R))){
                L = Math.max(freqMap.get(s.charAt(R))+1, L); //Important
            }

            freqMap.put(s.charAt(R), R);
            res = Math.max(res, R-L+1);
        }

        return res;
    }
}
