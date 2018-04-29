import java.util.TreeMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		while (map.size() != 0) {
			Set<Character> keyset = map.keySet();
			Iterator<Character> it = keyset.iterator();
			while (it.hasNext()) {
				Character key = it.next();
				if (map.get(key) > 0) {
					System.out.print(key);
					map.put(key, map.get(key) - 1);
					if(map.get(key) == 0) it.remove();
				}
			}
		}
	}
}