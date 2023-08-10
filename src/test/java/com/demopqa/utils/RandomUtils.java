package com.demopqa.utils;

import java.security.SecureRandom;

public class RandomUtils {
    public static void main(String[] args) {
        RandomUtils randomUtils = new RandomUtils();
        System.out.println(randomUtils.getRandomString(10));
        System.out.println(randomUtils.getRandomString(10));
        System.out.println(randomUtils.getRandomString(10));
    }


    public String getRandomString(int len){
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++)
            sb = sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    public String getRandomEmail(){
        //return getRandomString(15) + '@' + getRandomString(5) + '.' + getRandomString(3);
        return String.format("%s@%s.%s", getRandomString(15), getRandomString(5), getRandomString(5));
    }
}
