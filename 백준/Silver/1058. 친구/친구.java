import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int arr[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = 9999999;

				if (i == j) {
					arr[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			String st = sc.next();
			for (int j = 0; j < N; j++) {
				if (st.charAt(j) == 'Y') {
					arr[i][j] = 1;
					arr[j][i] = 1;
				}

			}

		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}

		int ans = 0;

		for (int i = 0; i < N; i++) {
			int max = 0;

			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				} else if (arr[i][j] <= 2) {
					max += 1;
				}
			}

			ans = Math.max(ans, max);
		}

		System.out.println(ans);
	}

}
