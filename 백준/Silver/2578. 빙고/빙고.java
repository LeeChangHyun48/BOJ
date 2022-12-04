import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = 5;

		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 25; i++) {
			int ans = sc.nextInt();

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][k] == ans) {
						visited[j][k] = true;
					}
				}
			}
			int cnt = 0;

			if (i >= 10) {
				for (int j = 0; j < N; j++) { // 가로가 빙고일때
					int bingo = 0;
					for (int k = 0; k < N; k++) {
						if (visited[j][k] == true) {
							bingo++;
						}
					}
					if (bingo == 5) {
						cnt++;
					}
				}

				for (int j = 0; j < N; j++) { // 세로가 빙고일때
					int bingo = 0;
					for (int k = 0; k < N; k++) {
						if (visited[k][j] == true) {
							bingo++;
						}
					}
					if (bingo == 5) {
						cnt++;
					}
				}

				int bingo = 0;
				for (int j = 0; j < N; j++) { // 우측 대각선 빙고일때
					if (visited[j][j] == true) {
						bingo++;
					}
				}
				if (bingo == 5) {
					cnt++;
				}

				bingo = 0;
				for (int j = 0; j < N; j++) { // 좌측 대각선 빙고일때
					if (visited[j][4 - j]) {
						bingo++;
					}
				}
				if (bingo == 5) {
					cnt++;
				}

			}

			if (cnt >= 3) {
				System.out.println(i + 1);
				break;
			}

		}

	}

}
