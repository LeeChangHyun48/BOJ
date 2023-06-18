import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, L, R, sum, cnt;
	static int[][] map;
	static boolean[][] visit;
	static Deque<int[]> temp = new LinkedList<int[]>();
	static boolean check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int time = 0;

		while (true) {
			sum = 0;
			visit = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						bfs(i, j);
						if (check) {
							int avg = sum / temp.size();

							while (!temp.isEmpty()) {
								int y = temp.peek()[0];
								int x = temp.poll()[1];

								map[y][x] = avg;
							}
							
						}
					}
				}
			}

			if (cnt == 0) {
				break;
			}
			
			time += 1;

			
		}

		System.out.println(time);

	}

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { i, j });
		temp.offer(new int[] { i, j });
		visit[i][j] = true;
		check = false;
		sum = map[i][j];

		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.poll()[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || Math.abs(map[y][x] - map[ny][nx]) < L
						|| Math.abs(map[y][x] - map[ny][nx]) > R) {
					continue;
				}

				queue.offer(new int[] { ny, nx });
				temp.offer(new int[] { ny, nx }); // 통과하는 좌표 저장
				visit[ny][nx] = true;
				check = true;
				cnt += 1;
				sum += map[ny][nx];
			}

			if (!check) {
				temp.pollLast();
			}
		}

	}

}
