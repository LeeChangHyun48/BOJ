import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, m;
	static int map[][];
	static boolean visit[][];
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visit = new boolean[n][m];
		queue = new LinkedList<int[]>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					queue.add(new int[] { i, j });
					visit[i][j] = true;
				}

			}
		}

		bfs();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					sb.append(map[i][j] + " ");
					continue;
				}
				sb.append(map[i][j] - 2 + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

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

				if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 0 || visit[ny][nx]) {
					continue;
				}

				queue.add(new int[] { ny, nx });
				visit[ny][nx] = true;

				map[ny][nx] += map[y][x];

			}
		}

	}

}
