class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
    
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] result = new int[nums.length - k + 1];
        
        for (int i = 0; i < nums.length; i++) {
            // Remove elements that are out of current window range
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] < i - k + 1) {
                maxHeap.poll();
            }
            
            // Add current element with its index to the heap
            maxHeap.offer(new int[] {nums[i], i});
            
            // If the window is completely filled, the max element of the window is at the root of the heap
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }
        
        return result;
    }
}
