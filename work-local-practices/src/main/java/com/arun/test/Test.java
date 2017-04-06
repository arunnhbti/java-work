package com.arun.test;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        enumI enumI = TestEnum.SAMPLE;
        System.out.println(enumI.getValue());
        enumI.setValue("TEST");
        System.out.println(enumI.getValue());
    }

}
