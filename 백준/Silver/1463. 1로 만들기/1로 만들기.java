import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = sc.nextInt();

		int[] D = new int[ans + 1];

		D[1] = 0;

		for (int i = 2; i <= ans; i++) {
			D[i] = D[i - 1] + 1;

			if (i % 2 == 0) {
				D[i] = Math.min(D[i], D[i / 2] + 1);
			}
			if (i % 3 == 0) {
				D[i] = Math.min(D[i], D[i / 3] + 1);
			}

		}
		System.out.println(D[ans]);

	}

}
