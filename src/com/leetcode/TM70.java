package com.leetcode;

public class TM70 {

    public static void main(String[] args){
        System.out.println(lt(4));
        System.out.println(climbStairs(4));
    }

    public static int lt(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return lt(n - 1) + lt(n - 2);
    }

    /**
     * 本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和
     *  爬上 n-1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
     *  爬上 n-2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
     * 所以我们得到公式 dp[n] = dp[n-1] + dp[n-2]
     * */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
