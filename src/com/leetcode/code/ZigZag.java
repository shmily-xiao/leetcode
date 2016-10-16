package com.leetcode.code;

import java.util.Arrays;

/**
 * Created by root on 16-10-13.
 *
 * n=2
 * 0 2 4 6
 * 1 3 5 7
 *
 * n=3
 * 0   4   8     12
 * 1 3 5 7 9  11 13
 * 2   6   10    14
 *
 *
 * n=4
 * 0     6       12
 * 1   5 7    11 13   17
 * 2 4   8 10    14 16
 * 3     9       15
 *
 * n=5
 * 0        8            16
 * 1      7 9         15
 * 2    6   10     14
 * 3  5     11  13
 * 4        12
 *
 */
public class ZigZag {
    public static void main(String[] args){
        ZigZag zigZag = new ZigZag();
        String ss = zigZag.convert("abcde", 4);
//        String ss = zigZag.convert("PAYPALISHIRING", 4);

//        System.out.println("PAYPALISHIRING");
        System.out.println("abcde");
        System.out.println(ss);
    }

    public String convert(String s, int nRows) {
        int len = s.length();
        if (len == 0 || nRows <= 1) return s;

        String[] ans = new String[nRows];
        Arrays.fill(ans, "");
        int row = 0, delta = 1;
        for (int i = 0; i < len; i++) {
            ans[row] += s.charAt(i);
            row += delta;
            if (row >= nRows) {
                row = nRows-2;
                delta = -1;
            }
            if (row < 0) {
                row = 1;
                delta = 1;
            }
        }

        String ret = "";
        for (int i = 0; i < nRows; i++) {
            ret += ans[i];
        }
        return ret;
    }

//    public String convert(String s, int numRows) {
//
//        char[] sChar = s.toCharArray();
//         int column = this.getColumn(sChar.length,numRows);
//        char[] resultChar = new char[s.length()];
//        int tempLength = 0;
//        if (numRows == 1) return s;
//        for (int i = 0; i<numRows; i++){
//            int oushu = 0;
//            int jishu = 1;
//            int tempI = i;
//            for (int j = 0;j < column; j++){
//                if (i == 0){
//                    if ((numRows!=2&&j%2 != 0) || oushu*(numRows-1)>=s.length()) continue;
//                    resultChar[tempLength] = sChar[oushu*(numRows-1)];
//                    oushu = oushu + 2;
//                    tempLength = tempLength + 1;
//                }else if (i == numRows-1){
//                    if ((numRows!=2&&j%2 != 0) || jishu*(numRows-1) >= s.length()) continue;
//                    resultChar[tempLength] = sChar[jishu*(numRows-1)];
//                    jishu = jishu + 2;
//                    tempLength = tempLength + 1;
//                }else {
//                    if (tempI >= s.length()) continue;
//                    resultChar[tempLength] = sChar[tempI];
//                    tempI = tempI + numRows - 1;
//                    tempLength = tempLength + 1;
//                }
//            }
//        }
//
//
//        return new String(resultChar);
//    }
//
//    private int getColumn(int length, int row){
//        int column = length/row;
//        length = this.getLength(column,length);
//        int info = 0;
//        for (int i=0;i<length;i++){
//            if (column * row > this.getLength(column,length)){
//                info = 1;
//            }
//            if (info == 1) break;
//            column = column + 1;
//        }
//
//        return column;
//    }
//
//    /**
//     *
//     * @param column
//     * @param length
//     * @return
//     */
//    private int getLength(int column,int length){
//        return column%2==0 ? length + column : length + column - 1;
//    }
}
