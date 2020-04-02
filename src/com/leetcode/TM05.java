package com.leetcode;



	/*	给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

		示例 1：

		输入: "babad"
		输出: "bab"
		注意: "aba" 也是一个有效答案。
		示例 2：

		输入: "cbbd"
		输出: "bb"*/


public class TM05 {

	public static int len = 1;
	public static int begin = 0;
	public static void main(String[] args) {
		String test = "eabccbaf";
		System.out.println(new TM05().longestPalindrome(test));
		//test = "abc";
		//System.out.println(new TM05().longestPalindrome(test));

	}


	public String longestPalindrome(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 1, end = 1;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);//解决abba的问题
	        int len = Math.max(len1, len2);

	        //记录字符串的起止位置，i减去最大长度的一半是开始位置，i加上最大长度一半是结束位置
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
				System.out.println(start+"-"+end);
	        }
	    }
	    return s.substring(start, end + 1);
	}

	//从中间往两边对比求出目前left的最长的字符串
	private int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}

}
