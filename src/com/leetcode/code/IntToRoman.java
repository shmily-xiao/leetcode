package com.leetcode.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 17-3-13.
 */
public class IntToRoman {
    // ⅠⅡ Ⅲ Ⅳ Ⅴ Ⅵ Ⅶ Ⅷ Ⅸ Ⅹ
    public String intToRoman(int num){
        Map<Integer,String> intMap = new HashMap<>();
        intMap.put(1,"Ⅰ");
        intMap.put(2,"Ⅱ");
        intMap.put(3,"Ⅲ");
        intMap.put(4,"Ⅳ");
        intMap.put(5,"Ⅴ");
        intMap.put(6,"Ⅵ");
        intMap.put(7,"Ⅶ");
        intMap.put(8,"Ⅷ");
        intMap.put(9,"Ⅸ");
        intMap.put(10,"Ⅹ");
        intMap.put(40,"ⅩL");
        intMap.put(50,"L");
        intMap.put(90,"ⅩC");
        intMap.put(100,"C");
        intMap.put(400,"CD");
        intMap.put(500,"D");
        intMap.put(900,"CM");
        intMap.put(1000,"M");

        return "";

    }
}
