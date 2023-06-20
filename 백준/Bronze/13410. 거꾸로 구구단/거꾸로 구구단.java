import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		int max = 0;

		for (int i = 1; i <= K; i++) {
			int result = N * i;

			int temp = 0;
			while (result != 0) {
				temp = temp * 10 + result % 10;
				result /= 10;
			}

			max = Math.max(max, temp);

		}
		System.out.println(max);

	}

}
