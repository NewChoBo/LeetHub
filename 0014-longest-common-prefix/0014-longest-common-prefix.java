class Solution {
    public String longestCommonPrefix(String[] strs) {
        char[][] charsArr = new char[strs.length][];
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            charsArr[i] = strs[i].toCharArray();
            if (minLength > charsArr[i].length)
                minLength = charsArr[i].length;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            boolean flag = false;
            for (int j = 1; j < charsArr.length; j++) {
                if (charsArr[j][i] != charsArr[0][i]) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
            sb.append(charsArr[0][i]);
        }

        return sb.toString();
    }

}