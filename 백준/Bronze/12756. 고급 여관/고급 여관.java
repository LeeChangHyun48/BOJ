import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Ag = sc.nextInt();
		int Ab = sc.nextInt();

		int Bg = sc.nextInt();
		int Bb = sc.nextInt();

		while (true) {
			Ab -= Bg;
			Bb -= Ag;

			if (Ab <= 0 || Bb <= 0) {
				break;
			}
		}

		if (Ab <= 0 && Bb > 0) {
			System.out.println("PLAYER B");
		} else if (Ab > 0 && Bb <= 0) {
			System.out.println("PLAYER A");
		} else {
			System.out.println("DRAW");
		}

	}

}
