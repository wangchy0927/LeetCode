package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

 *
 * @author Miracle
 * @date 2020/4/4 23:18
 */
public class TM17 {


    public static void main(String[] args){
        List<String> list = test("23");
        for(String value : list){
            System.out.println(value);
        }
    }


    /* *
    *  定义一个值为""的队列，此时数组长度为length(1)
    *  根据输入参数，遍历获取数组内对应的字符串value
    *  取出队列取出字符串(长度为length)，和value的每个字符进行拼接
    *  拼接后再放入到队列中。
    *  循环进行操作
    * @param
    * @return
    * @Author Miracle
    * @Date 2020/4/4 23:59
    */
    public static List<String> test(String str){
        if(str==null || str.length()==0){
            return new ArrayList<String>();
        }
        String[] arr = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String > list = new ArrayList<String>();
        list.add("");
        for(int i=0;i<str.length();i++){
            String value = arr[str.charAt(i)-'0'];
            int lenth = list.size();
            for(int j=0;j<lenth;j++){
                String tmp = list.remove(0);
                for(int k=0;k<value.length();k++){
                    list.add(tmp+value.charAt(k));
                }
            }
        }
        return list;
    }
}
