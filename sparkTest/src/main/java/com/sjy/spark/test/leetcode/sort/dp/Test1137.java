package com.sjy.spark.test.leetcode.sort.dp;

public class Test1137 {
    /**
     * 泰波那契序Tn 定义如下：
     *
     * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     *
     * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if(n<=0)
            return 0;
        int a=0,b=1,c=1,d;
        while(--n>0){
            d = a+b+c;
            a=b;
            b=c;
            c=d;
        }
        return b;
    }
}
