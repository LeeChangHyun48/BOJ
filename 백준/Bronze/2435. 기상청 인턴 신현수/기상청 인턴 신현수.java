import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int arr[] = new int[N];
		int arr_sum[] = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			arr_sum[i] = arr[i - 1] + arr_sum[i - 1];
		}

		int max = -999999999;

		for (int i = K; i <= N; i++) {
			max = Math.max(max, arr_sum[i] - arr_sum[i - K]);
		}

		System.out.println(max);

	}

}
