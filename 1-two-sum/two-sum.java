import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap will store numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // what number we need to pair with nums[i]

            // If complement is already in the map, we found the answer
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Otherwise, put current number in map
            map.put(nums[i], i);
        }

        // We will never reach here because the problem guarantees one solution
        return new int[] {};
    }
}