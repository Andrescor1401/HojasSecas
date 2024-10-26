    package urbanizacion.model.service;
    import urbanizacion.model.bean.Fine;
    import urbanizacion.model.bean.Invoice;
    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;
    import com.google.gson.reflect.TypeToken;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.OutputStreamWriter;
    import java.io.Reader;
    import java.io.Writer;
    import java.lang.reflect.Type;
    import java.nio.charset.StandardCharsets;
    import java.util.ArrayList;
    import java.util.List;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.BufferedReader;

    
    public class InvoiceService {
        private Gson gson = new GsonBuilder().setPrettyPrinting().create();
        private String jsonFilePath = "persistencia/Invoice.json"; 
        private List<Invoice> invoices = new ArrayList<>();
        private ValidateService validateService = new ValidateService();
    
    
        public InvoiceService() {
            loadInvoicesFromJson();
        }
    
        public Invoice createInvoice(int idVoice, String dateVoice, int idProperty, double amountPay,String status) {
            if(!validateService.validateTypeProperty(idProperty)){

                if(!validateService.validateHouse(idProperty)){
                    System.out.println("House with id: " + idProperty + " doesn´t exist");
                    return null;
                }
            }else{

                if(!validateService.validateCommonArea(idProperty)){
                    System.out.println("Area common with id: " +idProperty + " doesn´t exist");
                    return null;
                }
            }        
            Invoice invoice = new Invoice(idVoice, dateVoice, idProperty,amountPay ,status);
            invoices.add(invoice);
            saveInvoicesToJson();
            return invoice;
        }
    
        public void createFineCommonArea(Invoice invoice, int idFine, String fineDate, String fineEventDate, String commonArea, String description) {
            Fine newFine = new Fine(invoice, idFine, fineDate, fineEventDate, commonArea, description);
            invoice.setFine(newFine);
            saveInvoicesToJson();
        }
        public void createFineHouse(Invoice invoice,int idFine, String fineDate,String fineEventDate,int idOwner, String description){
            Fine newFine = new Fine(invoice, idFine, fineDate, fineEventDate, idOwner, description);
            invoice.setFine(newFine);
            saveInvoicesToJson();      
        }
        private void saveInvoicesToJson() {
            try (Writer writer = new OutputStreamWriter(new FileOutputStream(jsonFilePath), StandardCharsets.UTF_8)) {
                gson.toJson(invoices, writer);
                System.out.println("Las facturas se guardaron en el json.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        public List<Invoice> loadInvoicesFromJson() {
            try (Reader reader = new InputStreamReader(new FileInputStream(jsonFilePath), StandardCharsets.UTF_8)) {
                Type invoiceListType = new TypeToken<List<Invoice>>() {}.getType();
                invoices = gson.fromJson(reader, invoiceListType);
                if (invoices == null) {
                    invoices = new ArrayList<>();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return invoices;
        }
    
        public static void main(String[] args) {
            InvoiceService invoiceService = new InvoiceService();
            
            // Crear y guardar una nueva factura sin multa
            //Invoice invoice = invoiceService.createInvoice(4, "2023-04-05",2 ,40000 ,"Pendiente");
            //invoiceService.createFineHouse(invoice, 1, "2024-04-21", "2024-04-21", 1, "Musica muy alta");
            //invoiceService.payInvoice(3, 2);
        }
    }

    