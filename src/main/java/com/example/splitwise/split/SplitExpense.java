package com.example.splitwise.split;

import com.example.splitwise.Member;
import com.example.splitwise.Model.ExpenseMemberSplit;

import java.util.List;

public interface SplitExpense {

    public List<ExpenseMemberSplit> split(List<Member> members, List<Float> weight, Member payee, Float amount);

}
