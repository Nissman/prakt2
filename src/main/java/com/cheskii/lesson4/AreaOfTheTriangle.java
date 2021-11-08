package com.cheskii.lesson4;

public class AreaOfTheTriangle {

    static double OnThreeSides(int a, int b, int c) {
        double p = (double)(a+b+c) / 2;
    return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    static boolean ExistenceTriangle(int a, int b, int c){
        if (a!=0 && b!=0 && c!=0 && a + b > c && b + c > a && a + c > b) {
            return true;
        }
       else return false;
    }
}
