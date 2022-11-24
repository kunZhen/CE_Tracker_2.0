package com.example.application.views.structures;

public class Stack {
    private LinkList list;
    public Stack() {
    }

    public void push(Object data) {
        this.list.add(data);
    }

    public Object pop() {
        return this.list.delete();
    }

    public Object peek() {
        return this.list.getHead();
    }
}
