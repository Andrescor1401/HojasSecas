package urbanizacion.model.bean;

public class Invoice {
    private int idVoice;
    private String dateVoice;
    private int idProperty;
    private String status;
    private Fine fine;
    private double amountPay;
    public Invoice(){}

    public Invoice(int idVoice, String dateVoice,int idProperty, double amountPay,String status){
        this.idVoice = idVoice;
        this.dateVoice = dateVoice;
        this.amountPay = amountPay;
        this.idProperty = idProperty;
        this.status = status;
    }
    public void setAmountPay(double amountPay) {
        this.amountPay = amountPay;
    }
    public double getAmountPay() {
        return amountPay;
    }
    public void setDateVoice(String dateVoice) {
        this.dateVoice = dateVoice;
    }
    public void setIdProperty(int idProperty) {
        this.idProperty = idProperty;
    }
    public void setIdVoice(int idVoice) {
        this.idVoice = idVoice;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDateVoice() {
        return dateVoice;
    }
    public int getIdProperty() {
        return idProperty;
    }
    public int getIdVoice() {
        return idVoice;
    }
    public String getStatus() {
        return status;
    }
    public void setFine(Fine fine) {
        this.fine = fine;
    }
    public Fine getFine() {
        return fine;
    }
    @Override
    public String toString() {
        return "Invoice [idVoice=" + idVoice + ", dateVoice=" + dateVoice + ", idProperty=" + idProperty + ", amountPay="+ amountPay + ", status="
                + status + ", fine=" +fine+ "]";
    }
    
}
