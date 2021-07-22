package com.sjy.spark.test.leetcode.sort;

public class Quick_SortTest {
    //快速排序

    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] arr, int begin, int end) {
        //将区间第一个数作为基准数
        if(begin>end)
            return;
        if(begin<end){
            //将区间第一个数作为基准数
            int temp = arr[begin];
            int i=begin;//左指针
            int j = end;//右指针
        //不重复遍历
            while(i<j){
                //当右边的数大于基准数时，略过，继续向左查找
                while(i<j&&arr[j]>temp){
                    j--;
                }
                //如果不是则替换，将右边的元素给到左边
                arr[i]=arr[j];
                //当左边的数小于基准时，略过，继续向右查找
                while (i<j&&arr[i]<=temp){
                    i++;
                }
                //将左边的元素给到右边
                arr[j]= arr[i];
            }
            //将基准元素填入相应位置
            arr[i] = temp;
            //对基准元素左边进行排序
            quickSort(arr,begin,i-1);
            quickSort(arr,i+1,end);
        } else return;
    }


}
