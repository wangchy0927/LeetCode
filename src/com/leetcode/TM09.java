package com.leetcode;


/**
 * 判断一个整数是否是回文数。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * */
public class TM09 {

    public static  void main(String[] args){
        System.out.println(isHuiwen(9));
        System.out.println(0%10);
    }

    public static boolean isHuiwen(int value){
        boolean flag = true;
        //大于等于0 和小于10的都是回文
        if(value>=0&&value<=9){
            return true;
        }
        //小与0和结尾是0的肯定不是回文
        if(value<0||value%10==0){
            return  false;
        }
        //遍历字符串，把第一位与最后以为对比，依次缩小前后间距，此处注意:自需要遍历一半位置即可
        String text = value+"";
        int length = text.length();
        int start = 0 , end = length-1;
        while(flag&&start<=length/2+1&&end>=length/2-1){

            if(text.charAt(start++)!=text.charAt(end--)){
                flag = false;
                break;
            }
        }
        return  flag;
    }
}
