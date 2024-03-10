package entities;

public class Employee extends Pearson{
    private int employeeCode;
    private Drugstore drugstore;
    public Employee(String name, String document, int telephone, int employeeCode, Drugstore drugstore) {
        super(name, document, telephone);
        this.employeeCode = employeeCode;
        this.drugstore = drugstore;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Drugstore getDrugstore() {
        return drugstore;
    }

    public void setDrugstore(Drugstore drugstore) {
        this.drugstore = drugstore;
    }
}
