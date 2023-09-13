import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();
		int INF = 99999999;

		int map[][] = new int[V + 1][V + 1];

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				map[i][j] = INF;
				if (i == j) {
					map[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < E; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();

			map[x][y] = w;
		}

		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}

			}
		}

		int min = INF;

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (map[i][j] != INF && map[j][i] != INF && map[i][j] != 0 && map[j][i] != 0) {
					min = Math.min(min, map[i][j] + map[j][i]);
				}
			}

		}

		if (min == INF) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}

}
