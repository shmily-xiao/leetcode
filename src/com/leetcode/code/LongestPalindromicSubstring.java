package com.leetcode.code;

/**
 * Created by root on 16-10-19.
 *
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *
 * 一个字符 也算回文
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args){

    }

    public String longestPalindrome(String s) {

        String palindrome = "";
        if (s.length()<=1){
            return s;
        }
        for (int i = 0;i < s.length(); i++){
            for (int j = i+1; j < s.length();j++){
                String tempString = s.substring(i,j);
                String reverseCompareString = this.reverseString(tempString);
                if (reverseCompareString.length() <= (s.length() - j)){
                    String compareString = s.substring(j,reverseCompareString.length());
                    if (compareString.equals(reverseCompareString) && compareString.length()*2 > palindrome.length()){
                        palindrome = tempString + reverseCompareString;
                    }
                }
            }
        }

        return palindrome;

    }

    /**
     * 反转之后的字符串
     * @param s
     * @return
     */
    public String reverseString(String s){
        if (s.isEmpty() || s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        String result = "";
        for (int i = s.length() -1 ; i >=0 ; i--){
            result = result + chars[i];
        }
        return result;
    }

//    public class stringStack{
//        char[] stack;
//        // stack length
//        int length;
//        // data size
//        int count;
//    }
}
