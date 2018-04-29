import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ZeroOnePack{
	public static void main(String[] args) throws IOException {
		File file = new File("F:\\Employment\\coding\\美团\\背包问题\\0-1背包\\Packinput.txt");
		FileReader freader = new FileReader(file);
		BufferedReader breader = new BufferedReader(freader);
		String str = breader.readLine();
		int n = Integer.parseInt(str);
		
		int[] w = new int[n];
		int[] v = new int[n];
		for(int i = 0; i < n; i++){
			str = breader.readLine();
			String[] s = str.split("	");
			w[i] = Integer.valueOf(s[0]);
			v[i] = Integer.valueOf(s[1]);
		}
		str = breader.readLine();
		int maxWeight = Integer.parseInt(str);
		
		breader.close();
		
		int[] dp = new int[maxWeight];
		for(int i = 0; i < maxWeight; i++){
			if(i < w[0]){
				dp[i] = 0;
			}else{
				dp[i] = v[0];
			}
		}
		for(int i = 1; i < n; i++){
			for(int j = maxWeight-1; j >= 0; j--){
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