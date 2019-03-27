// **********************************************************************
// Copyright (c) 2018 Telefonaktiebolaget LM Ericsson, Sweden.
// All rights reserved.
// The Copyright to the computer program(s) herein is the property of
// Telefonaktiebolaget LM Ericsson, Sweden.
// The program(s) may be used and/or copied with the written permission
// from Telefonaktiebolaget LM Ericsson or in accordance with the terms
// and conditions stipulated in the agreement/contract under which the
// program(s) have been supplied.
// **********************************************************************
package com.javacodegeeks.patterns.interpreterpattern;

import java.util.Stack;

public class PostfixExpression implements Expression
{
    private String postfixExpression;

    public PostfixExpression(String postfixExpression)
    {
        this.postfixExpression = postfixExpression;
    }

    @Override
    public int interpret()
    {
        Stack<Expression> stack = new Stack<>();
        String[] tokenArray = postfixExpression.split(" ");
        for (String s : tokenArray)
        {
            if (ExpressionUtils.isOperator(s))
            {
                Expression rightExpression = stack.pop();
                Expression leftExpression = stack.pop();
                Expression operator = ExpressionUtils.getOperator(s, leftExpression, rightExpression);
                int result = operator.interpret();
                stack.push(new Number(result));
            } else
            {
                Expression i = new Number(Integer.parseInt(s));
                stack.push(i);
            }
        }
        return stack.pop().interpret();
    }
}
