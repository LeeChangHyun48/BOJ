import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String st = sc.next(); // 문자열 입력

			if (st.equals("0")) { // 0이 입력되면 종료
				break;
			}

			if (st.length() % 2 == 0) { // 문자열의 길이가 짝수 일때
				int j = st.length() - 1;
				int cnt = 0;

				for (int i = 0; i < st.length() / 2; i++) {
					if (st.charAt(i) != st.charAt(j)) {
						System.out.println("no");
						break;
					}
					j -= 1;
					cnt += 1;
				}

				if (cnt == st.length() / 2) {
					System.out.println("yes");
				}

			} else { // 문자열의 길이가 홀수 일때
				int j = st.length() - 1;
				int cnt = 0;

				for (int i = 0; i < st.length() / 2; i++) {
					if (st.charAt(i) != st.charAt(j)) {
						System.out.println("no");
						break;
					}
					j -= 1;
					cnt += 1;
				}
				if (cnt == st.length() / 2) {
					System.out.println("yes");
				}

			}

		}

	}

}
