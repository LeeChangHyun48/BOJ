import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int C = sc.nextInt();

			int res = N / C;
			int check = N % C;

			if (check > 0) {
				System.out.println(res + 1);
			} else {
				System.out.println(res);
			}

		}

	}

}
