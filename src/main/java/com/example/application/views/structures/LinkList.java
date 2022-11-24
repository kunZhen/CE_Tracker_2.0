package com.example.application.views.structures;

public class LinkList {
    private Node head = null;
    private int length = 0;

    public LinkList() {
    }

    public void add(Object data) {
        Node node = new Node(data);
        node.setNext(this.head);
        this.setHead(node);
        ++this.length;
    }

    public Node delete() {
        if (this.head != null) {
            Node temp = this.head;
            this.head = this.head.getNext();
            --this.length;
            return temp;
        } else {
            return null;
        }
    }

    public boolean inList(Object find) {
        for(Node temp = this.head; temp != null; temp = temp.getNext()) {
            if (temp.getData().equals(find)) {
                return true;
            }
        }

        return false;
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    static class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }

        public Object getData() {
            return this.data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
