package ua.javarush.task.pro.task13.task1314;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void add(String value) {
        if (first.next == null) {
            Node node = new Node();
            node.value = value;
            first.next = node;
        }
        if (last.prev == null) {
            last.prev = first.next;
            return;
        }

        Node node = new Node();
        node.value = value;

        Node lastNode = last.prev;
        lastNode.next = node;
        node.prev = lastNode;
        last.prev = node;
    }

    public String get(int index) {
        //напишіть тут ваш код
        if (first.next == null)
            return null;
        if (last.prev == null)
            return  null;
        Node curent = first.next;
        for (int i = 0;; i++) {
            if (i == index)
                return curent.value;
            else
            {
                if (curent.next != null)
                    curent = curent.next;
                else
                    return null;
            }
        }

    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
