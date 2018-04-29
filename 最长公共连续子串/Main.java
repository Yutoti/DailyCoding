import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		int n1 = c1.length;
		int n2 = c2.length;
		int[][] dp = new int[n1][n2];
		
		int indexI = 0;
		int indexJ = 0;
		int maxLength = 0;
		
		for(int i = 0; i < n2; i++){
			if(c1[0] == c2[i]){
				dp[0][i] = 1;
				indexJ = i;
				maxLength = 1;
			}
		}
		for(int i = 0; i < n1; i++){
			if(c2[0] == c1[i]){
				dp[i][0] = 1;
				indexI = i;
				maxLength = 1;
			}
		}
		for(int i = 1; i < n1; i++){
			for(int j = 1; j < n2; j++){
				if(c2[j] == c1[i]){
					dp[i][j] = dp[i-1][j-1]+1;
				}
				if(dp[i][j] > maxLength){
					maxLength = dp[i][j];
				}
			}
		}
		System.out.println(maxLength);
	}
}