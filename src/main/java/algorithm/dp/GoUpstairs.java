package algorithm.dp;

/**
 *
 * 理解：寻找最佳使用动态规划，寻找所有使用dfs深度优先搜寻
 * example: 例题：一个人每次只能走一层楼梯或者两层楼梯，问走到第80层楼梯一共有多少种方法
 * Created by 13722 on 2017/9/8.
 *
 */

public class GoUpstairs {

    public static int countWaysFirst(int n) {

       if (n <= 2) {
           return n;
       }

       int f = 2%1000000007;
       int s = 1%1000000007;
       int r = 0;

       for (int i = 3; i <= n; i ++) {
           r = f + s;
           s = f;
           f = r;
       }
       return r;
    }
    
    public static int countWaysSecond(int size) {
        if (size <= 2) {
            return size;
        }
        return countWaysSecond(size-1) + countWaysSecond(size-2);
    }


    public static void main(String[] args) {

        System.out.println(GoUpstairs.countWaysFirst(6));
    }
}
