class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {

        Node head;
        Node tail;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        void addNode(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        Node removeLast() {
            if (head.next == tail) {
                return null;
            }

            Node node = tail.prev;
            removeNode(node);

            return node;
        }

        boolean isEmpty() {
            return head.next == tail;
        }
    }

    HashMap<Integer, Node> map;
    HashMap<Integer, DoublyLinkedList> freqMap;

    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();
        freqMap = new HashMap<>();

        minFreq = 0;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            increaseFrequency(node);

            return;
        }

        if (map.size() == capacity) {

            DoublyLinkedList list = freqMap.get(minFreq);

            Node removed = list.removeLast();

            map.remove(removed.key);
        }

        Node newNode = new Node(key, value);

        map.put(key, newNode);

        freqMap
            .computeIfAbsent(1, k -> new DoublyLinkedList())
            .addNode(newNode);

        minFreq = 1;
    }

    private void increaseFrequency(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);

        oldList.removeNode(node);

        if (oldFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        node.freq++;

        freqMap
            .computeIfAbsent(node.freq,
                    k -> new DoublyLinkedList())
            .addNode(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */