import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", next=" + next + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); // 정점 갯수
		int E = Integer.parseInt(st.nextToken()); // 간선 갯수
		
		final int INFINITY = Integer.MAX_VALUE;

		Node[] adjList = new Node[V];
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];

		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(in.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}

		Arrays.fill(distance, INFINITY);
		
		st = new StringTokenizer(in.readLine().trim(), " ");
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1; // 도착점 인덱스
		
		distance[start] = 0;

		int min = 0, current = 0;
		for (int i = 0; i < V; ++i) {
			// a단계 : 출발지에서 가까운 정점을 선택한다.
			min = INFINITY;
			for (int j = 0; j < V; ++j) {
				if (!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true; // 선택 정점 방문 처리
			if (current == end)
				break;// 선택 정점이 도착정점이면 탈출.만약,탈출하지 않고 계속 하면 출발지로부터 모든 정점 각각까지 도착하는 최소거리비용이 다 계산됨.

			// b단계: 출발지에서 가까운 current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for (Node temp = adjList[current]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && distance[temp.vertex] > min + temp.weight) {
					distance[temp.vertex] = min + temp.weight;
				}
			}
		}
		System.out.println(distance[end]);
	}

}
