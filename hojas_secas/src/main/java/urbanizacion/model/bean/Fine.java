package urbanizacion.model.bean;

public class Fine {
    private int idFine;
    private String fineDate;
    private String fineEventDate;
    private String commonArea;
    private int idProperty;
    private int idOwner;
    private String description;
    private double fineAmount;
    private String paymentDueDate;
    private double amountPaid;
    private String paymentDate;
    private int idInvoice;
    private transient Invoice invoice;

    public Fine(){}
    //constructor con el objeto factura
    public Fine(Invoice invoice,int idFine, String fineDate,String fineEventDate,String commonnArea, String description,double fineAmount, String paymentDueDate,
    double amountPaid,String paymentDate){
        this.invoice = invoice;
        this.idFine = idFine;
        this.fineDate = fineDate;
        this.fineEventDate = fineEventDate;
        this.commonArea = commonnArea;
        this.description = description;
        this.fineAmount = fineAmount;
        this.paymentDueDate = paymentDueDate;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
    }
    public Fine(Invoice invoice,int idFine, String fineDate,String fineEventDate,int idProperty,int idOwner, String description,double fineAmount, String paymentDueDate,
    double amountPaid,String paymentDate){
        this.invoice =invoice;
        this.idFine = idFine;
        this.fineDate = fineDate;
        this.fineEventDate = fineEventDate;
        this.idProperty = idProperty;
        this.idOwner = idOwner;
        this.description = description;
        this.fineAmount = fineAmount;
        this.paymentDueDate = paymentDueDate;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
    }
    public Invoice getObjetcInvoice(){
        return invoice;
    }
    public void setObjectInvoice(Invoice invoice){
        this.invoice = invoice;
    }
    public void setInvoice(int invoice) {
        this.idInvoice = invoice;
    }
    public int getInvoice() {
        return idInvoice;
    }
    public int getIdFine() {
        return idFine;
    }
    public void setIdFine(int idFine) {
        this.idFine = idFine;
    }
    public String getFineDate() {
        return fineDate;
    }
    public void setFineDate(String fineDate) {
        this.fineDate = fineDate;
    }
    public String getFineEventDate() {
        return fineEventDate;
    }
    public void setFineEventDate(String fineEventDate) {
        this.fineEventDate = fineEventDate;
    }
    public String getCommonArea() {
        return commonArea;
    }
    public void setCommonArea(String commonArea) {
        this.commonArea = commonArea;
    }
    public int getIdProperty() {
        return idProperty;
    }
    public void setIdProperty(int idProperty) {
        this.idProperty = idProperty;
    }
    public int getIdOwner() {
        return idOwner;
    }
    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getFineAmount() {
        return fineAmount;
    }
    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }
    public String getPaymentDueDate() {
        return paymentDueDate;
    }
    public void setPaymentDueDate(String paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }
    public double getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
    public String getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
    @Override
    public String toString() {
        return "Fine [idFine=" + idFine + ", fineDate=" + fineDate + ", fineEventDate=" + fineEventDate
                + ", commonArea=" + commonArea + ", idProperty=" + idProperty + ", idOwner=" + idOwner
                + ", description=" + description + ", fineAmount=" + fineAmount + ", paymentDueDate=" + paymentDueDate
                + ", amountPaid=" + amountPaid + ", paymentDate=" + paymentDate + ", invoice=" + idInvoice + "]";
    }
    
    
}
