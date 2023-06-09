import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int tc, n, r, c, gr, gc, cnt;
	static int board[][];
	static boolean visit[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		tc = sc.nextInt(); // 테스트 케이스 입력

		for (int t = 0; t < tc; t++) {
			n = sc.nextInt(); // 체스판의 크기 n * n

			board = new int[n][n];
			visit = new boolean[n][n];

			for (int i = 0; i < n; i++) { // 보드를 0으로 채우기
				Arrays.fill(board[i], 0);
			}

			r = sc.nextInt(); // 나이트의 좌표
			c = sc.nextInt();

			gr = sc.nextInt(); // 이동하려는 목표의 좌표
			gc = sc.nextInt();

			bfs(r, c);

		}

	}

	static int dy[] = { -1, 1, 2, 2, 1, -1, -2, -2 }; // 나이트가 이동가능한 좌표
	static int dx[] = { -2, -2, -1, 1, 2, 2, 1, -1 };

	private static void bfs(int r1, int c1) {
		Queue<int[]> queue = new LinkedList<int[]>();

		visit[r1][c1] = true;
		queue.add(new int[] { r1, c1 });

		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.poll()[1];

			if (gr == y && gc == x) {
				System.out.println(board[y][x]);
				return;
			}

			for (int d = 0; d < 8; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || nx < 0 || ny >= n || nx >= n || visit[ny][nx]) {
					continue;
				}

				queue.add(new int[] { ny, nx });
				visit[ny][nx] = true;
				board[ny][nx] = board[y][x] + 1;

			}

		}

	}

}
