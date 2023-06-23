import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int check = 0;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			if (check == 0 && arr[i] == 0) {
				cnt += 1;
				check += 1;
			} else if (check == 1 && arr[i] == 1) {
				cnt += 1;
				check += 1;
			} else if (check == 2 && arr[i] == 2) {
				cnt += 1;
				check = 0;
			}
		}

		System.out.println(cnt);

	}

}
