import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int M, N, K;
	static int[][] map;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 입력

		for (int tc = 0; tc < T; tc++) { // 테스트 케이스 만큼 반복

			M = sc.nextInt(); // 배추 밭 가로 길이
			N = sc.nextInt(); // 배추 밭 세로 길이
			K = sc.nextInt(); // 배추 위치 개수

			map = new int[M][N]; // 배추 밭 크기 지정
			visit = new boolean[M][N]; // 방문 크기 지정

			for (int i = 0; i < K; i++) { // 배추 위치 1로 지정
				int x = sc.nextInt();
				int y = sc.nextInt();

				map[x][y] = 1;
			}

			int cnt = 0;

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && !visit[i][j]) { // 벌레가 있으며 방문을 안했을 때
						bfs(i, j);
						cnt += 1; // 통과했을때 1 증가
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
		queue.offer(new int[] { i, j });
		visit[i][j] = true;

		while(!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.poll()[1];

			for (int d = 0; d < 4; d++) {
				int ny = dy[d] + y;
				int nx = dx[d] + x;

				if (ny < 0 || nx < 0 || ny >= M || nx >= N || map[ny][nx] != 1 || visit[ny][nx]) {
					continue;
				}

				queue.offer(new int[] { ny, nx });
				visit[ny][nx] = true;
			}

		}

	}

}
