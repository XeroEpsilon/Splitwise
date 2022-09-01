package com.example.splitwise.split;

import com.example.splitwise.Member;
import com.example.splitwise.Model.ExpenseMemberSplit;
import com.example.splitwise.split.SplitExpense;

import java.util.List;
import java.util.stream.Collectors;

public class EqualExpenseSplit implements SplitExpense {

    @Override
    public List<ExpenseMemberSplit> split(List<Member> members, List<Float> weight, Member payee, Float amount) {
        return members.stream()
                .filter(member -> !member.equals(payee))
                .map(member -> new ExpenseMemberSplit(member, amount/members.size()))
                .collect(Collectors.toList());
    }
}
