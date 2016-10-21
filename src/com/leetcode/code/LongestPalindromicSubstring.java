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

    public Long time=0L;

    public static void main(String[] args){

        LongestPalindromicSubstring palindromicSubstring = new LongestPalindromicSubstring();

        Long start = System.currentTimeMillis();
        String ss = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//        String ss = "jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel";
        // ranynar
        String result = palindromicSubstring.longestPalindrome(ss);
        Long end = System.currentTimeMillis();
        System.out.println("所用时间： " + (end-start) + "ms");
        System.out.println("回文: "+result);
        System.out.println("反字符串所用时间 : "+palindromicSubstring.time);
        System.out.println("反字符串所用时间 : "+palindromicSubstring.time*100 /(end-start)  + "%");

//        String s = "12345";
//        System.out.println(s.substring(0,s.length()/2));
//        System.out.println(s.substring(s.length()/2,s.length()));
//        System.out.println(s.substring(s.length()/2 + 1,s.length()));

//
//        String aaa = "123456";
//        String bbb = "654321";
//        System.out.println(palindromicSubstring.compareString(aaa,bbb));

    }

    public String longestPalindrome(String s) {

        String palindrome = "";
        if (s.length()<=1){
            return s;
        }
        for (int i = 0;i < s.length(); i++){
            for (int j = i+1; j <= s.length();j++){
                if (palindrome.length() >= j-i) continue;
                String tempString = s.substring(i,j);
                if (this.isPalindromeString(tempString)){
                    if (palindrome.length() < tempString.length()){
                        palindrome = tempString;
                    }
                }
            }
        }
        return palindrome;

    }

    /**
     * 判断字符串是不是回文
     * @param s
     * @return
     */
    public Boolean isPalindromeString(String s){
        Long start = System.currentTimeMillis();
        int length = s.length();
        int halfLength = length/2;

        if (length<2) return Boolean.TRUE;
        if (length%2 == 0){
            String preString = s.substring(0,halfLength);
            String postString = s.substring(halfLength,length);
//            if (this.reverseString(preString).equals(postString)){
            if (this.compareString(preString,postString)){

                Long endTime = System.currentTimeMillis();
                time = time + (endTime-start);
                return Boolean.TRUE;
            }else {
                Long endTime = System.currentTimeMillis();
                time = time + (endTime-start);
                return Boolean.FALSE;
            }
        }else {
            String preString = s.substring(0,halfLength);
            String postString = s.substring(halfLength+1,length);
//            if (this.reverseString(preString).equals(postString)){
            if (this.compareString(preString,postString)){

                Long endTime = System.currentTimeMillis();
                time = time + (endTime-start);
                return Boolean.TRUE;
            }else {
                Long endTime = System.currentTimeMillis();
                time = time + (endTime-start);
                return Boolean.FALSE;
            }
        }
    }

    public Boolean compareString(String stringA, String stringB){
        int length = stringA.length();
        if (length != stringB.length()) return Boolean.FALSE;
        char[] charA = stringA.toCharArray();
        char[] charB = stringB.toCharArray();
        for (int i =0,j=length-1;   i<length ||j >=0;  i++,j--){
            if (charA[i] != charB[j]){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }


    /**
     * 反转字符串
     * @param s
     * @return
     */
    public String reverseString(String s){
        Long start = System.currentTimeMillis();
        // method 1
//        if (s.isEmpty() || s.length() <= 1) return s;
//        char[] chars = s.toCharArray();
//        StringBuilder result = new StringBuilder();
//        for (int i = s.length() -1 ; i >= 0 ; i--){
//            result = result .append(chars[i]);
//        }
        // method 2
        String result = new StringBuilder(s).reverse().toString();

        //method 3
//        char[] str = s.toCharArray();
//
//        int begin = 0;
//        int end = s.length() - 1;
//
//        while (begin < end) {
//            str[begin] = (char) (str[begin] ^ str[end]);
//            str[end] = (char) (str[begin] ^ str[end]);
//            str[begin] = (char) (str[end] ^ str[begin]);
//            begin++;
//            end--;
//        }
        Long endTime = System.currentTimeMillis();
        time = time + (endTime-start);
//        return new String(str);
        return result;
    }

}
