import java.util.Scanner;
import java.util.Stack;
 
public class ProtectMountain{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){        
            int n = in.nextInt();
            int[] height = new int[n];
            for(int i = 0; i < n; i++){
                height[i] = in.nextInt();
            }                      
            long out = mountainCp(height);
            System.out.println(out);
        }
    }
     
    public static class Mountain{
        public int height;
        public int times;
         
        public Mountain(int height){
            this.height = height;
            this.times = 1;
        }
    }
     
    public static int getNextIndex(int size, int curindex){
        return curindex < (size - 1) ? (curindex + 1) : 0;
    }
     
    public static int getMaxIndex(int[] nums){
        int maxIndex = 0;
        for(int i = 1; i < nums.length; i++) {
            maxIndex = (nums[i] > nums[maxIndex]) ? i : maxIndex;
        }
        return maxIndex;
    }
     
    public static long getInnerCp(int times){
        return times <= 1 ? 0L : (long)times * (long)(times-1) >>> 1;
    }
     
    public static long mountainCp(int[] height){   
        if(height.length <= 1 || height == null) return 0;
         
        int size= height.length;   
        int maxIndex = getMaxIndex(height);
         
        Stack<Mountain> stack = new Stack<>();
        Mountain mou = new Mountain(height[maxIndex]);
        stack.push(mou);
        int nextIndex = getNextIndex(size,maxIndex);
        long ret = 0L;
         
        while(nextIndex != maxIndex){
            int value = height[nextIndex];
             
            if(stack.peek().height == value){
                stack.peek().times ++;
            }else if(stack.peek().height > value){
                stack.push(new Mountain(value));
            }else {
                while(!stack.isEmpty() && stack.peek().height < value){
                    int times = stack.pop().times;
                    ret += getInnerCp(times) + (times << 1);
                }
                if(stack.peek().height == value){
                    stack.peek().times ++;
                }else{
                    stack.push(new Mountain(value));
                }
            }
            nextIndex = getNextIndex(size,nextIndex);
        }
         
        while(!stack.isEmpty()){
            int times = stack.pop().times;
            ret += getInnerCp(times);
            if(!stack.isEmpty()){
                ret += times;
                if(stack.size() > 1){
                    ret += times;
                }else{
                    ret += stack.peek().times > 1 ? times : 0;
                }
            }
        }
        return ret;
    }
}



/*
import java.util.Scanner;
import java.util.Stack;


public class Main {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int size = in.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = in.nextInt();
			}
			System.out.println(communications(arr));
		}
	}


	public static int nextIndex(int size, int i) {
		return i < (size - 1) ? (i + 1) : 0;
	}
//相邻相同山峰之间的对数，若只有一个，则没有成对，若有两个以上计算内部成对数
	public static long getInternalSum(int n) {
		return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
	}


	public static class Pair {
		public int value;
		public int times;


		public Pair(int value) {
			this.value = value;
			this.times = 1;
		}
	}


	public static long communications(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int size = arr.length;
		int maxIndex = 0;
		for (int i = 0; i < size; i++) {
			maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;//找到最高山峰的位置
		}
		int value = arr[maxIndex];//最高山峰的高度
		int index = nextIndex(size, maxIndex);//最高山峰的下一个位置
		long res = 0L;
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(value));
		while (index != maxIndex) { 
			value = arr[index];
			while (!stack.isEmpty() && stack.peek().value < value) {
				int times = stack.pop().times;
// res += getInternalSum(times) + times;
// res += stack.isEmpty() ? 0 : times;
				res += getInternalSum(times) + times*2;//因为栈底是最大元素，所以在此阶段不可能跳出

			}
			if (!stack.isEmpty() && stack.peek().value == value) {
				stack.peek().times++;
			} else {
				stack.push(new Pair(value));
			}
			index = nextIndex(size, index);
		}
		while (!stack.isEmpty()) {
			int times = stack.pop().times;
			res += getInternalSum(times);
			if (!stack.isEmpty()) {
				res += times;
				if (stack.size() > 1) {//当栈底还剩大于1个的时候，弹出的那个数还可以与栈底的数称为对数
					res += times;
				} else {
					res += stack.peek().times > 1 ? times : 0;
				}
			}
		}
		return res;
	}
}


*/