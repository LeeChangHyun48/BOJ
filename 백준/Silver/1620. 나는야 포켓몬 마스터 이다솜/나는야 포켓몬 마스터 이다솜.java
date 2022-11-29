import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken()); // 도감에 수록되어있는 포켓몬의 개수
		int M = Integer.parseInt(st.nextToken()); // 맞춰야하는 문제의 개수

		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		TreeMap<String, Integer> tempMap = new TreeMap<String, Integer>();
		// 입력되는 순으로 포켓몬의 <key, value>로 저장

		for (int i = 1; i <= N; i++) {
			String name = bf.readLine();

			map.put(i, name);
			tempMap.put(name, i);
		}

		for (int i = 0; i < M; i++) {
			String str = bf.readLine();

			if (str.chars().allMatch(Character::isDigit)) { // 만약 입력된 문자가 숫자일때
				System.out.println(map.get(Integer.parseInt(str))); // key로 value 조회
			} else { // 숫자가 아닐때
				System.out.println(tempMap.get(str));
			}
		}

	}

}
