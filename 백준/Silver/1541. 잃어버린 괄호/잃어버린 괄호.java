import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.next();

		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < st.length(); i++) {
			String temp = Character.toString(st.charAt(i)); // 문자열을 리스트에 넣기 위한 작업
			String num = "";
			for (; i < st.length(); i++) {
				temp = Character.toString(st.charAt(i));
				if (temp.equals("+") || temp.equals("-")) {
					break;
				}
				num += temp; // + or - 가 나오기 전까지 한자리씩 입력되는 숫자들을 합쳐준다.
			}
			arr.add(num); // 리스트에 삽입
			if (i == st.length()) { // 마지막 숫자가 한번더 들어가는것을 방지
				break;
			}
			arr.add(temp); // + or - 의 연산도 리스트에 삽입
		}

		for (int i = 0; i < arr.size(); i++) {
			if (!arr.get(i).equals("-")) { // - 가 나오기 전에
				int n = 0;
				for (; i < arr.size(); i++) {
					if (arr.get(i).equals("+")) {
						continue;
					} else if (arr.get(i).equals("-")) { // - 가 나오면 반복문을 멈춘다.
						i -= 1;
						break;
					}
					n += Integer.parseInt(arr.get(i)); // -가 나오기 전까지 계속 n에 숫자들을 더해준다.
				}
				String t = String.valueOf(n);
				list.add(t); // 리스트에 더해준 n의 값을 문자열로 삽입

			} else {
				list.add("-"); // 리스트에 - 값도 삽입
			}
		}

		int ans = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("-")) { // - 가 나오면 리스트에 입력된 숫자를 빼준다.
				i += 1;
				ans -= Integer.parseInt(list.get(i));
				continue;
			}
			ans += Integer.parseInt(list.get(i)); // -가 나오기 전까지 리스트들의 숫자들을 더해준다.

		}

//		System.out.println(arr);
//		System.out.println(list);
		System.out.println(ans);
	}

}
