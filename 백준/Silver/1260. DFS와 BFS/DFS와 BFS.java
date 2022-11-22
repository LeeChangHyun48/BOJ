import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, V;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 정점 수
		M = sc.nextInt(); // 간선 수
		V = sc.nextInt(); // 시작할 정점의 번호

		int[][] adjMatrix = new int[1001][1001]; // 정점수 크기로 생성

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			// 무향이므로 간선 하나로 양방향 처리
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
		
		dfs(adjMatrix, new boolean[1001], V);
		System.out.println();
		bfs(adjMatrix, V);
		
		

	}

	public static void bfs(int[][] adjMatrix, int start) {

		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[1001];

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+" ");

			// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
			for (int j = 0; j <= N; j++) {
				if (!visited[j] && adjMatrix[current][j] != 0) {
					queue.offer(j);
					visited[j] = true;
				}
			}

		}

	}

	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;
		System.out.print(current+" ");

		for (int j = 0; j <= N; j++) {
			if (!visited[j] && adjMatrix[current][j] != 0) {
				dfs(adjMatrix, visited, j);
			}
		}

	}
}