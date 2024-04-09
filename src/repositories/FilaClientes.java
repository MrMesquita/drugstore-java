package repositories;

import entities.Client;

public class FilaClientes {

    private Client[] fila;
    private int tamanho;
    private int inicio, fim;
    private static final int CAPACIDADE_INICIAL = 10;

    public FilaClientes() {
        this.fila = new Client[CAPACIDADE_INICIAL];
        this.tamanho = 0;
        this.inicio = 0;
        this.fim = -1;
    }

    public void enqueue(Client cliente) {
        if (tamanho == fila.length) {
            expandirFila();
        }
        fim = (fim + 1) % fila.length;
        fila[fim] = cliente;
        tamanho++;
    }

    public boolean set(int posicao, Client novoCliente) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Posição inválida");
            return false;
        }
        int realPos = (inicio + posicao) % fila.length;
        fila[realPos] = novoCliente;
        return true;
    }

    public Client dequeue() {
        if (isEmpty()) {
            return null;
        }

        Client clienteRemovido = fila[inicio];
        inicio = (inicio + 1) % fila.length;
        tamanho--;
        return clienteRemovido;
    }

    public Client peek() {
        if (isEmpty()) {
            return null;
        }
        return fila[inicio];
    }


    public boolean isEmpty() {
        return tamanho == 0;
    }


    public int size() {
        return tamanho;
    }

    private void expandirFila() {
        int novaCapacidade = fila.length * 2;
        Client[] novaFila = new Client[novaCapacidade];

        for (int i = 0; i < tamanho; i++) {
            novaFila[i] = fila[(inicio + i) % fila.length];
        }

        fila = novaFila;
        inicio = 0;
        fim = tamanho - 1;
    }

    public Client[] getFila(){
        return this.fila;
    }

    public void printFila() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(fila[(inicio + i) % fila.length] + " ");
        }
        System.out.println();
    }

    public int indexOf(Client cliente) {
        for (int i = 0; i < tamanho; i++) {
            int pos = (inicio + i) % fila.length;
            if (fila[pos].equals(cliente)) {
                return i;
            }
        }
        return -1;
    }
}