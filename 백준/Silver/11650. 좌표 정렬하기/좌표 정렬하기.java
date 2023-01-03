import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int list[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			list[i][0] = sc.nextInt();
			list[i][1] = sc.nextInt();
		}

		Arrays.sort(list, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});

		for (int i = 0; i < N; i++) {
			System.out.println(list[i][0] + " " + list[i][1]);
		}

	}

}
