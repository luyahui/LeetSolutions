package com.lu;

import java.util.*;

class LRUCache {
    private class Node{
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    private void moveToHead(Node node){
        if(node == head)
            return;
        if(head == null && tail == null){
            head = node;
            tail = node;
            return;
        }
        if(node == tail)
            tail = node.prev;
        if(node.next != null)
            node.next.prev = node.prev;
        if(node.prev != null)
            node.prev.next = node.next;
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }

    private void removeTail(){
        if(tail == null)
            return;
        if(tail.prev != null){
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            head = null;
            tail = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            // key is in the map already, just need to update the node, and move the node to head
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }
        if(map.size() >= this.capacity){
            // map is full, need to detelet the tail node
            // if(tail == null)
            //     return;
            map.remove(tail.key);
            removeTail();
        }

        Node node = new Node(key, value);
        map.put(key, node);
        moveToHead(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class Leet146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1 /* capacity */);

        cache.put(2, 1);
//        cache.put(2, 2);
        cache.get(2);       // returns 1
        cache.put(3, 2);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4
    }
}
