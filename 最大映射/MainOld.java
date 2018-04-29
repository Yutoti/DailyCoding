import java.util.Scanner;
import java.util.HashMap;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] strinput = new String[n];
		int a[][] = new int[12][10];

		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 9; j++) {
				a[i][j] = 0;
			}
		}//初始化置0

		for(int i = 0; i < n; i++) {	//循环每个字符串
			strinput[i] = sc.nextLine();
			char[] c = strinput[i].toCharArray();
			int len = c.length;
			for(int j = len - 1; j >= 0; j--) {	//从后往前循环字符串
				for(int k = 0; k < 9; k++) {	//循环A-J字符
					if(c[j] == (char)(65+k)) {
						a[len-1-j][k] ++;
						break;
					}
				}
			}
		}
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		map = getMap(a);

		System.out.println(getMaxSum(strinput,map));
	}

	public static HashMap<Integer,Integer> getMap(int[][] a) {
		int[] num = new int[10];
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int j = 0; j < 9; j++) {	//对A-J每个字符循环
			int i = 11;
			while(a[i][j] == 0) i--;
			String strtemp = "";
			for(int count = i; count >= 0; count--) {
				strtemp += (char)a[i][j];
			}
			num[j] = Integer.parseInt(strtemp);
		}
		boolean[] flag = new boolean[10];
		for(int i = 0; i < 10; i++) {
			flag[i] = true;
		}
		for(int i = 0; i < 10; i++) {	//从大到小依次获得num的值和下标
			int maxValue = 0;
			int maxIndex = 0;
			int j = 0;
			while(j < 10) {
				if(num[j] > maxValue) {
					maxValue = num[j];
					maxIndex = j;
				}
				j++;
				while(j < 10 && flag[j] != true) j++;
			}
			flag[maxIndex] = false;
			map.put(num[maxIndex],9-i);
		}
		return map;
	}
	public static int getMaxSum(String[] str, HashMap map) {
		int n = str.length;
		int sum = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				str[i].replace((char)(65+j),(char)map.get(j));
			}
			sum += Integer.valueOf(str[i]);
		}
		return sum;
	}
}