import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int n, m, cnt, max = 0;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		map = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					bfs(i, j);
					cnt += 1;
				}
			}
		}

		System.out.println(cnt);
		if (cnt == 0) {
			System.out.println(0);
		} else {
			System.out.println(max + 1);
		}

	}

	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { -1, 0, 1, 0 };

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { i, j });
		visit[i][j] = true;
		int area = 0;
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.poll()[1];

			for (int d = 0; d < 4; d++) {
				int ny = dy[d] + y;
				int nx = dx[d] + x;

				if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 0 || visit[ny][nx]) {
					continue;
				}
				area += 1;
				queue.offer(new int[] { ny, nx });
				visit[ny][nx] = true;
			}
		}
		max = Math.max(max, area);

	}

}
