import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int maxWeight = sc.nextInt();		
		int[] w = new int[6];
		int[] v = new int[6];
        for(int i = 0; i < 6; i++){
            w[i] = 1;
        } 
        
        v[0] = 1;
        v[1] = 5;
        v[2] = 10;
        v[3] = 20;
        v[4] = 50;
        v[5] = 100;
		
		int[] dp = new int[maxWeight];
		for(int i = 0; i < maxWeight; i++){
			if(i < w[0]){
				dp[i] = 0;
			}else{
				dp[i] = v[0];
			}
		}
		for(int i = 1; i < 6; i++){
			for(int j = 0; j < maxWeight; j++){
				if(j-w[i] >= 0 && dp[j] < dp[j-w[i]]+v[i]){
					dp[j] = dp[j-w[i]]+v[i];
				}else{
					dp[j] = dp[j];
				}
			}
		}
		System.out.println(dp[maxWeight-1]);
	}
	
}