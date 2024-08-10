import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	static Space[][] map;

	static void bfs(Space space, int k) {
		Queue<Collector> queue = new ArrayDeque<>();
		addToQueue(queue, new Collector(space.x, space.y, k));

		while (!queue.isEmpty()) {
			Collector currentInfo = queue.poll();
			Space current = map[currentInfo.x][currentInfo.y];
			if (current.type == ' ') {
				for (int i = 0; i < 4; i++) {
					if (!current.visited[i]) {
						addToQueue(queue, new Collector(current.x, current.y, i));
					}
				}
			} else {
				int[] way = current.type == '\\' ? Space.reverseSlashConnection : Space.slashConnection;
				int dir = way[currentInfo.k];
				addToQueue(queue, new Collector(current.x, current.y, dir));
			}
		}
	}

	static void addToQueue(Queue<Collector> queue, Collector collector) {
		int x = collector.x;
		int y = collector.y;
		int k = collector.k;

		if (map[x][y].visited[k]) {
			return;
		}
		map[x][y].visited[k] = true;
		queue.add(collector);

		int[] move = Space.move[k];
		int tX = x + move[0];
		int tY = y + move[1];
		int nextDir = (k + 2) % 4;

		if (isValid(tX, tY) && !map[tX][tY].visited[nextDir]) {
			map[tX][tY].visited[nextDir] = true;
			queue.add(new Collector(tX, tY, nextDir));
		}
	}

	static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
	}

	public int regionsBySlashes(String[] grid) {
		map = new Space[grid.length][];
		for (int i = 0; i < map.length; i++) {
			map[i] = new Space[grid[i].length()];
			char[] chars = grid[i].toCharArray();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Space(chars[j], i, j);
			}
		}

		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {  // j++로 수정
				for (int k = 0; k < 4; k++) {
					if (!map[i][j].visited[k]) {
						bfs(map[i][j], k);
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	static class Collector {
		int x, y, k;

		Collector(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}

	static class Space {
		static final int[] slashConnection = {3, 2, 1, 0};  // 각 진입방향별 방출 방향
		static final int[] reverseSlashConnection = {1, 0, 3, 2};  // 각 진입방향별 방출 방향
		static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 방향 별 다음 위치

		char type;
		int x, y;
		boolean[] visited = new boolean[4];  // 상우하좌 0, 1, 2, 3

		Space(char type, int x, int y) {
			this.type = type;
			this.x = x;
			this.y = y;
		}
	}
}
