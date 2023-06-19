import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, T;
	static int map[][];
	static boolean visit[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int sum = 0;
				for (int k = 0; k < 3; k++) {
					int input = sc.nextInt();
					sum += input;
				}
				map[i][j] = sum / 3;
			}
		}

		T = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] >= T) {
					map[i][j] = 255;
				} else {
					map[i][j] = 0;
				}
			}

		}

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 255 && !visit[i][j]) {
					bfs(i, j);
					cnt += 1;
				}
			}

		}

		System.out.println(cnt);

	}

	static int dy[] = { 1, 0, -1, 0 };
	static int dx[] = { 0, 1, 0, -1 };

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { i, j });
		visit[i][j] = true;

		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.poll()[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 0) {
					continue;
				}

				queue.add(new int[] { ny, nx });
				visit[ny][nx] = true;
			}
		}

	}

}
