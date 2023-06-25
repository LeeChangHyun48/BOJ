import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			int b = 0;
			int d = 0;
			for (int j = 0; j < 4; j++) {
				int input = sc.nextInt();
				if (input == 0) {
					b += 1;
				} else {
					d += 1;
				}
			}
			if (b == 1 && d == 3) {
				System.out.println("A");
			} else if (b == 2 && d == 2) {
				System.out.println("B");
			} else if (b == 3 && d == 1) {
				System.out.println("C");
			} else if (b == 4 && d == 0) {
				System.out.println("D");
			} else {
				System.out.println("E");
			}

		}

	}

}
