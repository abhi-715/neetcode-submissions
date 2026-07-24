class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the target is found at mid
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half [left..mid] is sorted
            if (nums[left] <= nums[mid]) {
                // Check if the target lies within the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search in the left half
                } else {
                    left = mid + 1;  // Search in the right half
                }
            }
            // Else, the right half [mid..right] must be sorted
            else {
                // Check if the target lies within the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Search in the right half
                } else {
                    right = mid - 1; // Search in the left half
                }
            }
        }

        // Target not found
        return -1;
    }
}
