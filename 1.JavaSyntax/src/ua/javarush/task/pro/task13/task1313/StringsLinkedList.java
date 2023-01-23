package ua.javarush.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        if (first.next == null)
            {
                Node current = new Node();
                first.next = current;
                current.value = value;
                //current.prev = last;
                last.prev = current;
            }
        else
            {
             Node pr = last.prev;
                Node newEl = new Node();
             pr.next = newEl;
                newEl.value = value;
                newEl.prev = last.prev;
             last.prev = newEl;


            }

        //напишіть тут ваш код
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
