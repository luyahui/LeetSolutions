package com.lu;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head, tail;
    private int capacity;
    private Map<Integer, Node> map;

    private void addToHead(Node node) {
        if (node.prev != null)
            node.prev.next = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeTail() {
        Node node = tail.prev;
        tail.prev = node.prev;
        tail.prev.next = tail;
        node.prev = null;
        node.next = null;
        map.remove(node.key);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        addToHead(map.get(key));
        return map.get(key).value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            addToHead(map.get(key));
            return;
        }
        if (map.size() >= capacity) {
            removeTail();
        }
        map.put(key, new Node(key, value));
        addToHead(map.get(key));
    }
}

public class Leet146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
