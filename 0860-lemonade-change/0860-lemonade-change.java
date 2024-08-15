class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 5, 10, 20 달러짜리 지불. 고객이 5달러만 지불하도록 거스름돈
        int[] moneys = new int[] { 0, 0, 0 };
        boolean flag = true;
        for (int bill : bills) {
            if (!flag)
                break;
            switch (bill) {
                case 5:
                    moneys[0]++;
                    break;
                case 10:
                    moneys[0]--;
                    moneys[1]++;
                    if (moneys[0] < 0)
                        flag = false;
                    break;
                case 20:
                    if (moneys[1] > 0 && moneys[0] > 0) {
                        moneys[1]--;
                        moneys[0]--;
                    } else if (moneys[0] >= 3) {
                        moneys[0] -= 3;
                    } else {
                        flag = false;
                        break;
                    }
            }
            moneys[2]++;
        }
        return flag;
    }
}