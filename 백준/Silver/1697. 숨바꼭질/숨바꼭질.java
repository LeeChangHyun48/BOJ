import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static Queue<Integer> queue = new ArrayDeque<Integer>();
	static int N, K;
	static int[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		visit = new int[100001];

		if (N == K) {
			System.out.println(0);
		} else {

			bfs(N);
		}

	}

	static void bfs(int n) {

		queue.offer(n);
		visit[n] = 1;

		while (!queue.isEmpty()) {
			n = queue.poll();

			if (n - 1 >= 0 && visit[n - 1] == 0) { // 방문하지 않았으면 수빈이의 위치 n - 1로 이동
				visit[n - 1] = visit[n] + 1;
				queue.offer(n - 1);
			}

			if (n + 1 < 100001 && visit[n + 1] == 0) { // 방문하지 않았으면 수빈이의 위치 n + 1로 이동
				visit[n + 1] = visit[n] + 1;
				queue.offer(n + 1);
			}

			if (n * 2 < 100001 && visit[n * 2] == 0) { // 방문하지 않았으면 수빈이의 위치 n * 2로 이동
				visit[n * 2] = visit[n] + 1;
				queue.offer(n * 2);
			}

		}

		System.out.println(visit[K] - 1);

	}

}
