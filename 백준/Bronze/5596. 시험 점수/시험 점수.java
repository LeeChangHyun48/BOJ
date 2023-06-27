import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int max = 0;

		for (int i = 0; i < 2; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();

			int result = a + b + c + d;

			max = Math.max(max, result);

		}

		System.out.println(max);
	}

}
