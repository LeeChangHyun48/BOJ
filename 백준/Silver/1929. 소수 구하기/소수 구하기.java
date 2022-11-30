import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt(); // 시작 수
		int N = sc.nextInt(); // 마지막 수

		boolean list[] = new boolean[N + 1];

		list[0] = true;
		list[1] = true;

		for (int i = 2; i < list.length; i++) { 
			if (list[i]) { // true 값이면 넘어감
				continue;
			}

			for (int j = 2 * i; j < list.length; j += i) { // 2, 3, 4 ... 배수를 true 로 바꾼다
				list[j] = true;
			}
		}

		for (int i = M; i < list.length; i++) { // 시작 수 부터 진행
			if (!list[i]) {
				System.out.println(i);
			}
		}

	}

}
