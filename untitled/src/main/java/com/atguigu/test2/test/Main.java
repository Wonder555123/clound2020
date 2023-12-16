package com.atguigu.test2.test;
public class Main{

    public static void main(String[] args) {
        int n = 71;
        String str = "";
        while(n!=0){
            str = n%2+str;
            n = n/2;
        }
        System.out.println(str);
    }

}
