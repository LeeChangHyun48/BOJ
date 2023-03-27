import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		boolean map[][] = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				char ch = str.charAt(j);
				if (ch == 'W') {
					map[i][j] = false;
				} else {
					map[i][j] = true;
				}
			}
		}

		boolean wMap[][] = new boolean[8][8];
		boolean bMap[][] = new boolean[8][8];
		boolean W = false;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				wMap[i][j] = W;
				if (j % 2 != 0) {
					wMap[i][j] = !W;
				}
				bMap[i][j] = !W;
				if (j % 2 != 0) {
					bMap[i][j] = W;
				}
			}
			W = !W;
		}

		int min = 9999;

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int wCnt = 0;
				int bCnt = 0;
				for (int y = i; y < i + 8; y++) {
					for (int x = j; x < j + 8; x++) {
						if (map[y][x] != wMap[y - i][x - j]) {
							wCnt += 1;
						}
						if (map[y][x] != bMap[y - i][x - j]) {
							bCnt += 1;
						}

					}

				}

				min = Math.min(min, Math.min(wCnt, bCnt));
			}

		}
		System.out.println(min);

	}
}
