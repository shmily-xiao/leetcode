package com.leetcode.code;

/**
 * Created by simpletour_Jenkin on 2016/11/7.
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x<0) return false;
        String string = x+"";
        String compare = new StringBuilder(string).reverse().toString();

        return string.equals(compare);
    }

    public static boolean isPalindrome2(int x) {
        if (x<0){
           return false;
        }
        int div = 1;
        while(x/div >= 10){
            div = div*10;
        }
        while(true){
            int pre = x/div;
            int post = x%10;
            if (pre!=post){
                return false;
            }
            x = x % div;
            x = x/10;
            if (x<10){
                return true;
            }
            div = div /100;
        }
    }

    // 考虑int溢出的情况
    public static int reverse(int x){
        if (x<0) return -1;
        Long xLong = Long.parseLong(x+"");
        Long result = 0L;
        while (xLong!=0){
            result = xLong%10 + result*10;
            if (result > Integer.MAX_VALUE) return -1;
            xLong = xLong/10;
        }

        return result.intValue();

    }

    public static void main(String[] args) {
        int x = 12560103;
        System.out.println(isPalindrome(x));
        System.out.println(isPalindrome2(x));
        System.out.println(reverse(x));

    }

}
