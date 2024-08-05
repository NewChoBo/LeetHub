class Solution {
    public String kthDistinct(String[] arr, int k) {
        Set<String> stringSet = new HashSet();
        Map<String, Integer> counterMap = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            String word = arr[i];
            if(counterMap.get(word) == null) counterMap.put(word, 0);
            counterMap.put(word, counterMap.get(word)+1);
        }

        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            String word = arr[i];
            if(counterMap.get(word) == 1) {
                cnt++;
                if(cnt == k) {
                    return word;
                }
            }
        }
        return "";
    }
}