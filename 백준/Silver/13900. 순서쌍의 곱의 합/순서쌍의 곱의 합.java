import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		long arr[] = new long[N];
		long arr_sum[] = new long[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			arr_sum[i] = arr_sum[i - 1] + arr[i - 1];
		}

		long sum = 0;

		for (int i = 1; i <= N; i++) {
			sum += arr[i - 1] * arr_sum[i - 1];
		}

		System.out.println(sum);

	}

}
