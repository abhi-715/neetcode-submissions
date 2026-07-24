class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        String longest = "";
        
        for (int i = 0; i < s.length(); i++) {
            // Get the longest palindrome with i as the center (odd length)
            String oddPalindrome = expandFromCenter(s, i, i);
            // Get the longest palindrome with i and i+1 as the center (even length)
            String evenPalindrome = expandFromCenter(s, i, i + 1);
            
            // Find the longer of the two palindromes
            String longerPalindrome = oddPalindrome.length() > evenPalindrome.length() ? oddPalindrome : evenPalindrome;
            
            // Update the longest palindrome found so far
            if (longerPalindrome.length() > longest.length()) {
                longest = longerPalindrome;
            }
        }
        
        return longest;
    }
    
    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the palindromic substring
        return s.substring(left + 1, right);
    }
}
