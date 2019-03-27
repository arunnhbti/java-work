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
package com.test.j8;

public class StringCaseReverse
{
    public static void main(String[] args)
    {
        String myString = "MySampleString123";
        System.out.println(myString.chars().map(c -> Character.isLetter(c) ? c ^ ' ' : c).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
    }
}
