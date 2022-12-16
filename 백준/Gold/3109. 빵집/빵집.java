import java.util.Scanner;

public class Main {

	static int R, C, cnt;
	static char[][] map;
	static boolean[][] visited;
	static int dy[] = { -1, 0, 1 };
	static int dx[] = { 1, 1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String st = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = st.charAt(j);
			}
		}
		cnt = 0;
		for (int i = 0; i < R; i++) {
			find(i, 0);
		}

		System.out.println(cnt);

	}

	public static boolean find(int y, int x) {
		visited[y][x] = true;
		if (x == C - 1) {
			cnt++;
			return true;
		}

		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] != '.' || visited[ny][nx]) {
				continue;
			}

			visited[ny][nx] = true;
			if (find(ny, nx)) {
				return true;
			}
		}
		return false;

	}

}
