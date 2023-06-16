import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int M, N;
	static char map[][];
	static boolean visit[][];
	static boolean check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		map = new char[M][N];
		visit = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			String st = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			if (map[0][i] == '0') {
				bfs(i);
			}
		}

		if (check) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	static int dy[] = { 1, 0, -1, 0 };
	static int dx[] = { 0, 1, 0, -1 };

	private static void bfs(int i) {
		Queue<int[]> queue = new LinkedList<int[]>();
		visit[0][i] = true;
		queue.add(new int[] { 0, i });

		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.poll()[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || nx < 0 || ny >= M || nx >= N || visit[ny][nx] || map[ny][nx] == '1') {
					continue;
				}

				visit[ny][nx] = true;
				queue.add(new int[] { ny, nx });

				if (ny == M - 1) {
					check = true;
					return;
				}
			}

		}

	}

}
