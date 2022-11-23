import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine()); // 테스트 케이스 수 입력

		for (int tc = 0; tc < T; tc++) { // 테스트 케이스 만큼 반복

			int k = Integer.parseInt(bf.readLine());

			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());

				String id = st.nextToken();
				int n = Integer.parseInt(st.nextToken());

				if (id.equals("I")) { // id 문자가 I로 들어오면 정수 입력
					if (map.containsKey(n)) {
						map.put(n, map.get(n) + 1);
					} else {
						map.put(n, 1);
					}
				} else { // id 문자가 D로 들어오는 경우
					if (map.isEmpty()) { // map이 비어있음 넘어감
						continue;
					} else if (n == 1) { // id 문자가 D로 들어온 경우 +1면 최댓값 삭제 -1면 최솟값 삭제
						if (map.get(map.lastKey()) == 1) { // 중복되는 수가 없으니 감소 후 최대값 삭제
							map.remove(map.lastKey());
						} else { // 중복되는 수 일 경우 value 값을 -1 해주고 입력
							map.put(map.lastKey(), map.get(map.lastKey()) - 1);
						}

					} else {
						if (map.get(map.firstKey()) == 1) {
							map.remove(map.firstKey());
						} else {
							map.put(map.firstKey(), map.get(map.firstKey()) - 1);
						}

					}
				}
			}

			if (map.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}

		}

	}

}
