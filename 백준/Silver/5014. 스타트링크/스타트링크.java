import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int F, S, G, U, D;
	static int list[];
	static Queue<Integer> q = new ArrayDeque<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken()); // 건물의 층 수
		S = Integer.parseInt(st.nextToken()) - 1; // 현재 있는 층
		G = Integer.parseInt(st.nextToken()) - 1; // 스타트링크가 있는 층
		U = Integer.parseInt(st.nextToken()); // 위로 U층을 가는 버튼
		D = Integer.parseInt(st.nextToken()); // 아래로 D층을 가는 버튼

		list = new int[F];

		bfs();

	}

	static void bfs() {
		q.offer(S);
		list[S] = 1;

		while (!q.isEmpty()) {
			S = q.poll();
			if (S - D >= 0 && list[S - D] == 0) {
				list[S - D] = list[S] + 1;
				q.offer(S - D);
			}
			if (S + U < F && list[S + U] == 0) {
				list[S + U] = list[S] + 1;
				q.offer(S + U);
			}

		}
		if (list[G] == 0) {
			System.out.println("use the stairs");
		} else {
			System.out.println(list[G] - 1);
		}

	}

}
