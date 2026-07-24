public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        
        HashMap<Character, Integer> tFreq = new HashMap<>();
        HashMap<Character, Integer> windowFreq = new HashMap<>();
        
        // Store frequency of characters in t
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        int matched = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        
        // Expand the window with the right pointer
        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            
            if (tFreq.containsKey(c) && windowFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                matched++;
            }
            
            // If all characters are matched, try to shrink the window
            while (matched == tFreq.size()) { // While is important
                if (right - left + 1 < minLength) { //Calculate MinLength and Start index
                    minLength = right - left + 1;
                    start = left;
                }
                
                // Remove the character at the left pointer from the window
                char leftChar = s.charAt(left);
                if (windowFreq.containsKey(leftChar)) {
                    windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                    if (tFreq.containsKey(leftChar) && windowFreq.get(leftChar) < tFreq.get(leftChar)) {
                        matched--;
                    }
                }
                left++;
            }
            
            right++;
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}