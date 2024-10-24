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
    
    public class InvoiceService {
        private Gson gson = new GsonBuilder().setPrettyPrinting().create();
        private String jsonFilePath = "persistencia/Invoice.json"; 
        private List<Invoice> invoices = new ArrayList<>();
    
        public InvoiceService() {
            loadInvoicesFromJson();
        }
    
        public Invoice createInvoice(int idVoice, String dateVoice, int idProperty, String status) {
            Invoice invoice = new Invoice(idVoice, dateVoice, idProperty, status);
            invoices.add(invoice);
            saveInvoicesToJson();
            return invoice;
        }
    
        public void createFine(Invoice invoice, int idFine, String fineDate, String fineEventDate, String commonArea, String description, double fineAmount, String paymentDueDate, double amountPaid, String paymentDate) {
            Fine newFine = new Fine(invoice, idFine, fineDate, fineEventDate, commonArea, description, fineAmount, paymentDueDate, amountPaid, paymentDate);
            invoice.setFine(newFine);
            saveInvoicesToJson();
        }
        public void createFine(Invoice invoice,int idFine, String fineDate,String fineEventDate,int idProperty,int idOwner, String description,double fineAmount, String paymentDueDate,
        double amountPaid,String paymentDate){
            Fine newFine = new Fine(invoice, idFine, fineDate, fineEventDate, idProperty, idOwner, description, fineAmount, paymentDueDate, amountPaid, paymentDate);
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
            //invoiceService.createInvoice(2, "2023-04-05", 104, "Pending");
    
            // Crear y guardar una nueva factura con multa
            //Invoice invoice = invoiceService.createInvoice(3, "2023-04-07", 107, "Completed");
            //invoiceService.createFine(invoice, 1, "2023-04-06", "2023-04-01", "Parking", "Unauthorized parking", 100.0, "2023-04-30", 0.0, null);
            Invoice invoice = invoiceService.createInvoice(5, "2024-05-14", 145, "pendiente");
            invoiceService.createFine(invoice, 8, "2024-1-25", "2024-04-25", 145, 1401, "musica alta", 100000, "2024-5-14", 50000, "2024-10-26");
            // Cargar y mostrar las facturas
            List<Invoice> invoices = invoiceService.loadInvoicesFromJson();
            for (Invoice inv : invoices) {
                System.out.println(inv);
            }
        }
    }
    