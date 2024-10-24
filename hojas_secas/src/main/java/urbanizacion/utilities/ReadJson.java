package urbanizacion.utilities;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import urbanizacion.model.service.InvoiceService;

import com.google.gson.reflect.TypeToken;

import urbanizacion.model.bean.Invoice;

public class ReadJson {
    private Gson gson = new Gson();
    private String json = "persistencia/Invoice.json";
    public void readJson(){
        try {
            FileReader reader = new FileReader(json);
            Type invoiceListType = new TypeToken<List<Invoice>>() {}.getType();

            // Deserializar el JSON a una lista de objetos Person
            List<Invoice> invoices = gson.fromJson(reader, invoiceListType);

            // Mostrar todas las personas
            for (Invoice invoice : invoices) {
                System.out.println(invoice);
            }
            //Fine fine = gson.fromJson(reader, Fine.class);
            //System.out.println(fine);
            System.out.println("hola, lo leí");
            reader.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
