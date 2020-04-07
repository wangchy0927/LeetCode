package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * */
public class TM15 {


    public static void main(String[] args){
        int nums[] = {1,-2,7,4,-5,1,-4,-5,-3};
        List<List<Integer>> list = threeSum(nums);
        int i = list.size();
        for(int j = 0;j<i;j++){
            System.out.println(list.get(j).get(0)+"\t"+list.get(j).get(1)+"\t"+list.get(j).get(2));
        }
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        if(nums == null || length < 3) {
            return list;
        }
        //按照从小到大排序
        Arrays.sort(nums);
        for(int i=0;i<length;i++){
            //三个数都大于0相加肯定不等于0
            if(nums[i]>0){
                break;
            }
            //去重
            if(i > 0 && nums[i]==nums[i-1]){
                continue;
            }
            int L = i+i,R = length-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum==0) {
                    list.add(Arrays.asList(nums[i], nums[L], nums[R]));

                    //去重
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                }else if(sum < 0){
                    L++;
                }else{
                    R--;
                }
            }
        }

        return list;
    }

}
