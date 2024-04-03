import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == 0 || b == 0 || c == 0) {
				break;
			}

			if (a == b && a == c) {
				System.out.println("Equilateral");
				continue;
			}

			int cnt = 0;

			if (a == b) {
				cnt += 1;
			}
			if (b == c) {
				cnt += 1;
			}
			if (c == a) {
				cnt += 1;
			}

			int ab = a + b;
			int ac = a + c;
			int bc = b + c;

			int min = Math.min(Math.min(ab, ac), bc);
			int max = Math.max(Math.max(a, b), c);

			if (min > max) {
				if (cnt == 1) {
					System.out.println("Isosceles");
					continue;
				}

				System.out.println("Scalene");
			} else {
				System.out.println("Invalid");
			}

		}

	}

}
