import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int list[] = new int[N];
			for(int i = 0; i < N; i++) {
				list[i] = sc.nextInt();
			}
			
			long temp = 0;
			long sum = 0;

			for (int i = N - 2; i >= 0; i--) {
				if (list[N - 1] > list[i]) {
					temp = list[N - 1] - list[i];
					sum += temp;
				} else {
					list[N - 1] = list[i];
				}
			}
			
			System.out.println(sum);
		}

	}

}
