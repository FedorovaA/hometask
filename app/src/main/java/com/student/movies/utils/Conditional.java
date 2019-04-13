package com.student.movies.utils;

public final class Conditional {
    private Conditional(){}

    public static boolean isNotDataEmpty(String str){
        return str.isEmpty();
    }
    public static boolean checkDoublePassword(String password1,String password2){
        return password1.equals(password2);
    }
}
