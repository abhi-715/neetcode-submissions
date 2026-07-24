class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> indexMap = new HashMap<>();
        int L = 0, res = 0;

        for(int R = 0; R<s.length(); R++){
            if(indexMap.containsKey(s.charAt(R))){
                L = Math.max(indexMap.get(s.charAt(R))+1, L); //Important
            }

            indexMap.put(s.charAt(R), R);
            res = Math.max(res, R-L+1);
        }

        return res;
    }
}
