
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<Integer>();

		double sum = 0;

		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			sum += input;
			list.add(input);

		}

		Collections.sort(list);

		System.out.println(Math.round(sum / N)); // 산술평균 출력 소수점 첫째 자리 반올림 출력
		System.out.println(list.get(N / 2)); // 중앙값을 출력

		int mode[] = new int[N];

		int temp = list.get(0);
		int idx = 0;

		// 최빈값 계산
		for (int i = 1; i < N; i++) {
			if (temp == list.get(i)) {
				mode[idx] += 1;
				continue;
			}

			temp = list.get(i);
			idx += 1;
		}

		// 리스트 중복 제거
		List<Object> newList = list.stream().distinct().collect(Collectors.toList());

		// 최빈값 중 가장 높은 수 찾기
		int m = 0;

		for (int i = 0; i < N; i++) {
			m = Math.max(m, mode[i]);
		}

		int cnt = 0;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (m == mode[i]) {
				ans = (Integer) newList.get(i);
				cnt += 1;
			}
			if (cnt == 2) {
				break;
			}
		}

		System.out.println(ans);

//		System.out.println(m);

		int min = list.get(0);
		int max = list.get(N - 1);

		// 범위를 출력
		if (min < 0 && max >= 0) { // 최솟값이 음수일 경우 양수로 변경 후 합한 결과 출력
			min = -1 * min;
			System.out.println(min + max);
		} else if (min < 0 && max < 0) { // 최솟값과 최대값 둘다 음수 일 경우 양수로 변환후 뺀 결과 출력
			min = -1 * min;
			max = -1 * max;

			System.out.println(min - max);
		} else { // 최솟값과 최대값 둘다 양수 일 경우 최댓값과 최솟값을 뺀 결과 출력
			System.out.println(max - min);
		}

	}

}
