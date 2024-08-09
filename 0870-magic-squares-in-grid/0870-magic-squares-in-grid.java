import java.util.HashSet;
import java.util.Set;

class Solution {
	static boolean check(int[][] grid, int x, int y) {
		Set<Integer> set = new HashSet<>();

		// 모든 숫자가 1부터 9까지의 고유한 값인지 확인
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				int num = grid[i][j];
				if (num < 1 || num > 9 || !set.add(num)) {
					return false;
				}
			}
		}

		// 각 행과 열의 합을 확인
		for (int i = 0; i < 3; i++) {
			if (grid[x + i][y] + grid[x + i][y + 1] + grid[x + i][y + 2] != 15)
				return false;
			if (grid[x][y + i] + grid[x + 1][y + i] + grid[x + 2][y + i] != 15)
				return false;
		}

		// 대각선의 합을 확인
		if (grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2] != 15)
			return false;
		return grid[x + 2][y] + grid[x + 1][y + 1] + grid[x][y + 2] == 15;
	}

	public int numMagicSquaresInside(int[][] grid) {
		int cnt = 0;
		for (int i = 0; i < grid.length - 2; i++) {
			for (int j = 0; j < grid[i].length - 2; j++) {
				if (check(grid, i, j))
					cnt++;
			}
		}
		return cnt;
	}
}
