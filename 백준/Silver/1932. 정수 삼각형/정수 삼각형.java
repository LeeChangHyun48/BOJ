import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int tg[][] = new int[N][N];

		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				tg[i][j] = sc.nextInt();
			}
		}

		if (N == 1) {
			System.out.println(tg[0][0]);
		} else {

			tg[1][0] = tg[0][0] + tg[1][0];
			tg[1][1] = tg[0][0] + tg[1][1];

			for (int i = 2; i < N; i++) {
				for (int j = 0; j < i + 1; j++) {
					if (j == 0) {
						tg[i][j] = tg[i - 1][j] + tg[i][j];
					} else if (j > 0 && j < i) {
						tg[i][j] = Math.max(tg[i - 1][j - 1], tg[i - 1][j]) + tg[i][j];
					} else {
						tg[i][j] = tg[i - 1][j - 1] + tg[i][j];
					}

					if (i == N - 1) {
						max = Math.max(tg[i][j], max);
					}

				}
			}

			System.out.println(max);
		}

	}

}
