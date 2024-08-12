import java.util.HashMap;
import java.util.Map;

class Solution {
	public int romanToInt(String s) {
		// I, V, X, L, C, D, M
		// 주로 가장 큰 수부터 작아지도록 작성. 하지만, 4는 I 4개가 아니라, IV이다. 9 역시 IX이다.
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		char[] chars = s.toCharArray();
		int sum = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			int num = map.get(chars[i]);
			if (i != 0) {
				int prevNum = map.get(chars[i - 1]);
				if (prevNum < num) {
					sum += num - prevNum;
					i--;
					continue;
				}
			}
			sum += num;
		}

		return sum;
	}
}
