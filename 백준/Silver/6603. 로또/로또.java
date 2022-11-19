import java.util.Scanner;

public class Main {
	static int k;
	static int[] list;
	static int[] lotto = new int[6];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			k = sc.nextInt();

			if (k == 0) {
				break;
			}

			list = new int[k];

			for (int i = 0; i < k; i++) {
				list[i] = sc.nextInt();
			}
			
			comb(0, 0);
			System.out.println();
		}

	}

	public static void comb(int idx, int t) {
		if (t == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(lotto[i] + " ");
			}
			System.out.println();
			return;
		}

		if (idx == list.length) {
			return;
		}

		lotto[t] = list[idx];
		comb(idx + 1, t + 1);
		comb(idx + 1, t);

	}

}
