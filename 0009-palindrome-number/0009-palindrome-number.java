class Solution {
	public boolean isPalindrome(int x) {
		char[] str = String.valueOf(x).toCharArray();
		for (int i = 0; i < str.length; i++) {
			if (str[i] != str[str.length - i - 1])
				return false;
		}
		return true;
	}
}
