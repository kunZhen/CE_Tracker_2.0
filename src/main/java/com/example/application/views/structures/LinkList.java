package com.example.application.views.structures;

public class LinkList {
    private Node head = null;
    private int length = 0;

    public LinkList() {
    }
    /**
     * Add new node in the list
     * */
    public void add(Object data) {
        Node node = new Node(data);
        node.setNext(this.head);
        this.setHead(node);
        ++this.length;
    }
    /**
     * Delete a node in the list
     * */
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
    /**
     * Find a node in the list
     * */
    public boolean inList(Object find) {
        for(Node temp = this.head; temp != null; temp = temp.getNext()) {
            if (temp.getData().equals(find)) {
                return true;
            }
        }

        return false;
    }
    /**
     * Gets head of the list
     * @return head
     * */
    public Node getHead() {
        return this.head;
    }
    /**
     * Set  the head in the list
     * */
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
        /**
         * Gets data of the node
         * @return data
         * */
        public Object getData() {
            return this.data;
        }
        /**
         * Set  the data in the node
         * */
        public void setData(Object data) {
            this.data = data;
        }
        /**
         * Gets  of next
         * @return next
         * */
        public Node getNext() {
            return this.next;
        }

        /**
         * Set  the next
         * */
        public void setNext(Node next) {
            this.next = next;
        }
    }
}
