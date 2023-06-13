import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visit = new boolean[N][M];
		queue = new LinkedList<int[]>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					queue.add(new int[] { i, j });
					visit[i][j] = true;
				}
			}
		}

		bfs();

	}

	static int dy[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int dx[] = { -1, -1, -1, 0, 1, 1, 1, 0 };

	private static void bfs() {
		int max = 1;

		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.poll()[1];

			for (int d = 0; d < 8; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] != 0) {
					continue;
				}

				queue.add(new int[] { ny, nx });
				visit[ny][nx] = true;
				map[ny][nx] = map[y][x] + 1;
				max = Math.max(max, map[ny][nx]);

			}

		}

		System.out.println(max - 1);

	}

}
