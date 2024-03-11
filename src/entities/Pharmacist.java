package entities;

public class Pharmacist extends Employee {
    private int CRF;
    public Pharmacist(String name, int document, int telephone, int employeeCode, Drugstore drugstore, int CRF) {
        super(name, document, telephone, employeeCode, drugstore);
        this.CRF = CRF;
    }

    public int getCRF() {
        return CRF;
    }

    public void setCRF(int CRF) {
        this.CRF = CRF;
    }

}
