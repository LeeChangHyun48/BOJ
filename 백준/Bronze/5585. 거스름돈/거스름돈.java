import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int coin[] = { 500, 100, 50, 10, 5, 1 };
		int d = 1000 - n;
		int cnt = 0;

		for (int i = 0; i < 6; i++) {
			if (d / coin[i] > 0) {
				cnt += d / coin[i];
				d = d % coin[i];
			}
		}

		System.out.println(cnt);

	}

}
