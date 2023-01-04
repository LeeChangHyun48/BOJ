import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		Queue<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> h = new ArrayList<Integer>();
		
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		for (int i = 0; i < N; i++) { // 맵 입력
			String st = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j) - '0';
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (visited[y][x] == false && map[y][x] == 1) { // 1일때 queue에 좌표 저장

					queue.offer(y);
					queue.offer(x);

					visited[y][x] = true; // 1인 좌표 true로 처리
					int cnt = 1;

					while (!queue.isEmpty()) {
						int r = queue.poll();
						int c = queue.poll();

						for (int d = 0; d < 4; d++) { // 사방탐색
							int nr = r + dy[d];
							int nc = c + dx[d];

							if (0 <= nr && nr < N && 0 <= nc && nc < N) {
								if (visited[nr][nc] == false && map[nr][nc] == 1) {
									visited[nr][nc] = true; // 1인 곳을 true 처리
									cnt += 1;
									queue.offer(nr);
									queue.offer(nc);
								}

							}
						}
					}
					h.add(cnt);

				}

			}
		}

		Collections.sort(h);
		System.out.println(h.size());
		for (int i : h) {
			System.out.println(i);
		}

	}

}
