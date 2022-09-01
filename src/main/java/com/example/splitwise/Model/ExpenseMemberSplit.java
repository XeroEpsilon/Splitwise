package com.example.splitwise.Model;

import com.example.splitwise.Member;

public class ExpenseMemberSplit {
    private Member member;
    private Float amount;

    public ExpenseMemberSplit(Member member, Float amount) {
        this.member = member;
        this.amount = amount;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ExpenseMemberSplit{" +
                "member=" + member +
                ", amount=" + amount +
                '}';
    }
}
