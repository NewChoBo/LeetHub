class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer newIndex = numMap.get(target - num);
            if (newIndex != null) {
                if (i == newIndex)
                    continue;
                return new int[] { i, newIndex };
            }
        }
        return null;
    }
}