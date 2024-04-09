package repositories;

import entities.Drug;

import java.util.EmptyStackException;

public class PilhaDrugs {

    private Drug[] pilha;
    private int tamanho;
    private static final int CAPACIDADE_INICIAL = 10;

    // Construtor
    public PilhaDrugs() {
        this.pilha = new Drug[CAPACIDADE_INICIAL];
        this.tamanho = 0;
    }

    public void push(Drug drug) {
        if (tamanho == pilha.length) {
            expandirPilha();
        }
        pilha[tamanho++] = drug;
    }

    public Drug pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Drug drugRemovido = pilha[--tamanho];
        pilha[tamanho] = null; // Limpar referência para evitar vazamento de memória
        return drugRemovido;
    }

    public Drug[] getPilha(){
        return this.pilha;
    }

    public Drug peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return pilha[tamanho - 1];
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }

    public int indexOf(Drug drug) {
        for (int i = 0; i < tamanho; i++) {
            if (pilha[i].equals(drug)) {
                return i;
            }
        }
        return -1;
    }

    public void set(int index, Drug drug) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException();
        }
        pilha[index] = drug;
    }

    private void expandirPilha() {
        int novaCapacidade = pilha.length * 2;
        Drug[] novaPilha = new Drug[novaCapacidade];
        System.arraycopy(pilha, 0, novaPilha, 0, tamanho);
        pilha = novaPilha;
    }
}
