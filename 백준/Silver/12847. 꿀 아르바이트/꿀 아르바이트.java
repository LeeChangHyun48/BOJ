import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long arr[] = new long[n];
		long arr_sum[] = new long[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			arr_sum[i] = arr[i - 1] + arr_sum[i - 1];
		}

		long max = 0;

		for (int i = m; i <= n; i++) {
			max = Math.max(max, arr_sum[i] - arr_sum[i - m]);
		}

		System.out.println(max);

	}

}
