package entities;

public class Drug extends Product{
    private boolean is_controlled;
    public Drug(String name, float barcode, int price, boolean is_controlled) {
        super(name, barcode, price);
        this.is_controlled = is_controlled;
    }

    public boolean getIs_controlled() {
        return is_controlled;
    }

    public void setIs_controlled(boolean is_controlled) {
        this.is_controlled = is_controlled;
    }
}
