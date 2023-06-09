import java.util.Scanner;

public class Main {

	static int N, M, r, c, d;
	static int map[][];
	static int cnt = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		r = sc.nextInt(); // 로봇 청소기 좌표
		c = sc.nextInt(); // 로봇 청소기 좌표
		d = sc.nextInt(); // 로봇 청소기가 보는 방향

		map = new int[N][M];

		for (int i = 0; i < N; i++) { // 맵 입력
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(r, c, d);

		System.out.println(cnt);

	}

	static int[] dy = { -1, 0, 1, 0 }; // 북 동 남 서 순으로 탐색
	static int[] dx = { 0, 1, 0, -1 };
	

	private static void dfs(int y, int x, int dir) {
		map[y][x] = 2; // 청소

		for (int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4;

			int ny = y + dy[dir];
			int nx = x + dx[dir];

			if (ny >= 0 && nx >= 0 && ny < N && nx < M) {
				if (map[ny][nx] == 0) { // 벽도 아니며 청소한 구역이 아닌경우 청소
					cnt += 1;
					dfs(ny, nx, dir);
					return;
				}
			}

		}

		d = (dir + 2) % 4; // 바라보고 있는 반대 방향으로 후진
		int by = y + dy[d];
		int bx = x + dx[d];

		if (by >= 0 && bx >= 0 && by < N && bx < M && map[by][bx] != 1) {
			dfs(by, bx, dir);
		}

	}

}
