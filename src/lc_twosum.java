class Solution {
    public int[] twoSum(int[] nums, int target) {
        // soln. array of indices
        int ans[] = new int[2];
        // length of array = no. of elements
        int len = nums.length;
        boolean found = false;
        // iterate over array, pick one element and check if paired up with any rem. ele = target
        for(int i = 0; i < (len - 1) && !found; i++)
            for(int j = i + 1; j < len && !found; j++)
                if(nums[i] + nums[j] == target)
                {
                    ans[0] = i;
                    ans[1] = j;
                    found = true;
                }
        return ans;
    }
}
