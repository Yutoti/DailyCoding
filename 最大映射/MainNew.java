import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Map;

public class MainNew {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()) {
			int n = sc.nextInt();
			String[] str = new String[n];
			for (int i = 0; i < n; i++) {
				str[i] = sc.next();
			}
			System.out.println(getMaxSum(str,n));
		}
	}

		public static long getMaxSum(String[] str, int n) {

			//为每个人字符设置权值，存储在HashMap之中；同时将所有的字符串的头元素保存在ArrayList当中，用于去除头元素映射为0的情况；
			HashMap<Character, Long> map = new HashMap<Character, Long>();
			ArrayList<Character> headList = new ArrayList<Character>();
			for (int i = 0; i < n; i++) {
				setWeight(str[i], map, headList);
			}

			//首先用ArrayList存储map的Entry结点，再将Entry用权值排序
			ArrayList<Map.Entry<Character, Long>> sortList = new ArrayList<Map.Entry<Character, Long>>(map.entrySet());
			Collections.sort(sortList, new Comparator<Map.Entry<Character, Long>>() {

				@Override
				public int compare(Entry<Character, Long> entry0, Entry<Character, Long> entry1) {
					return entry0.getValue() > entry1.getValue() ? -1 : 1;
				}
			});

			//需要排除有字符串头元素被映射成0的情况:权值最小，且所有的字符串都不以该元素作为头元素，将其映射成0；映射成0，即将其从sortList中移除
			if(sortList.size() == 10) {
				for(int i = 9; i >= 0; i--) {
					if(!headList.contains(sortList.get(i).getKey())) {
						sortList.remove(i);
						break;
					}
				}
			}
			int num = 9;
			long sum = 0;
			for(Entry<Character, Long> e : sortList) {
				sum += e.getValue() * num;
				num--;
			}
			return sum;
		}
	
	
	public static void setWeight(String str, HashMap<Character, Long> map, ArrayList<Character> headList) {
		char[] c = str.toCharArray();
		long  init = 1L;
		for(int i = c.length-1; i >= 0; i--) {
			if(!map.containsKey(c[i])) {
				map.put(c[i],init);
			} else {
				map.put(c[i],map.get(c[i]) + init);
			}
			init *= 10;
		}
		headList.add(c[0]);
	}
}