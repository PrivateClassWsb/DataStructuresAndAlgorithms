package com.wsb.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {

    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        public Node(){}
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache = new HashMap<>();
    private int size;
    private int capacity;
    private Node head, tail;

    public LRUCache_146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null){
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            this.size++;
            if (this.size > this.capacity){
                Node tail = removeTail();
                cache.remove(tail.key);
                this.size--;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node res = this.tail.prev;
        removeNode(res);
        return res;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node newNode) {
        newNode.prev = this.head;
        newNode.next = this.head.next;
        this.head.next.prev = newNode;
        this.head.next = newNode;
    }
}
