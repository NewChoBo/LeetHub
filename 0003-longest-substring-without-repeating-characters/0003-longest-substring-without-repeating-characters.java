class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        // 슬라이딩 윈도우를 활용하면 될 것.
        // 이미 한번 출현했던 항목이 나타나면 왼쪽을 앞으로 당기고 다시 오른쪽 늘리기 시작
        int startIndex = 0;
        char[] charArr = s.toCharArray();
        int maxLength = 0;

        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            while (charSet.contains(c)) {
                charSet.remove(charArr[startIndex]);
                startIndex++;
            }
            charSet.add(c);
            if (charSet.size() > maxLength) {
                maxLength = charSet.size();
            }
        }
        return maxLength;
    }
}