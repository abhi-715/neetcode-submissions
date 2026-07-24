class Solution {
    public int maxArea(int[] heights) {
        int L = 0;
        int R = heights.length -1;
        int res = 0;

        while (L < R){
            int area = Math.min(heights[L], heights[R]) * (R-L);
            res = Math.max(res, area);
            if(heights[L] <= heights[R]){
                L++;
            }else{
                R--;
            }
        }
        return res;
    }
}
