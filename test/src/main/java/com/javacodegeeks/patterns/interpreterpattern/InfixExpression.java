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

public class InfixExpression implements Expression
{

    private String infixExpression;
    private PostfixExpression postfixExpression;

    public InfixExpression(String infixExpression, PostfixExpression postfixExpression)
    {
        this.infixExpression = infixExpression;
        this.postfixExpression = postfixExpression;
    }

    @Override
    public int interpret()
    {
        infixToPostfix(infixExpression);
        return postfixExpression.interpret();
    }

    /**
     * The main method that converts given infix expression to postfix expression.
     *
     * @param exp
     * @return
     */
    public String infixToPostfix(String exp)
    {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i)
        {
            char c = exp.charAt(i);

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;

                // If the scanned character is an '(', push it to the stack.
            else if (c == '(')
                stack.push(c);

                //  If the scanned character is an ')', pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression
                else
                    stack.pop();
            }
            // an operator is encountered
            else
            {
                while (!stack.isEmpty() && prec(c) <= prec(stack.peek()))
                    result += stack.pop();
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty())
            result += stack.pop();

        return result;
    }

    /**
     * Precedence of operator
     *
     * @param ch
     * @return
     */
    private static int prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}
