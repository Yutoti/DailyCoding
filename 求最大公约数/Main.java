import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int division1;
		int division2;
		if(n2 > n1) {
			division1 = n1;
			division2 = n2;
		} else {
			division1 = n2;
			division2 = n1;
		}

		int remainder = division1 % division2;
		while(remainder != 0) {
			division1 = division2;
			division2 = remainder;
			remainder = division1 % division2;
		}
		int gcd = division2;
		System.out.println(gcd);
	}
}