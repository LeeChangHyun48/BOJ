
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] wheel = new int[4][8];
		
		// N극은 0, S극은 1
		for (int i = 0; i < 4; i++) {
			String st = sc.next();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = st.charAt(j) - '0';
			}
		}

		// 회전 횟수
		int k = sc.nextInt();
		int sum = 0;


		// 톱니바퀴를 회전 할때 극이 다르다면 B는 A가 회전한 방향과 반대방향으로 회전, 극이 같으면 회전하지 않는다
		for (int i = 0; i < k; i++) {
			int num = sc.nextInt(); // 회전시키는 톱니의 번호
			int dir = sc.nextInt(); // 1일 경우 시계방향, -1일 경우 반시계 방향
			int dirTemp[] = new int[4];
			sum = 0;
			dirTemp[num - 1] = dir;
			switch (num) {
			case 1: // 1 -> 2 -> 3 -> 4

				if (wheel[0][2] != wheel[1][6]) { // 1과 2의 극이 다를 경우 반대 회전
					dirTemp[1] = dirTemp[0] * -1;
				} else {
					dirTemp[1] = 0;
				}

				if (wheel[1][2] != wheel[2][6]) { // 2와 3의 극이 다를 경우 반대 회전
					dirTemp[2] = dirTemp[1] * -1;
				} else {
					dirTemp[2] = 0;
				}

				if (wheel[2][2] != wheel[3][6]) { // 3과 4의 극이 다를 경우 반대 회전
					dirTemp[3] = dirTemp[2] * -1;
				} else {
					dirTemp[3] = 0;
				}

				for (int j = 0; j < 4; j++) {
					if (dirTemp[j] == 0) {
						continue;
					}

					if (dirTemp[j] == 1) { // 시계 방향으로 회전
						int temp = wheel[j][7];

						for (int r = 7; r >= 1; r--) {
							wheel[j][r] = wheel[j][r - 1];
						}
						wheel[j][0] = temp;
					}

					else if (dirTemp[j] == -1) { // 반시계 방향으로 회전
						int temp = wheel[j][0];

						for (int r = 0; r < 7; r++) {
							wheel[j][r] = wheel[j][r + 1];
						}
						wheel[j][7] = temp;
					}
				}
				break;

			case 2: // 2 -> 3 -> 4 -> 1

				if (wheel[1][2] != wheel[2][6]) { // 2와 3의 극이 다를 경우 반대 회전
					dirTemp[2] = dirTemp[1] * -1;
				} else {
					dirTemp[2] = 0;
				}

				if (wheel[2][2] != wheel[3][6]) { // 3과 4의 극이 다를 경우 반대 회전
					dirTemp[3] = dirTemp[2] * -1;
				} else {
					dirTemp[3] = 0;
				}

				if (wheel[0][2] != wheel[1][6]) { // 1과 2의 극이 다를 경우 반대 회전
					dirTemp[0] = dirTemp[1] * -1;
				} else {
					dirTemp[0] = 0;
				}

				for (int j = 0; j < 4; j++) {
					if (dirTemp[j] == 0) {
						continue;
					}

					if (dirTemp[j] == 1) { // 시계 방향으로 회전
						int temp = wheel[j][7];

						for (int r = 7; r >= 1; r--) {
							wheel[j][r] = wheel[j][r - 1];
						}
						wheel[j][0] = temp;
					}

					else if (dirTemp[j] == -1) { // 반시계 방향으로 회전
						int temp = wheel[j][0];

						for (int r = 0; r < 7; r++) {
							wheel[j][r] = wheel[j][r + 1];
						}
						wheel[j][7] = temp;
					}
				}

				break;
			case 3: // 3 -> 4 -> 2 -> 1

				if (wheel[2][2] != wheel[3][6]) { // 3과 4의 극이 다를 경우 반대 회전
					dirTemp[3] = dirTemp[2] * -1;
				} else {
					dirTemp[3] = 0;
				}

				if (wheel[1][2] != wheel[2][6]) { // 3과 2의 극이 다를 경우 반대 회전
					dirTemp[1] = dirTemp[2] * -1;
				} else {
					dirTemp[1] = 0;
				}

				if (wheel[0][2] != wheel[1][6]) { // 2와 1의 극이 다를 경우 반대 회전
					dirTemp[0] = dirTemp[1] * -1;
				} else {
					dirTemp[0] = 0;
				}

				for (int j = 0; j < 4; j++) {
					if (dirTemp[j] == 0) {
						continue;
					}

					if (dirTemp[j] == 1) { // 시계 방향으로 회전
						int temp = wheel[j][7];

						for (int r = 7; r >= 1; r--) {
							wheel[j][r] = wheel[j][r - 1];
						}
						wheel[j][0] = temp;
					}

					else if (dirTemp[j] == -1) { // 반시계 방향으로 회전
						int temp = wheel[j][0];

						for (int r = 0; r < 7; r++) {
							wheel[j][r] = wheel[j][r + 1];
						}
						wheel[j][7] = temp;
					}
				}

				break;
			case 4: // 4 -> 3 -> 2 -> 1

				if (wheel[3][6] != wheel[2][2]) { // 4와 3의 극이 다를 경우 반대 회전
					dirTemp[2] = dirTemp[3] * -1;
				} else {
					dirTemp[2] = 0;
				}

				if (wheel[2][6] != wheel[1][2]) { // 3과 2의 극이 다를 경우 반대 회전
					dirTemp[1] = dirTemp[2] * -1;
				} else {
					dirTemp[1] = 0;
				}

				if (wheel[0][2] != wheel[1][6]) { // 2와 1의 극이 다를 경우 반대 회전
					dirTemp[0] = dirTemp[1] * -1;
				} else {
					dirTemp[0] = 0;
				}

				for (int j = 0; j < 4; j++) {
					if (dirTemp[j] == 0) {
						continue;
					}

					if (dirTemp[j] == 1) { // 시계 방향으로 회전
						int temp = wheel[j][7];

						for (int r = 7; r >= 1; r--) {
							wheel[j][r] = wheel[j][r - 1];
						}
						wheel[j][0] = temp;
					}

					else if (dirTemp[j] == -1) { // 반시계 방향으로 회전
						int temp = wheel[j][0];

						for (int r = 0; r < 7; r++) {
							wheel[j][r] = wheel[j][r + 1];
						}
						wheel[j][7] = temp;
					}
				}

				break;
			}

			
			if (wheel[0][0] == 1) {
				sum += 1;
			}
			if (wheel[1][0] == 1) {
				sum += 2;
			}
			if (wheel[2][0] == 1) {
				sum += 4;
			}
			if (wheel[3][0] == 1) {
				sum += 8;
			}

		}
		System.out.println(sum);

	}

}
