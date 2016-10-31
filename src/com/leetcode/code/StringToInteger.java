package com.leetcode.code;

/**
 * Created by simpletour_Jenkin on 2016/10/31.
 * 遇到的情况 ：
 * ""
 * +1
 * +
 * +-2
 * "    010"
 * "     +4500"
 * "  -0012a42"  期望是     -12
 * "   +0 123"             0
 * "2147483648"            2147483647
 * "18446744073709551617"  1
 *
 */
public class StringToInteger {
    public int myAtoi(String str) {

        str = this.deleteSpace(str);

        str = this.initString(str);
        if (str.isEmpty()){
            return 0;
        }


        if (str.isEmpty()){
            return 0;
        }
        char[] numChar = str.toCharArray();
        int i = 0;
        boolean isNegative = false; // 记录是否为负数

        int length = numChar.length;
        Long resultNum = 0L;
        if (numChar[i] == '-'){
            isNegative = true;
        }
        if (isNegative){
            i = i+1;
            length = length-1; // 去掉符号的占位
        }
        length = length-1; // 十进制去掉1
        if (length > (Integer.MAX_VALUE+"").length()){
            return Integer.MAX_VALUE;
        }
        for (; i < numChar.length; i++){
            if (numChar[i]<'0'||numChar[i]>'9'){
                break;
            }
            if (this.power(10L,Long.parseLong(length+"")) > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            resultNum = Long.parseLong(numChar[i]+"")*this.power(10L,Long.parseLong(length+"")) + resultNum;
            length = length -1;
            if (isNegative && (0-resultNum) < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            if (!isNegative && resultNum > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        if (i!=numChar.length){
            return 0;
        }
        return isNegative? -resultNum.intValue():resultNum.intValue();
    }

    private String deleteSpace(String str){
        if (str==null || str.isEmpty()) return "";
        String reslut = "";
        char[] numChar = str.toCharArray();
        for (int i=0;i<numChar.length;i++){
            if (numChar[i] == ' ' && reslut.isEmpty()){
                continue;
            }else {
                reslut = reslut + numChar[i];
            }

        }
        return reslut;
    }

    private String initString(String str){
        String result = "";
        String s = str;
        if (str==null || str.isEmpty()){
            return "";
        }

        if (str.charAt(0)=='+'){
            s = str.substring(1);
        }
        if (s.isEmpty()){
            return "";
        }
        char[] numChar = str.toCharArray();
        for (int i=0;i<numChar.length;i++){
            if ((numChar[i]<'0'||numChar[i]>'9')&&i!=0){
                break;
            }else {
                result = result + numChar[i];
            }
        }
        if (result.charAt(0)=='+'){
            result = result.substring(1);
        }

        return result;
    }

    /**
     * x 的 y 次幂
     * @param x
     * @param y
     * @return
     */
    public Long power(Long x,Long y){

        if (y <= 0){
            return 1L;
        }

        y = y-1;
        Long result = x;
        while (y>0){
            result = result * x;
            y = y-1;
        }
        return result;
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();

        String input = "18446744073709551617";//"  -001 2a42"; // "   +0 123"
        System.out.println(input);
        System.out.println(stringToInteger.myAtoi(input));

    }

}
