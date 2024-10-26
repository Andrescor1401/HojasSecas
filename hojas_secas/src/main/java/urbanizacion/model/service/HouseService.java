package urbanizacion.model.service;
import urbanizacion.model.bean.House;
import urbanizacion.model.bean.Invoice;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import urbanizacion.model.bean.Fine;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class HouseService {
    
    protected static String filePath = "persistencia/houses.csv";
    private InvoiceService invoice = new InvoiceService();
    private ValidateService validateService = new ValidateService();
    private House house = new House();
    

    public void createHouse(int idProperty, int idOwner,double currentBalance,double squareMeters){
        if(!validateService.validateIdToCreateHouse(idProperty)){
            if(validateService.validateIdOwner(idOwner)){
                House newHouse = new House(idProperty, idOwner, currentBalance,squareMeters);
                saveHouse(newHouse);
                System.out.println("La casa fue creada y asignada a su propietario");
            }
        }
        
        
    }
    private void saveHouse(House house){
        try(BufferedWriter writter = new BufferedWriter(new FileWriter(filePath,true)) ) {
            writter.write(house.getIdProperty() + ";" + house.getIntOwner() + ";" +house.getCurrentBalance()+ ";" +house.getSquareMeters());
            writter.newLine();
            
        } catch (IOException e) {
            System.out.println("Problema con el archivo csv" +e.getMessage());
    
        }
    }
    private void updateHouse(House house) {
    List<String> lines = new ArrayList<>();
    boolean found = false;

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        boolean isFirstLine = true;

        // Leer cada línea y buscar el idProperty de la casa a actualizar
        while ((line = reader.readLine()) != null) {
            // Si la línea es la cabecera, agregarla sin modificaciones y continuar
            if (isFirstLine) {
                lines.add(line);  // Mantener la cabecera
                isFirstLine = false;
                continue;
            }

            String[] parts = line.split(";");

            // Si la línea corresponde a la casa que queremos actualizar
            if (parts.length >= 4 && Integer.parseInt(parts[0]) == house.getIdProperty()) {
                // Actualizar el balance y demás datos de la casa
                line = house.getIdProperty() + ";" + house.getIntOwner() + ";" 
                        + house.getCurrentBalance() + ";" + house.getSquareMeters();
                found = true;
            }
            lines.add(line);
        }
    } catch (IOException e) {
        System.out.println("Problema al leer el archivo CSV: " + e.getMessage());
    }

    if (!found) {
        System.out.println("Casa con id " + house.getIdProperty() + " no encontrada. No se ha actualizado.");
        return;
    }

    // Sobreescribir el archivo con los datos actualizados
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
    } catch (IOException e) {
        System.out.println("Problema al escribir en el archivo CSV: " + e.getMessage());
    }

    System.out.println("La casa con id " + house.getIdProperty() + " se ha actualizado correctamente.");
}

    
    public double amountAdministration(double squareMeters){
        return squareMeters * 315855;
    }

    public void updateBalance(double amount){
     double currentBalance = house.getCurrentBalance();
     house.setCurrentBalance(currentBalance +amount);        
    }

    public List<String> printInvoicesHouse(int idHouse){
         List<Invoice> invoices = invoice.loadInvoicesFromJson();
         List<String> invoicesString = new ArrayList<>();
            for (Invoice inv : invoices) {
                int idProperty = inv.getIdProperty(); 
                if(idProperty == idHouse){
                    invoicesString.add(inv.toString());
                }else{
                    System.out.println("La casa con id: " +idHouse+ " no tiene facturas generadas. ");
                    return null;
                }
                
            }return invoicesString;
    }
    public double getTotalPendingInvoices(int idHouse) {
        double totalPending = 0;
        List<Invoice> invoices = invoice.loadInvoicesFromJson();
    
        for (Invoice invoice : invoices) {
            if (invoice.getIdProperty() == idHouse && invoice.getStatus().equals("Pendiente")) {
                totalPending += invoice.getAmountPay(); 
            }
        }
    
        return totalPending;
    }
    
    

    
    
    
    public static void main(String[] args) {
        HouseService hou = new HouseService();
        //hou.createHouse(1, 11, 0, 70);
        //hou.printInvoicesHouse(101);
        //hou.createHouse(2, 17, 0, 85);
        //hou.payInvoice(3,2);
        System.out.println("La casa debe: " + hou.getTotalPendingInvoices(2));
        //hou.checkAndUpdateHouseBalance(2);
        
    }


    
}
