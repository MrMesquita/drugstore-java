package entities;

public class Node {
    private Cashier cashier;
    private Node next;

    public Node(Cashier cashier) {
        this.cashier = cashier;
        this.next = null;
    }
    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
