package urbanizacion.model.bean;

public class Fine {
    private int idFine;
    private String fineDate;
    private String fineEventDate;
    private String commonArea;
    private int idOwner;
    private String description;
    private int idInvoice;
    private transient Invoice invoice;

    public Fine(){}
    //constructor con el objeto factura
    public Fine(Invoice invoice,int idFine, String fineDate,String fineEventDate,String commonnArea, String description){
        this.invoice = invoice;
        this.idFine = idFine;
        this.fineDate = fineDate;
        this.fineEventDate = fineEventDate;
        this.commonArea = commonnArea;
        this.description = description;
    }
    public Fine(Invoice invoice,int idFine, String fineDate,String fineEventDate,int idOwner, String description){
        this.invoice =invoice;
        this.idFine = idFine;
        this.fineDate = fineDate;
        this.fineEventDate = fineEventDate;
        this.idOwner = idOwner;
        this.description = description;
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
   
    
    @Override
    public String toString() {
        return "Fine [idFine=" + idFine + ", fineDate=" + fineDate + ", fineEventDate=" + fineEventDate
                + ", commonArea=" + commonArea + ", idProperty="  + ", idOwner=" + idOwner
                + ", description=" + description + ",  invoice=" + idInvoice + "]";
    }
    
    
}
