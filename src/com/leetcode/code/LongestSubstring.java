package com.leetcode.code;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by root on 16-10-11.
 */
public class LongestSubstring {
    public static void main(String[] args){

    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();

        char[] sChar = s.toCharArray();
        int maxLength = 0;
        for (int i=0;i<sChar.length;i++){
            for (int j=i;j<sChar.length;j++) {
                int beforeLength = charSet.size();
                charSet.add(sChar[j]);
                int afterLength = charSet.size();
                if (afterLength == beforeLength) {
                    maxLength = maxLength > beforeLength ? maxLength : beforeLength;
                    break;
                } else {
                    maxLength = maxLength > charSet.size() ? maxLength : charSet.size();
                }
            }
            if (sChar.length-i-1<maxLength) break;
            charSet.clear();
        }
        return maxLength;
    }

    public int otherMethod(String s){
        Set<Character> charSet = new HashSet<>();

        char[] sChar = s.toCharArray();
        int maxLength = 0;
        for (int i=0;i<sChar.length;i++){

            int beforeLength = charSet.size();
            charSet.add(sChar[i]);
            int afterLength = charSet.size();
            if (afterLength == beforeLength) {
                maxLength = maxLength > beforeLength ? maxLength : beforeLength;
                charSet.clear();
                charSet.add(sChar[i]);
            } else {
                maxLength = maxLength > charSet.size() ? maxLength : charSet.size();
            }
        }

        return maxLength;
    }
}
