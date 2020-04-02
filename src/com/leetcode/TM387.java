package com.leetcode;

/*		给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

		案例:

		s = "leetcode"
		返回 0.

		s = "loveleetcode",
		返回 2.*/

public class TM387 {

	public static void main(String[] args) {

		String s = "abcedfahjik";
		System.out.println(getFirstIndex(s));
		s = "abcedfahjikb";
		System.out.println(getLastIndex(s));
	}
	public static int getLastIndex(String s) {
		int index = -1;
		for(int i=s.length()-1;i>=0;i--) {
			char value = s.charAt(i);
			if(s.lastIndexOf(value)==s.indexOf(value)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static int getFirstIndex(String s) {
		int index = -1;
		for(int i=0;i<s.length();i++) {
			char value = s.charAt(i);
			if(s.lastIndexOf(value)==s.indexOf(value)) {
				index = i;
				break;
			}
		}
		return index;
	} 

}
