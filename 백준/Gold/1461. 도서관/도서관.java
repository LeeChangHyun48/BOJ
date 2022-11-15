import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int max = 0;

		ArrayList<Integer> plus = new ArrayList<Integer>();
		ArrayList<Integer> minus = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			max = Math.max(max, Math.abs(input)); // 최대값 구하기
			if (input > 0) {
				plus.add(input);
			} else {
				minus.add(Math.abs(input));
			}
		}

		// 내림차순 정렬
		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus, Collections.reverseOrder());

		int ans = 0;

		for (int i = 0; i < plus.size(); i++) {
			if (i % M == 0) {
				ans += plus.get(i) * 2;
			}
		}

		for (int i = 0; i < minus.size(); i++) {
			if (i % M == 0) {
				ans += minus.get(i) * 2;
			}
		}

		System.out.println(ans - max);

	}

}
