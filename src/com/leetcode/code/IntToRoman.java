package com.leetcode.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 17-3-13.
 *
 * 将给定的数字转换成罗马数字
 *
 * 112ms
 *
 */
public class IntToRoman {
    // ⅠⅡ Ⅲ Ⅳ Ⅴ Ⅵ Ⅶ Ⅷ Ⅸ Ⅹ
    public String intToRoman(int num){
        Map<Integer,String> intMap = new HashMap<>();
        intMap.put(1,"I");
        intMap.put(4,"IV");
        intMap.put(5,"V");
        intMap.put(9,"IX");
        intMap.put(10,"X");
        intMap.put(40,"XL");
        intMap.put(50,"L");
        intMap.put(90,"XC");
        intMap.put(100,"C");
        intMap.put(400,"CD");
        intMap.put(500,"D");
        intMap.put(900,"CM");
        intMap.put(1000,"M");

//        List<Integer> intList = new ArrayList<>();
//        intList.add(1000);
//        intList.add(900);
//        intList.add(500);
//        intList.add(400);
//        intList.add(100);
//        intList.add(90);
//        intList.add(50);
//        intList.add(40);
//        intList.add(10);
//        intList.add(9);
//        intList.add(5);
//        intList.add(4);
//        intList.add(1);
        int[] intList = new int[]{
                1000,900,500,400,100,90,50,40,10,9,5,4,1
        };

        StringBuilder resultString = new StringBuilder();
        int tempI = 0;
        while (true){
            int i = tempI;//下次就不用去从头开始编历数组
            for (;i<intList.length;i++){
                int tempInt = intList[i];
                if (num - tempInt >= 0){
                    resultString.append(intMap.get(tempInt));
                    num = num - tempInt;
                    tempI = i;
                    break;
                }
            }
            if (num == 0){
                break;
            }
        }
        return resultString.toString();

    }

    public static void main(String[] args){
        IntToRoman intToRoman =  new IntToRoman();
        String resultString = intToRoman.intToRoman(1511);
        System.out.println(resultString);
    }
}
