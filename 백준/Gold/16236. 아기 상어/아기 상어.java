import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int map[][];
	static int dx[] = { -1, 0, 0, 1 };
	static int dy[] = { 0, -1, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		Queue<Node> queue = new LinkedList<Node>();
		Node shark = null;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) { // 상어의 처음 위치
					shark = new Node(i, j);
					map[i][j] = 0; // 상어의 처음 위치 초기화
				}
			}
		}

		int size = 2; // 상어의 초기 크기
		int cnt = 0;
		int ans = 0;

		while (true) {
			int x = Integer.MAX_VALUE;
			int y = Integer.MAX_VALUE;
			int d = Integer.MAX_VALUE;

			int[][] dist = new int[N][N];

			queue.add(new Node(shark.x, shark.y));

			while (!queue.isEmpty()) {
				Node cur = queue.poll();

				for (int k = 0; k < 4; k++) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					if (map[nx][ny] > size)
						continue;
					if (dist[nx][ny] != 0)
						continue;

					dist[nx][ny] = dist[cur.x][cur.y] + 1;

					if (map[nx][ny] != 0 && map[nx][ny] < size) {
						if (d > dist[nx][ny]) {
							d = dist[nx][ny];
							x = nx;
							y = ny;
						} else if (d == dist[nx][ny]) {
							if (nx == x) {
								if (y > ny) {
									x = nx;
									y = ny;
								}
							} else if (nx < x) {
								x = nx;
								y = ny;
							}
						}
					}

					queue.add(new Node(nx, ny));
				}
			}

			if (x == Integer.MAX_VALUE && y == Integer.MAX_VALUE) {
				break;
			}

			ans += dist[x][y];
			map[x][y] = 0;

			shark.x = x;
			shark.y = y;

			cnt++;

			if (cnt == size) {
				size++;
				cnt = 0;
			}
		}

		System.out.println(ans);
	}

	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}