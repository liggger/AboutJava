package linkedlist;

public class DoubleLinkedList {
    private Node first;
    private Node last;
    private int nodeCount;

    private class Node {
        private int data;
        private Node prev;
        private Node next;

        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Node() {
        }

    }

    /**
     * 插入头部结点
     * @param data
     */
    public void addFirst(int data) {
        Node oldFirst = first;
        first = new Node(data, null, oldFirst);
        if (oldFirst != null) {
            oldFirst.prev = first;
        }
        if (nodeCount == 0) {
            last = first;
        }
        nodeCount ++;
    }

    /**
     * 插入尾部结点
     * @param data
     */
    public void addLast(int data) {
        Node oldLast = last;
        last = new Node(data, oldLast, null);
        if (oldLast != null) {
            oldLast.next = last;
        }
        if (nodeCount == 0) {
            first = last;
        }
        nodeCount ++;
    }

    /**
     * 删除头部结点
     * @return
     */
    public Node delFirst() {
        if (first == null) {
            throw new NullPointerException("No node in linked list.");
        }
        Node result = first;
        first = first.next;
        if (first != null) {
            first.prev = null;
        }
        if (nodeCount == 1) {
            last =null;
        }
        nodeCount--;
        return result;
    }

    /**
     * 删除尾部结点
     * @return
     */
    public Node delLast() {
        if (last == null) {
            throw new NullPointerException("No node in linked list.");
        }
        Node result = last;
        last = last.prev;
        if (last != null) {
            last.next = null;
        }
        if (nodeCount == 1) {
            first = null;
        }
        nodeCount--;
        return result;
    }

    /**
     * 在targetNode的prev插入结点
     * @param targetNode
     * @param data
     */
    public void addBefore(Node targetNode, int data) {
        Node target = first;
        if (target == null) {
            throw new NullPointerException("No node in linked list");
        }
        while (target != null && target != targetNode) {
            target = target.next;
        }
        if (target == null) {
            throw new NullPointerException("Can't find target node.");
        }
        if (target.prev == null) {
            addFirst(data);
        } else {
            Node oldPrev = target.prev;
            Node newNode = new Node();
            newNode.data =data;
            target.prev = newNode;
            newNode.next = target;
            newNode.prev = oldPrev;
            oldPrev.next = newNode;
            nodeCount++;
        }
    }

    /**
     * 在targetNode的next插入结点
     * @param targetNode
     * @param data
     */
    public void addAfter(Node targetNode, int data) {
        Node target = first;
        if (target == null) {
            throw new NullPointerException("No node in linked list");
        }
        while (target != null && target != targetNode) {
            target = target.next;
        }
        if (target == null) {
            throw new NullPointerException("Can't find target node.");
        }
        if (target.next == null) {
            addLast(data);
        } else {
            Node oldNext = target.next;
            Node newNode = new Node();
            newNode.data = data;
            target.next = newNode;
            newNode.prev = target;
            newNode.next = oldNext;
            oldNext.prev = newNode;
            nodeCount++;
        }
    }
}
