package com.javacodegeeks.patterns.interpreterpattern;

public class TestInterpreterPattern
{

    public static void main(String[] args)
    {
        String tokenString = "7 3 - 2 1 + *";
        System.out.println(new PostfixExpression(tokenString).interpret());
    }
}
