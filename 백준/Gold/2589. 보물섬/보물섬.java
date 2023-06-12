import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int L, W;
	static char[][] map;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		L = sc.nextInt();
		W = sc.nextInt();

		map = new char[L][W];

		for (int i = 0; i < L; i++) {
			String st = sc.next();
			for (int j = 0; j < W; j++) {
				map[i][j] = st.charAt(j);
			}
		}
		
		int ans = 0;
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'L') { // 육지일 때만 bfs 진입
					visit = new boolean[L][W];
					ans = Math.max(ans, bfs(i, j));
				}
			}
		}
		System.out.println(ans);

	}

	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, -1, 0, 1 };

	private static int bfs(int y, int x) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { y, x, 0 });
		visit[y][x] = true;
		int max = 0;

		while (!queue.isEmpty()) {
			int ty = queue.peek()[0];
			int tx = queue.peek()[1];
			int cnt = queue.poll()[2];

			for (int d = 0; d < 4; d++) {
				int ny = ty + dy[d];
				int nx = tx + dx[d];

				if (ny < 0 || nx < 0 || ny >= L || nx >= W || visit[ny][nx] || map[ny][nx] == 'W') {
					continue;
				}

				queue.offer(new int[] { ny, nx, cnt + 1 });
				visit[ny][nx] = true;
				max = Math.max(max, cnt + 1);
			}
		}
		
		return max;

	}

}
