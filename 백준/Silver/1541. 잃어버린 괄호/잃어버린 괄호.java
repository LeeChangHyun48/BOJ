import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.next();

		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < st.length(); i++) {
			String temp = Character.toString(st.charAt(i));
			String num = "";
			for (; i < st.length(); i++) {
				temp = Character.toString(st.charAt(i));
				if (temp.equals("+") || temp.equals("-")) {
					break;
				}
				num += temp;
			}
			arr.add(num);
			if (i == st.length()) {
				break;
			}
			arr.add(temp);
		}

		for (int i = 0; i < arr.size(); i++) {
			if (!arr.get(i).equals("-")) {
				int n = 0;
				for (; i < arr.size(); i++) {
					if (arr.get(i).equals("+")) {
						continue;
					} else if (arr.get(i).equals("-")) {
						i -= 1;
						break;
					}
					n += Integer.parseInt(arr.get(i));
				}
				String t = String.valueOf(n);
				list.add(t);

			} else {
				list.add("-");
			}
		}

		int ans = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("-")) {
				i += 1;
				ans -= Integer.parseInt(list.get(i));
				continue;
			}
			ans += Integer.parseInt(list.get(i));

		}

//		System.out.println(arr);
//		System.out.println(list);
		System.out.println(ans);
	}

}
