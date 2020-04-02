package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/*      给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

        示例 1:

        输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:

        输入: "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:

        输入: "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*/

public class TM03 {

	public static void main(String[] args) {
		System.out.println(getStr("abcdbefghicjkbbbbbb"));
        System.out.println(getLength("abcdbefghicjkbbbbbb"));
		/*System.out.println(getStr("abcdbefghijk"));
		System.out.println(getStr("abcdefg"));*/

	}

	public static String getStr(String s){
		int n = s.length(), ans = 0,index_start = 0,index_end=0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0, left = 0; right < n; right++) {
        	char value = s.charAt(right);
        	
        	//获取目前为止最后重复字符的标志位
            if (map.containsKey(value)) {
                left = Math.max(map.get(value), left);  
            }
            
            //ans 是从0开始的，所以即使一直没有重复的字符，index_end也是一直增加的，index_start则不会变化
            if(ans<=right + 1 - left) {
            	index_end = right+1;
            	index_start = left+1;
            }
            ans = Math.max(ans, right + 1 - left);
            map.put(value, right + 1);
        }
        System.out.print(ans+"-"+index_start+"-"+index_end+"-");
        return s.substring(index_end-ans, index_end);
	}
	
	public static int getLength(String s) {
		int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0, left = 0; right < n; right++) {
        	char value = s.charAt(right);
        	
        	//获取目前为止最后重复字符的标志位
            if (map.containsKey(value)) {
                left = Math.max(map.get(value), left);  
            }
            ans = Math.max(ans, right + 1 - left);
            map.put(value, right + 1);
        }
        return ans;
    }
	
}