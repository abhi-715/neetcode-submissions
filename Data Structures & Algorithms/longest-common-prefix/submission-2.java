class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        // Start with the prefix as the first string
        String prefix = strs[0];
        // Compare the chosen prefix with each string
        for (int i = 1; i < strs.length; i++) {
            // Find the common prefix between current prefix and strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                // Reduce the prefix by one character from the end each time
                prefix = prefix.substring(0, prefix.length() - 1);
                // If prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}

