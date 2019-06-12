class Solution {
    public int[] twoSum(int[] nums, int target) {
        // iterate over array, pick one element and check if paired up with any rem. ele = target
        for(int i = 0; i < nums.length; i++)
            for(int j = i + 1; j < nums.length; j++)
                if(nums[i] + nums[j] == target)
                    return new int[] {i, j};
        throw new IllegalArgumentException("No two sum soln.");
    }
}
