import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int arr[] = new int[10];
		int arr_sum[] = new int[11];

		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i <= 10; i++) {
			arr_sum[i] = arr_sum[i - 1] + arr[i - 1];
		}

		boolean check = false;

		for (int i = 1; i <= 10; i++) {
			if (arr_sum[i] == 100) {
				System.out.println(arr_sum[i]);
				check = true;
				break;
			} else if (arr_sum[i] > 100) {
				int a = arr_sum[i] - 100;
				int b = 100 - arr_sum[i - 1];

				if (a <= b) {
					System.out.println(arr_sum[i]);
					check = true;
					break;
				} else {
					System.out.println(arr_sum[i - 1]);
					check = true;
					break;
				}
			}

		}
		if (!check) {
			System.out.println(arr_sum[10]);
		}

	}

}
