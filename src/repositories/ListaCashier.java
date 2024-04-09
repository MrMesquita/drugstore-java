package repositories;

import entities.Cashier;
import entities.Node;

import java.util.ArrayList;

public class ListaCashier {
    private Node head;
    public ListaCashier() {
        this.head = null;
    }

    public void addFirst(Cashier cashier) {
        Node newNode = new Node(cashier);
        newNode.setNext(head);
        head = newNode;
    }

    public void set(int index, Cashier newCashier) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        current.setCashier(newCashier);
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public void delete(int index) {
        if (index == 0) {
            head = head.getNext();
            return;
        }

        Node current = head;
        Node previous = null;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.getNext();
        }

        previous.setNext(current.getNext());
    }


    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println("Cashier Name: " + current.getCashier().getEmployee().getName() + ", ID: " + current.getCashier().getNumber());
            current = current.getNext();
        }
    }
    public ArrayList<Cashier> getList() {
        ArrayList<Cashier> cashierList = new ArrayList<>();
        Node current = head;
        while (current != null) {
            cashierList.add(current.getCashier());
            current = current.getNext();
        }
        return cashierList;
    }
}
