import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, K, cnt;
	static int map[][];
	static boolean visit[][];
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			map[r - 1][c - 1] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					bfs(i, j);
					max = Math.max(max, cnt);
				}
			}
		}
		
		System.out.println(max);

	}

	static int dy[] = { 1, 0, -1, 0 };
	static int dx[] = { 0, 1, 0, -1 };

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { i, j });
		visit[i][j] = true;
		cnt = 1;

		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.poll()[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 0) {
					continue;
				}
				cnt += 1;
				queue.add(new int[] { ny, nx });
				visit[ny][nx] = true;

			}

		}

	}

}
