
# Topic 29

      import java.util.HashMap;
      import java.util.Map;

      public class Topic29 {

        public static void main(String[] args) {

          int[][] nums = {{1,2,3,4,5},{14,15,16,17,6},{13,20,19,18,7},{12,11,10,9,8}};

          if(nums == null || nums.length == 0) {
            System.out.println("null");
            return;
          }

          int n = nums.length;
          int m = nums[0].length;

          int i = 0, j = 0;
          Map<Integer, Integer> rowMap = new HashMap<>();
          Map<Integer, Integer> colMap = new HashMap<>();


          System.out.println(nums[0][0]);
          while(true) {
            if(!rowMap.containsKey(i)) {
              rowMap.put(i, 1);
            }else {
              break;
            }
            while(j < m-i-1) {
              ++j;
              System.out.println(nums[i][j]);
            }

            if(!colMap.containsKey(j)) {
              colMap.put(j, 1);
            }else {
              break;
            }
            while(i < n-m+j) {
              ++i;
              System.out.println(nums[i][j]);
            }

            if(!rowMap.containsKey(i)) {
              rowMap.put(i, 1);
            }else {
              break;
            }
            while(j > n-1-i) {
              --j;
              System.out.println(nums[i][j]);
            }

            if(!colMap.containsKey(j)) {
              colMap.put(j, 1);
            }else {
              break;
            }
            while(i > j+1) {
              --i;
              System.out.println(nums[i][j]);
            }
          }
        }
      }
