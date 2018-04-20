import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Meituan1{
	public static void main(String[] args) throws IOException {
		File file = new File("F:\\Employment\\coding\\meituan\\input.txt");
		FileReader freader = new FileReader(file);
		BufferedReader breader = new BufferedReader(freader);

		String str = breader.readLine();
		breader.close();
		int n = Integer.parseInt(str);
		
		System.out.println(func(n));
		/*int[] func = new int[n+1];

		func[0] = 1;
		int sum = 1;
		for (int i = 1; i <= n; i++) {
			func[i] = sum;
			sum += func[i];
		}	
		for(int f : func) System.out.println(f);*/
	}
	
	public static int func(int n){
		if(n==0) return 1;
		int sum = 0;
		for(int i = n-1; i >= 0; i--){
			sum += func(i);
		}
		return sum;
	}
}