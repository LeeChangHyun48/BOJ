import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 그려진 지도 외 사방이 바다임으로 + 2를 해준다.
		int R = sc.nextInt() + 2;
		int C = sc.nextInt() + 2;

		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		char[][] map = new char[R][C];
		boolean[][] visit = new boolean[R][C];

		for (int i = 0; i < R; i++) { // 맵을 전체 . 으로 초기화한다.
			for (int j = 0; j < C; j++) {
				map[i][j] = '.';
			}
		}

		for (int i = 1; i < R - 1; i++) { // 맵 입력
			String st = sc.next();
			for (int j = 1; j < C - 1; j++) {
				map[i][j] = st.charAt(j - 1);
			}
		}

		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				if (map[y][x] == 'X' && visit[y][x] == false) { // 해당 좌표가 X이면서 방문하지 않은 곳
					int cnt = 0;
					for (int d = 0; d < 4; d++) { // 사방탐색
						int ny = y + dy[d];
						int nx = x + dx[d];
						if (ny >= 0 && nx >= 0 && ny < R && nx < C && map[ny][nx] == '.' && !visit[ny][nx]) {
							// 사방탐색을 하였을때 .이면서 방문하지 않은 곳 일때 cnt++
							cnt++;
						}
						visit[y][x] = true; // 방문한 해당 좌표를 ture로 바꿈
					}
					if (cnt >= 3) { // 사방탐색으로 방문한 곳의 갯수가 3이상일때 X를 .으로 바꿈
						map[y][x] = '.';
					}
				}
			}
		}
		
		// 지도를 새로 그리기 위해 Y와 X의 최소값 최대값 좌표를 구한다.
		int minY = R;
		int minX = C;
		int maxY = 0;
		int maxX = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'X') { // X인 좌표 기준으로 최소값 최대값를 구한다.
					minY = Math.min(i, minY);
					minX = Math.min(j, minX);
					maxY = Math.max(i, maxY);
					maxX = Math.max(j, maxX);
				}
			}
		}

		for (int i = minY; i <= maxY; i++) {
			for (int j = minX; j <= maxX; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

}
