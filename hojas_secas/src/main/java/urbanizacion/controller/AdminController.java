package urbanizacion.controller;

import urbanizacion.model.bean.Invoice;
import urbanizacion.model.service.InvoiceService;

public class AdminController {
    InvoiceService invoiceService;

    public AdminController(){
        this.invoiceService = new InvoiceService();
    }
    public Invoice createInvoice(int idVoice, String dateVoice, int idProperty, double amountPay,String status){
        return invoiceService.createInvoice(idVoice, dateVoice, idProperty, amountPay, status);
    }
    public void createFineCommonArea(Invoice invoice, int idFine, String fineDate, String fineEventDate, String commonArea, String description){
        invoiceService.createFineCommonArea(invoice, idFine, fineDate, fineEventDate, commonArea, description);
    }
    public void createFineHouse(Invoice invoice,int idFine, String fineDate,String fineEventDate,int idOwner, String description){
        invoiceService.createFineHouse(invoice, idFine, fineDate, fineEventDate, idOwner, description);
    }
    
    
}
