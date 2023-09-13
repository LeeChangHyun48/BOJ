import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int arr[][] = new int[N + 1][N + 1];

		int list[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = 9999999;
				if (i == j) {
					arr[i][j] = 0;
				}
			}
		}

		while (true) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x == -1 && y == -1) {
				break;
			}

			arr[x][y] = 1;
			arr[y][x] = 1;

		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}

		int min = 9999999;

		for (int i = 1; i <= N; i++) {
			int max = 0;
			for (int j = 1; j <= N; j++) {
				max = Math.max(max, arr[i][j]);
			}
			list[i] = max;
			min = Math.min(min, max);
		}

		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			if (list[i] == min) {
				cnt += 1;
			}
		}

		System.out.println(min + " " + cnt);

		for (int i = 1; i <= N; i++) {
			if (list[i] == min) {
				System.out.print(i + " ");
			}
		}

	}

}
