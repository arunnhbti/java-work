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

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortGroupby
{

    public static void main(String[] args)
    {
        List<Record> records = new ArrayList<Record>()
        {
            {
                this.add(new Record("1", "A", "D1", 10_000_000, "L2"));
                this.add(new Record("2", "B", "D1", 6_000_000, "L1"));
                this.add(new Record("3", "C", "D1", 7_000_000, "L1"));
                this.add(new Record("4", "D", "D2", 3_000_000, "L1"));
                this.add(new Record("5", "E", "D2", 9_000_000, "L2"));
                this.add(new Record("6", "F", "D3", 11_000_000, "L2"));
                this.add(new Record("7", "G", "D3", 12_000_000, "L2"));
                this.add(new Record("8", "H", "D3", 12_000_000, "L2"));
                this.add(new Record("9", "I", "D4", 15_000_000, "L3"));
            }
        };

        //Group by department and average salary per department.
        records.stream()
                .sorted(comparing(Record::getDepartment))
                .collect(groupingBy(Record::getDepartment, averagingDouble(Record::getSalary)))
                .forEach((s, aDouble) -> System.out.println(s + " : " + aDouble));

        //Average salary by group by department & level.
        records.stream()
                .sorted(comparing(Record::getDepartment))
                .collect(groupingBy(Record::getDepartment, groupingBy(Record::getLevel, averagingDouble(Record::getSalary))))
                .forEach((s, intMap) -> System.out.println(s + " : " + intMap));
    }

}
