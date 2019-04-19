package com.sdsoon;

public class Boss implements Person {

    @Override
    public void eat() {
        System.out.println("享受美食");
    }

    @Override
    public void sleep() {
        System.out.println("享受睡眠");
    }

}
