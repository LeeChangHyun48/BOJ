import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int M, N, K;
	static int map[][];
	static boolean visit[][];
	static int cnt;
	static ArrayList<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();

		map = new int[M][N];
		visit = new boolean[M][N];
		list = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			Arrays.fill(map[i], 0);
		}

		for (int i = 0; i < K; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();

			for (int r = M - y1; r < M - y; r++) {
				for (int c = x; c < x1; c++) {
					map[r][c] = map[r][c] + 1;
				}
			}

		}

		int regcnt = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 && !visit[i][j]) {
					bfs(i, j);
					list.add(cnt);
					regcnt += 1;
				}
			}
		}

		Collections.sort(list);
		
		System.out.println(regcnt);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

	}

	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		visit[i][j] = true;
		queue.add(new int[] { i, j });
		cnt = 1;

		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.poll()[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || nx < 0 || ny >= M || nx >= N || visit[ny][nx] || map[ny][nx] != 0) {
					continue;
				}

				cnt += 1;
				visit[ny][nx] = true;
				queue.add(new int[] { ny, nx });
			}

		}

	}

}
