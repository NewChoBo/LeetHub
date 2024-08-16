class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        List<Counter> list = new ArrayList();
        for (List<Integer> integerList : arrays) {
            list.add(new Counter(integerList));
        }
        int maxDiff = 0;
        int max = list.get(0).max;
        int min = list.get(0).min;

        for (int i = 1; i < arrays.size(); i++) {
            Counter counter = list.get(i);
            if (max - counter.min > maxDiff)
                maxDiff = max - counter.min;
            if (counter.max - min > maxDiff)
                maxDiff = counter.max - min;
            if (max < counter.max)
                max = counter.max;
            if (min > counter.min)
                min = counter.min;
        }
        return maxDiff;
    }

    static class Counter {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Counter(List<Integer> list) {
            for (int num : list) {
                if (min > num)
                    min = num;
                if (max < num)
                    max = num;
            }
        }
    }
}