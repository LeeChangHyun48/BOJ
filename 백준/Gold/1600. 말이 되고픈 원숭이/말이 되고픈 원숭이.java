import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int[] kx = new int[] { -2, -1, 1, 2, -2, -1, 1, 2 };
	static int[] ky = new int[] { -1, -2, -2, -1, 1, 2, 2, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int c = sc.nextInt();
		int r = sc.nextInt();
		int[][] arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int temp = sc.nextInt();
				arr[i][j] = temp == 0 ? 0 : -1;
			}
		}

		int[][][] visit = new int[K + 1][r][c];

		Queue<int[]> monkey = new LinkedList<int[]>();
		monkey.add(new int[] { 0, 0, 0, 1 });
		visit[0][0][0] = 1;
		while (!monkey.isEmpty()) {
			int[] poll = monkey.poll();
			int y = poll[0];
			int x = poll[1];
			int k = poll[2];
			int d = poll[3];

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (-1 >= nx || nx >= c || -1 >= ny || ny >= r)
					continue;
				if (arr[ny][nx] == 0 && visit[k][ny][nx] == 0) {
					visit[k][ny][nx] = d + 1;
					monkey.add(new int[] { ny, nx, k, d + 1 });
				}
			}
			if (k < K) {
				for (int i = 0; i < 8; i++) {
					int ny = y + ky[i];
					int nx = x + kx[i];
					if (-1 >= nx || nx >= c || -1 >= ny || ny >= r)
						continue;
					if (arr[ny][nx] == 0 && visit[k + 1][ny][nx] == 0) {
						visit[k + 1][ny][nx] = d + 1;
						monkey.add(new int[] { ny, nx, k + 1, d + 1 });
					}
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= K; i++) {
			if (visit[i][r - 1][c - 1] > 0)
				ans = Math.min(visit[i][r - 1][c - 1], ans);
		}
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans - 1);
	}
}