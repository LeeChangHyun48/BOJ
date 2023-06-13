import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M;
	static char map[][];
	static boolean visit[][];
	static Queue<int[]> queue;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		visit = new boolean[N][M];
		queue = new LinkedList<int[]>();

		for (int i = 0; i < N; i++) {
			String st = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = st.charAt(j);
				if (map[i][j] == 'I') {
					queue.add(new int[] { i, j });
					visit[i][j] = true;
				}
			}
		}

		bfs();

		if (cnt == 0) {
			System.out.println("TT");
		} else {
			System.out.println(cnt);
		}

	}

	static int dy[] = { 1, 0, -1, 0 };
	static int dx[] = { 0, 1, 0, -1 };

	private static void bfs() {
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.poll()[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 'X') {
					continue;
				}

				queue.add(new int[] { ny, nx });
				visit[ny][nx] = true;

				if (map[ny][nx] == 'P') {
					cnt += 1;
				}

			}
		}

	}

}
