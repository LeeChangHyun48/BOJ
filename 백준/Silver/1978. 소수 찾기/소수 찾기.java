import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int ans = 0;

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			int cnt = 0;

			if (num == 1) {
				continue;
			}

			for (int j = 1; j <= num; j++) {
				if (num % j == 0) {
					cnt += 1;
				}
			}

			if (cnt == 2) {
				ans += 1;
			}

		}

		System.out.println(ans);

	}

}
