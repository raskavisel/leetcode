import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return result;  // not enough numbers for quadruplet

        Arrays.sort(nums); // Step 1: sort the array

        // Step 2: fix first two numbers
        for (int i = 0; i < n - 3; i++) {
            // avoid duplicate for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // avoid duplicate for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;  // pointer after j
                int right = n - 1; // last pointer

                // Step 3: two-pointer approach
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // skip duplicates for left
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // skip duplicates for right
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;  // need bigger sum
                    } else {
                        right--; // need smaller sum
                    }
                }
            }
        }
        return result;
    }
}