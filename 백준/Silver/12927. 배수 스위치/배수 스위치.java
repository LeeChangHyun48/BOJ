import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Character> sw = new ArrayList<Character>();
		String st = sc.next();
		sw.add('N');
		for (int i = 1; i < st.length() + 1; i++) {
			sw.add(st.charAt(i - 1));
		}

		int cnt = 0;

		for (int i = 1; i < sw.size(); i++) {
			if (sw.get(i) == 'N') { // 스위치가 꺼저있을 경우 통과
				continue;
			} 
			for (int j = i; j < sw.size(); j += i) { // 스위치가 켜져있을 경우
				if (sw.get(j) == 'N') {
					sw.set(j, 'Y');
				} else if (sw.get(j) == 'Y') {
					sw.set(j, 'N');
				}
			}
			cnt++;

		}

		if (sw.contains('Y')) {
			System.out.println("-1");
		} else {
			System.out.println(cnt);
		}

	}

}
