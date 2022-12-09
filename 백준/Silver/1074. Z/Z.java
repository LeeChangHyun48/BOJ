import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, N);
		test(r, c, size);
		System.out.println(cnt);
	}

	static int cnt;

	public static void test(int r, int c, int size) {
		if (size == 1) {
			return;
		}

		if (r < size / 2 && c < size / 2) { // 왼쪽 위
			cnt += size * size / 4 * 0;
			test(r, c, size / 2);
		} else if (r < size / 2 && c >= size / 2) { // 오른쪽 위
			cnt += size * size / 4 * 1;
			test(r, c - size / 2, size / 2);
		} else if (r >= size / 2 && c < size / 2) { // 왼쪽 아래
			cnt += size * size / 4 * 2;
			test(r - size / 2, c, size / 2);
		} else { // 오른쪽 아래
			cnt += size * size / 4 * 3;
			test(r - size / 2, c - size / 2, size / 2);
		}

	}

}
