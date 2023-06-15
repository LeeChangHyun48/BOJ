import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int T, H, W;
	static char map[][];
	static boolean visit[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();

			map = new char[H][W];
			visit = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				String st = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = st.charAt(j);
				}
			}

			int cnt = 0;

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '#' && !visit[i][j]) {
						bfs(i, j);
						cnt += 1;
					}
				}
			}

			System.out.println(cnt);

		}

	}

	static int dy[] = { 1, 0, -1, 0 };
	static int dx[] = { 0, 1, 0, -1 };

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		visit[i][j] = true;
		queue.add(new int[] { i, j });

		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.poll()[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || nx < 0 || ny >= H || nx >= W || visit[ny][nx] || map[ny][nx] != '#') {
					continue;
				}

				queue.add(new int[] { ny, nx });
				visit[ny][nx] = true;
			}

		}

	}

}
