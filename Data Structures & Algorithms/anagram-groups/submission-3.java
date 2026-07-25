class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] charMap = new int[26];
            for(char c : str.toCharArray()){
                charMap[c - 'a']++;
            }
            String key = Arrays.toString(charMap);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
