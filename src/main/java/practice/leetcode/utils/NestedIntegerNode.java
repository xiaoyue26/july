package practice.leetcode.utils;

import java.util.LinkedList;
import java.util.List;

public class NestedIntegerNode implements NestedInteger {

    @Override
    public boolean isInteger() {
        return isInteger;
    }

    @Override
    public Integer getInteger() {
        return i;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }

    @Override
    public void add(NestedInteger curr) {
        this.list = new LinkedList<>();
        this.list.add(curr);
        isInteger = false;
    }

    private List<NestedInteger> list;
    private Integer i;
    private boolean isInteger;

    public NestedIntegerNode() {
    }

    public NestedIntegerNode(Integer i) {
        this.i = i;
        isInteger = true;
    }

    public void setList(List<NestedInteger> list) {
        this.list = list;
        isInteger = false;
    }

    public void setI(Integer i) {
        this.i = i;
        isInteger = true;
    }

    public static void main(String[] args) {
        NestedIntegerNode obj = new NestedIntegerNode();
        obj.test1();
        System.out.println("there");
    }

    public void test1() {
        System.out.println("here");
    }

}