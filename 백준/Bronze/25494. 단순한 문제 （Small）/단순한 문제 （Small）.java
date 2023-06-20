import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			int cnt = 0;

			for (int x = 1; x <= a; x++) {
				for (int y = 1; y <= b; y++) {
					for (int z = 1; z <= c; z++) {
						if (x % y == y % z && y % z == z % x) {
							cnt += 1;
						}
					}
				}
			}
			
			System.out.println(cnt);

		}

	}

}
