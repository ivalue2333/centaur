package algorithm.dp;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/1/25
 * Description:
 * Modified:
 * 题目：子数组和最大
 * 输入一个整形数组，求数组中连续的子数组使其和最大。比如，数组x=[31,-41,2,33,-53,3,44]
 */
public class MaxArray {

    public static int max(int a, int b){
        return a > b ? a : b;
    }

//    动态规划
    public static int max_sub_array(int[] arr) {
        int max_here = arr[0];
        int max_so_far = arr[0];

        for (int i = 1; i < arr.length; i++) {
            max_here = max(arr[i], max_here + arr[i]);
            max_so_far = max(max_here, max_so_far);
        }
        return max_so_far;
    }
}
