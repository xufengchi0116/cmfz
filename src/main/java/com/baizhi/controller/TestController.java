package com.baizhi.controller;


public class TestController {


    static int x = 10;

    static {
        x += 5;
    }


    public static void main(String[] args) {
        int i = 9;
      /*  int a = i++;
        System.out.println(a);
        int b = (i++)-i;
        System.out.println(b);*/
        //  i+=(i++)-i;
        i = i + (i++) - i;
        //System.out.println(i);

        //System.out.println("x="+x);

        //String s = "str";
        //s+="book";

        //System.out.println(s.length());
        //int a = s.length();
        //System.out.println(s);

        String s = null;
        System.out.println("s=" + s);
    }

    static {
        x /= 3;
    }


}
