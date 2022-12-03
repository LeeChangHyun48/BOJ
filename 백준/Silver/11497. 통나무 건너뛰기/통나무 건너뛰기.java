import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] num = new int[N];

			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}

			Arrays.sort(num);

			int max = 0;

			if (N % 2 == 0) {
				max = num[1] - num[0];
				for (int i = 0; i < N - 2; i++) {
					max = Math.max(max, num[i + 2] - num[i]);
				}
				max = Math.max(max, num[N - 1] - num[N - 2]);

			} else {
				max = num[1] - num[0];
				for (int i = 0; i < N - 2; i++) {
					max = Math.max(max, num[i + 2] - num[i]);
				}
				max = Math.max(max, num[N - 1] - num[N - 2]);

			}

			System.out.println(max);

		}

	}

}
