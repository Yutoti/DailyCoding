import java.util.Scanner;
public class StepNum{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] count = new int[n+1];
        count[0] = 1;
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += count[i-1];
            count[i] = sum;
        }
        System.out.println(count[n]);
    }
}