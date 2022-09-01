package com.example.splitwise;

import com.example.splitwise.Model.ExpenseMemberSplit;
import com.example.splitwise.split.SplitExpense;

import java.util.*;

public class Member {

    private String name;
    private final HashMap<Member, Float> expenses;

    public Member(String name) {
        this.name = name;
        this.expenses = new HashMap<>();
    }

    public synchronized boolean addExpense(float amount, Group group, SplitExpense splitExpense) {
        if (!group.getMembers().contains(this)) {
            return false;
        }
        List<ExpenseMemberSplit> memberExpenses = splitExpense.split(group.getMembers(), List.of(), this, amount);
        memberExpenses
                .forEach(memberExpense -> {
                        this.expenses.put(memberExpense.getMember(),
                                this.expenses.getOrDefault(memberExpense.getMember(), 0f)
                                        + memberExpense.getAmount());
                        memberExpense.getMember().addExpense(memberExpense.getAmount(), this);
                });
        return true;
    }

    public synchronized void addExpense(float amount, Member member) {
        this.expenses.put(member, this.expenses.getOrDefault(member, 0.0f) - amount);
    }

    public synchronized void addDebt(float amount, Member member) {
        this.expenses.put(member, this.expenses.getOrDefault(member, 0.0f) + amount);
    }

    public HashMap<Member, Float> viewExpense() {
        return expenses;
    }

    public boolean settleExpense(Member member, float amount) {
        if (amount <= 0 ) {
            return false;
        }
        if (!expenses.containsKey(member))  {
            return false;
        }
        expenses.put(member, expenses.get(member) - amount);
        member.addExpense(-amount, this);
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return this.name.equals(member.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
