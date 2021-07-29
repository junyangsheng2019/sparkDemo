package com.sjy.spark.test.leetcode.sort.dp;

import java.util.Arrays;

/**
 * 零钱兑换
 */
public class Test322 {

    int res=0;
    //1,2,5
    public void findWay(int[] coins,int amount,int count){
        if(amount<0)
            return;
        if(amount==0){
            res = Math.min(res,count);
        }
        for (int i = 0; i < coins.length; i++) {
            findWay(coins,amount-coins[i],count+1);
        }

    }
    public int coinChange(int[] coins, int amount) {
        if(coins==null||amount<=0){
            return -1;
        }
        findWay(coins,amount,0);


// 自底向上的动态规划
        if(coins.length == 0){
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount+1];
        // 给memo赋初值，最多的硬币数就是全部使用面值1的硬币进行换
        // amount + 1 是不可能达到的换取数量，于是使用其进行填充
        Arrays.fill(memo,amount+1);
        memo[0] = 0;
        for(int i = 1; i <= amount;i++){
            for(int j = 0;j < coins.length;j++){
                if(i - coins[j] >= 0){
                    // memo[i]有两种实现的方式，
                    // 一种是包含当前的coins[i],那么剩余钱就是 i-coins[i],这种操作要兑换的硬币数是 memo[i-coins[j]] + 1
                    // 另一种就是不包含，要兑换的硬币数是memo[i]
                    memo[i] = Math.min(memo[i],memo[i-coins[j]] + 1);
                }
            }
        }

        return memo[amount] == (amount+1) ? -1 : memo[amount];

//        作者：sugar666
//        链接：https://leetcode-cn.com/problems/coin-change/solution/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
