import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int arr[] = new int[N];
		int arr_sum[] = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 1; i <= N; i++) {
			arr_sum[i] = arr_sum[i - 1] + arr[i - 1];
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			System.out.println(arr_sum[b] - arr_sum[a - 1]);
		}
	}

}
