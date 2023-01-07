import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int w, h, cnt;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();

			if (w == 0 && h == 0) {
				break;
			}

			map = new int[h][w];
			visited = new boolean[h][w];
			cnt = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt += 1;
					}
				}
			}
			System.out.println(cnt);
		}

	}

	static int dy[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int dx[] = { -1, 0, 1, 1, 1, 0, -1, -1 };

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.poll()[1];

			for (int d = 0; d < 8; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || nx < 0 || ny >= h || nx >= w || visited[ny][nx] || map[ny][nx] == 0) {
					continue;
				}

				queue.offer(new int[] { ny, nx });
				visited[ny][nx] = true;
			}
		}

	}

}
