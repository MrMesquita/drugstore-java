package entities;

public class Pearson {
    private String name;
    private int document;
    private int telephone;

    public Pearson(String name, String document, int telephone) {
        this.name = name;
        this.document = document;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}
