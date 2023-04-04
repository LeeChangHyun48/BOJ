import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int n, m, f, s, cnt;
	static int[][] adj;
	static boolean[] visit;
	static boolean check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		f = sc.nextInt();
		s = sc.nextInt();

		m = sc.nextInt();

		adj = new int[n + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			adj[x][y] = adj[y][x] = 1;
		}

		bfs();

		if (check) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}

	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { f, cnt });
		visit = new boolean[n + 1];
		visit[f] = true;
		check = false;

		while (!queue.isEmpty()) {
			int x = queue.peek()[0];
			cnt = queue.poll()[1];
			if (x == s) {
				check = true;
				break;
			}
			for (int i = 1; i <= n; i++) {
				if (visit[i] || adj[x][i] == 0) {
					continue;
				}
				queue.offer(new int[] { i, cnt + 1 });
				visit[i] = true;

			}

		}

	}

}
