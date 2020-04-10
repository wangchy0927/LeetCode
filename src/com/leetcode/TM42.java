package com.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TM42 {

    public static void main(String[] args){
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TM42().trap02(arr));
        //System.out.println(new TM42().trap01(arr));
    }

    public int trap02(int[] height){
        int index = getMaxIndex(height);
        int[] arr1 = Arrays.copyOf(height,index+1);
        int[] arr2 = Arrays.copyOfRange(height,index,height.length);
        return getSum(arr1)+getSum(arr2);
    }

    private int getSum(int[] arr){
        int sum = 0;
        boolean flag = false;
        for(int i=0;i<arr.length-1;){
            int v1 = arr[i];
            for(int j=i+1;j<=arr.length-1;j++){
                int v2 = arr[j];
                if(v2 > v1 && flag){
                    i = j - 1;
                    sum = sum + v2 - arr[j-1];
                    break;
                }if(v1>v2){
                    flag = true;
                    sum = sum + v1 - v2;
                }
            }
            i++;
        }
        return sum ;
    }

    private int getMaxIndex(int[] arr){
        int index = 0,max = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>max){
                index = i;
                max = arr[i];
            }
        }
        return index;
    }

    /**
     * 这是我最开始想到的一个解法，提交后直接 AC 了，自己都震惊了。就是先求高度为 1 的水，再求高度为 2 的水，再求高度为 3 的水。
     *
     * 整个思路就是，求第 i 层的水，遍历每个位置，如果当前的高度小于 i，并且两边有高度大于等于 i 的，说明这个地方一定有水，水就可以加 11。
     *
     * 如果求高度为 i 的水，首先用一个变量 temp 保存当前累积的水，初始化为 0。从左到右遍历墙的高度，遇到高度大于等于 i 的时候，
     * 开始更新 temp。更新原则是遇到高度小于 i 的就把 temp 加 11，遇到高度大于等于 i 的，就把 temp 加到最终的答案 ans 里，并且 temp 置零，
     * 然后继续循环。
     * */
    public int trap01(int[] height){
        int sum = 0,max = getMax(height);
        for(int i=1;i<max;i++){
            boolean flag = false;
            int temp = 0;
            for(int j=0;j<height.length;j++){
                if(flag&&height[j]<i){
                    temp++;
                }
                if(height[j]>=i){
                    sum = sum + temp;
                    temp = 0;
                    flag = true;
                }
            }

        }
        return sum;
    }

    private int getMax(int[] arr){
        int max = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

}
