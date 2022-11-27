import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String st = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = st.charAt(j) - '0';
			}
		}

		bfs();

		System.out.println(map[N - 1][M - 1]);

	}

	static int dy[] = { 0, -1, 0, 1 };
	static int dx[] = { 1, 0, -1, 0 };

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 0, 0 });
		visit[0][0] = true;

		order: while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.poll()[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 0) {
					continue;
				}

				queue.offer(new int[] { ny, nx });
				visit[ny][nx] = true;
				map[ny][nx] = map[y][x] + 1;

				if (ny == N - 1 && nx == M - 1) {
					break order;
				}

			}
		}

	}

}
