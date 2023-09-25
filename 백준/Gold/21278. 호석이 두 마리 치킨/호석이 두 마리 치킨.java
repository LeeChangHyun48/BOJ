import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int arr[][] = new int[N + 1][N + 1];

		int INF = 99999999;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = INF;
				if (i == j) {
					arr[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}

		int min = INF;
		int cA = 0;
		int cB = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				int sum = 0;
				for (int k = 1; k <= N; k++) {
					sum += Math.min(arr[i][k], arr[j][k]);
				}

				if (min > sum) {
					min = sum;
					cA = i;
					cB = j;
				}
			}

		}

		System.out.println(cA + " " + cB + " " + min * 2);
	}

}
