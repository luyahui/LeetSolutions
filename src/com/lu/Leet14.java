package com.lu;

public class Leet14 {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length == 0)
            return  result;
        for (int i = 0; ; i++) {
            boolean flag = true;
            char ch = ' ';
            for (String str : strs) {
                if (i >= str.length()) {
                    flag = false;
                    break;
                }
                if(ch == ' '){
                    ch = str.charAt(i);
                }else {
                    if(str.charAt(i) != ch){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)
                result += ch;
            else
                break;
        }
        return result;
    }

    public static void main(String[] args){
        Leet14 l14 = new Leet14();
        System.out.println(l14.longestCommonPrefix(new String[]{}));
    }
}
