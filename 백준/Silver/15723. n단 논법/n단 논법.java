import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int size = 26;
		int n = Integer.parseInt(st.nextToken());

		int arr[][] = new int[size + 1][size + 1];
		int INF = 999999999;

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				arr[i][j] = INF;
				if (i == j) {
					arr[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			String input = br.readLine();

			int a = input.charAt(0) - 96;
			int b = input.charAt(5) - 96;

			arr[a][b] = 1;

		}

		for (int k = 1; k <= size; k++) {
			for (int i = 1; i <= size; i++) {
				for (int j = 1; j <= size; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			String input = br.readLine();

			int a = input.charAt(0) - 96;
			int b = input.charAt(5) - 96;

			if (arr[a][b] != INF) {
				System.out.println("T");
			} else {
				System.out.println("F");
			}
		}

	}

}
