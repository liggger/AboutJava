package linkedlist;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 */
public class SinglyLinkedList {

    private Node head = null;

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public Node findByValue(int value) {
        Node p = head;

        while (p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    public Node fiindByIndex(int index) {
        Node p = head;
        int pos = 0;

        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }

        return p;
    }

    /**
     * 链表头部插入（输入值）
     * @param value
     */
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    /**
     * 链表头部插入（输入结点）
     * @param newNode
     */
    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 链表尾部插入
     * @param value
     */
    public void insertTail(int value) {
        Node newNode = new Node(value, null);

        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    /**
     * 结点尾部插入（输入值）
     * @param p
     * @param value
     */
    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    /**
     * 结点尾部插入（输入结点）
     * @param p
     * @param newNode
     */
    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;

        newNode.next = p.next;
        p.next = newNode;
    }

    /**
     * 结点头部插入（输入值）
     * @param p
     * @param value
     */
    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    /**
     * 结点头部插入（输入结点）
     * @param p
     * @param newNode
     */
    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;

        if (head == p) {
            insertToHead(newNode);
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;
    }

    /**
     * 删除结点（输入结点）
     * @param p
     */
    public void deleteByNode(Node p) {
        if (p == null || head == null) return;

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }

    /**
     * 删除结点（根据值）
     * @param value
     */
    public void deleteByValue(int value) {
        if (head == null) return;

        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) {
            return;
        }

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }

    /**
     * 打印链表
     */
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * 判断链表是否相等
     * @param left
     * @param right
     * @return
     */
    public boolean isEqual(Node left, Node right) {
        Node l = left;
        Node r = right;

        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
                continue;
            } else {
                break;
            }
        }

        if (l == null && r == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否回文
     * @return
     */
    public boolean isPalindrome() {
        if (head == null) {
            return false;
        } else {
            Node p = head;
            Node q = head;
            if (p.next == null) {
                return true;
            }

            while (q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;
            }

            Node leftLink = null;
            Node rightLink = null;
            if (q.next == null) {
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
            } else {
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }
            return isEqual(leftLink, rightLink);
        }
    }

    /**
     * 带结点的链表翻转
     * @param p
     * @return
     */
    public Node inverseLinkList_head(Node p) {
        Node Head = new Node(9999, null);
        Head.next = p;

        Node Cur = p.next;
        p.next = null;
        Node next = null;

        while(Cur != null){
            next = Cur.next;
            Cur.next = Head.next;
            Head.next = Cur;

            Cur = next;
        }

        return Head;
    }

    /**
     * 无头结点的链表翻转
     * @param p
     * @return
     */
    public Node inverseLinkList(Node p) {
        Node pre = null;
        Node r = head;
        Node next= null;
        while(r !=p){
            next = r.next;

            r.next = pre;
            pre = r;
            r = next;
        }

        r.next = pre;
        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return r;
    }

    public static void main(String[]args){

        SinglyLinkedList link = new SinglyLinkedList();
        System.out.println("hello");
        //int data[] = {1};
        //int data[] = {1,2};
        //int data[] = {1,2,3,1};
        //int data[] = {1,2,5};
        //int data[] = {1,2,2,1};
        // int data[] = {1,2,5,2,1};
        int data[] = {1,2,5,3,1};

        for(int i =0; i < data.length; i++){
            //link.insertToHead(data[i]);
            link.insertTail(data[i]);
        }
        // link.printAll();
        // Node p = link.inverseLinkList_head(link.head);
        // while(p != null){
        //     System.out.println("aa"+p.data);
        //     p = p.next;
        // }

        System.out.println("打印原始:");
        link.printAll();
        if (link.isPalindrome()){
            System.out.println("回文");
        }else{
            System.out.println("不是回文");
        }
    }
}
