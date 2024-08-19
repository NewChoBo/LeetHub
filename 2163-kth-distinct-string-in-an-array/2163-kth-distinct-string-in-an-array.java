class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Boolean> stringCntMap = new HashMap();
        for (String str : arr) {
            if (stringCntMap.get(str) == null) {
                stringCntMap.put(str, true);
            } else {
                stringCntMap.put(str, false);
            }
        }
        String result = "";
        int cnt = 0;
        for (String str : arr) {
            if (stringCntMap.get(str)) {
                cnt++;
                if (cnt == k) {
                    result = str;
                    break;
                }
            }
        }
        return result;
    }
}