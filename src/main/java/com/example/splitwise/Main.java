package com.example.splitwise;

import com.example.splitwise.split.EqualExpenseSplit;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Member m1 = new Member("m1");
        Member m2 = new Member("m2");
        Member m3 = new Member("m3");
        Member m4 = new Member("m4");
        Member m5 = new Member("m5");

        Group g1 = new Group("g1", List.of(m1, m2, m3));
        Group g2 = new Group("g1", List.of(m1, m3, m4));
        Group g3 = new Group("g1", List.of(m1, m5));
        Group g4 = new Group("g1", List.of(m2, m3, m4));

        m1.addExpense(900, g1, new EqualExpenseSplit());
        m2.addExpense(200, g4, new EqualExpenseSplit());
        m3.addExpense(1800, g2, new EqualExpenseSplit());
        m5.addExpense(11900, g3, new EqualExpenseSplit());

        System.out.println(m1.viewExpense());
        System.out.println(m2.viewExpense());
        System.out.println(m3.viewExpense());
        System.out.println(m4.viewExpense());
        System.out.println(m5.viewExpense());
        System.out.println("\n\n=======\n\n");

        m1.settleExpense(m4, 900);
        m3.settleExpense(m1, 900);
        m2.settleExpense(m1, 900);

        System.out.println(m1.viewExpense());
        System.out.println(m2.viewExpense());
        System.out.println(m3.viewExpense());
        System.out.println(m4.viewExpense());
        System.out.println(m5.viewExpense());
    }

}
