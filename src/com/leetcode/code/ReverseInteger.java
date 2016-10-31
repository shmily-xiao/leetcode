package com.leetcode.code;

/**
 * Created by simpletour_Jenkin on 2016/10/31.
 */
public class ReverseInteger {

    public int reverse(int x) {
        boolean isNegative = false;
        if (x<0){
            isNegative = true;
        }
        Long longX = Long.parseLong(x+"");
        if (isNegative){
            longX = 0L - longX;
        }

        String stringX = longX + "";
        String resultX = new StringBuilder(stringX).reverse().toString();
        Long resultLongX = Long.parseLong(resultX);
        if (isNegative){
            resultLongX = 0L - resultLongX;
        }
        if (isNegative){
            if (resultLongX < Integer.MIN_VALUE){
                return 0;
            }
        }else {
            if (resultLongX > Integer.MAX_VALUE){
                return 0;
            }
        }

        return resultLongX.intValue();
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int x = Integer.MIN_VALUE;
        System.out.println(x);
        System.out.println(reverseInteger.reverse(x));
    }
}
