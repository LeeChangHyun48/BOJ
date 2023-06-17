import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 길이
		int K = Integer.parseInt(st.nextToken()); // 내구도가 0인 칸의 개수

		int list[] = new int[N * 2]; // 컨베이어 벨트가 위아래로 있기떄문에 *2
		boolean check[] = new boolean[N * 2]; // 로봇을 확인하기 위한 배열

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N * 2; i++) {

			list[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;

		while (true) {
			result += 1;

			int temp = list[N * 2 - 1];
			for (int i = N * 2 - 1; i > 0; i--) { // 컨베이어 벨트 이동
				list[i] = list[i - 1];
				check[i] = check[i - 1];
			}

			list[0] = temp;
			check[0] = false;

			if (check[N - 1]) { // 컨베이어 벨트 마지막에 도달하면 로봇 제거
				check[N - 1] = false;
			}

			for (int i = N - 1; i >= 0; i--) {
				if (check[i] && list[i + 1] > 0 && !check[i + 1]) {
					// 현재 위치의 로봇이 있고 다음 칸의 벨트의 내구도가 0보다 크며 다음 위치의 로못이 없을 때
					list[i + 1] -= 1;
					check[i] = false;
					check[i + 1] = true;
				}
			}

			if (list[0] > 0 && !check[0]) { // 로봇 올리기
				list[0] -= 1;
				check[0] = true;
			}

			if (check[N - 1]) { // 컨베이어 벨트 마지막에 도달하면 로봇 제거
				check[N - 1] = false;
			}

			int cnt = 0;
			for (int i = 0; i < N * 2; i++) { // 내구도 검사
				if (list[i] == 0) {
					cnt += 1;
				}
				if (cnt >= K) {
					break;
				}
			}
			if (cnt >= K) {
				break;
			}

		}

		System.out.println(result);

	}

}
