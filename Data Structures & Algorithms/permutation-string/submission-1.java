class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();


        if(s2Length < s1Length)
            return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        //First Window
        for(int i = 0; i<s1Length ;i++){ // only S1 Length
            s1Count[s1.charAt(i)-'a']++;
            s2Count[s2.charAt(i)-'a']++;
        }

        if(Arrays.equals(s1Count,s2Count)){
            return true;
        }

        //Slide window S2 if permutation does not exist in first window
        for(int i=s1Length; i<s2Length; i++){
            s2Count[s2.charAt(i)-'a']++;  //Count new element 
            s2Count[s2.charAt(i-s1Length)-'a']--; //Reduce the count for first element
            if (Arrays.equals(s1Count,s2Count))
                return true;
        }

        return false;
    }
}