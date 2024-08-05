class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max)
                max = num;
            if (num < min)
                min = num;
        }

        for (int i = min; i >= 1; i--) {
            if (max % i == 0 && min % i == 0)
                return i;
        }
        return -1;
    }
}