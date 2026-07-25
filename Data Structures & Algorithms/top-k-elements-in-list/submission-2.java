class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        List<List<Integer>> freqBucket = new ArrayList<>(nums.length + 1);
        
        for(int i = 0; i<= nums.length; i++){
            freqBucket.add(new ArrayList());
        }

    
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            freqBucket.get(cnt).add(num);
        }

        int[] res = new int[k];
        int index = 0;

        for(int i = freqBucket.size()-1; i> 0 && index <k; i--){

            for(int num : freqBucket.get(i)){
                res[index++] = num;
                if(index == k){
                    return res;
                }
            }

        }
        return res;
    
    }
}
