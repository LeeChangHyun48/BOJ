import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String gin = sc.next();

		int N = sc.nextInt();
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			String input = sc.next();

			if (gin.equals(input)) {
				cnt += 1;
			}
		}

		System.out.println(cnt);

	}

}
