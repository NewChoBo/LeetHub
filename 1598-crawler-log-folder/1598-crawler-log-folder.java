class Solution {
    public int minOperations(String[] logs) {
        int cnt = 0;
        for (int i = 0; i < logs.length; i++) {
            switch (logs[i]) {
                case "../":
                    cnt--;
                    if (cnt < 0)
                        cnt = 0;
                    break;
                case "./":
                    break;
                default:
                    cnt++;
            }
        }
        return cnt;
    }
}