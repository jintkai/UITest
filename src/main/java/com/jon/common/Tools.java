package com.jon.common;

import org.testng.annotations.Test;

public class Tools {

    public static int getRandomNumber(){
        int i = (int) ((Math.random())*100000000);
        return i;
    }



    @Test
    public void test(){
        System.out.println(getRandomNumber());
    }
}
