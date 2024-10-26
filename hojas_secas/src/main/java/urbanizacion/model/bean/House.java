package urbanizacion.model.bean;

public class House extends Property  {

    private int intOwner;
    private double currentBalance;
    private double squareMeters;

    public House(){}
    public House(int idProperty, int intOwner,double currentBalance,double squareMeters){
        super(idProperty);
        this.intOwner = intOwner;
        this.currentBalance = currentBalance;
        this.squareMeters = squareMeters;
    }
    public void setIntOwner(int intOwner) {
        this.intOwner = intOwner;
    }
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
    public void setSquareMeters(double squareMeters) {
        this.squareMeters = squareMeters;
    }
    public double getCurrentBalance() {
        return currentBalance;
    }
    public int getIntOwner() {
        return intOwner;
    }
    public double getSquareMeters() {
        return squareMeters;
    }
    @Override
    public String toString() {
        return "House [intOwner=" + intOwner + ", currentBalance=" + currentBalance + ", squareMeters=" + squareMeters
                + "]";
    }
    

    
}
