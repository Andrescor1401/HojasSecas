package urbanizacion.model.service;
import urbanizacion.model.bean.House;
import urbanizacion.model.bean.Invoice;
import java.util.List;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HouseService {
    protected static String filePath = "persistencia/houses.csv";
    private static String filePath2 = "persistencia/propietarios.csv";
    private InvoiceService invoice = new InvoiceService();
    

    public void createHouse(int idProperty, int idOwner,double currentBalance,double squareMeters){
        House newHouse = new House(idProperty, idOwner, currentBalance,squareMeters);
        if(validateId(idOwner)){
            saveHouse(newHouse);
            System.out.println("La casa fue creada y asignada a su propietario");
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
    public boolean validateHouse(int idHouse) {
        boolean found = false;
        BufferedReader buffer = null;
        try {
            buffer = new BufferedReader(new FileReader(filePath));
            String line = null;
            buffer.readLine();
            while ((line = buffer.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; 
                }
                String[] parts = line.split(";");
                if (parts.length != 4) {
                    System.out.println("Línea malformada: " + line);
                    continue; 
                }
                try {
                    int houseId = Integer.parseInt(parts[0].trim());
                    if (houseId == idHouse) {
                        System.out.println("Acceso valido");
                        found = true;
                        return true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error de formato de número en la línea: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error en el programa: " + e.getMessage());
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar: " + e.getMessage());
                }
            }
        }if(!found){
            System.out.println("House not found");
        }
        return false;
    }
    public boolean validateId(int id){
        boolean found = false;
        BufferedReader buffer = null;
        try {
            buffer = new BufferedReader(new FileReader(filePath2));
            String line = null;
            buffer.readLine();
            while ((line = buffer.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; 
                }
                String[] parts = line.split(";");
                if (parts.length != 8) {
                    System.out.println("Línea malformada: " + line);
                    continue; 
                }
                try {
                    int userId = Integer.parseInt(parts[1].trim());
                    if (userId == id) {
                        System.out.println("User already exist");
                        found = true;
                        return true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error de formato de número en la línea: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error en el programa: " + e.getMessage());
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar: " + e.getMessage());
                }
            }
        }if(!found){
            System.out.println("datos incorrectos");
        }
        return false;
    }
    
    public void printInvoicesHouse(int idHouse){
         List<Invoice> invoices = invoice.loadInvoicesFromJson();
            for (Invoice inv : invoices) {
                int idProperty = inv.getIdProperty(); 
                if(idProperty == idHouse){
                    System.out.println(inv);
                }else{
                    System.out.println("no hay casa");
                }
                
            }
    }
    public static void main(String[] args) {
        HouseService hou = new HouseService();
        //hou.createHouse(1, 11, 0, 70);
        hou.printInvoicesHouse(101);
    }


    
}
