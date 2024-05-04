package com.example.demo.utils;

public class XuedenUtil {

   public  static int randomSixNums(){
       int code = (int) ((Math.random()*9+1)*100000);
       return code;
   }

    public static void main(String[] args) {
        System.out.println(XuedenUtil.randomSixNums());
    }
}
