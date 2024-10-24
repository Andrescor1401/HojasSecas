package urbanizacion.model.service;
import urbanizacion.model.bean.Invoice;
import urbanizacion.model.bean.Owner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class OwnerService {
    private HouseService house = new HouseService();
    private static String filePath = "persistencia/propietarios.csv";

    public void createOwner(String name,int id,int age, String mail, String phoneNumber, int password, String profession,String occupation){
        Owner newOwner = new Owner(name, id, age,mail, phoneNumber, password, profession, occupation);
        if(!validateId(id)){
            saveOwner(newOwner);
            System.out.println("El usuario fue creado con exito");
        }
        
    }
    private void saveOwner(Owner owner){
        try(BufferedWriter writter = new BufferedWriter(new FileWriter(filePath,true)) ) {
            writter.write(owner.getName() + ";" + owner.getId() + ";" +owner.getAge()+ ";" +owner.getMail() + ";" +owner.getPhoneNumber() + ";" 
            + owner.getPassword() + ";" + owner.getProfession() + ";" +owner.getOccupation());
            writter.newLine();
            
        } catch (IOException e) {
            System.out.println("Problema con el archivo csv" +e.getMessage());
    
        }
    }
    public boolean validateCredentials(int id, int password) {
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
                if (parts.length != 8) {
                    System.out.println("Línea malformada: " + line);
                    continue; 
                }
                try {
                    int userId = Integer.parseInt(parts[1].trim());
                    int validatepassword = Integer.parseInt(parts[5].trim());
                    if (userId == id && validatepassword == password) {
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
            System.out.println("datos incorrectos");
        }
        return false;
    }
    public void consultNeigborsOccupation(int id){
        BufferedReader buffer = null;
        String line = null;
        boolean found = false;
            try {
                buffer = new BufferedReader(new FileReader(filePath));
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
                        if(userId == id){
                            found = true;
                           String ocupattion = (parts[7].trim());
                           System.out.println("La ocupación de tu vecino es " +ocupattion); 
                        }
                    }catch (NumberFormatException e) {
                        System.out.println("Error de formato de número en la línea: " + line);
                    }
    
                }
            }catch (IOException e) {
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
                System.out.println("vecino no encontrado");
            }
        

    }
    public void checkVoice(int idHouse){
        if(house.validateHouse(idHouse)){
            house.printInvoicesHouse(idHouse);
        }
        //house.printInvoicesHouse(idHouse);
        
    }

    public boolean validateId(int id){
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

    public static void main(String[] args) {
        OwnerService oe = new OwnerService();
        //oe.createOwner("luis", 17, 20, "luis.corcho@udea.edu.co", "3214501859", 1401, "Ing sistemas", "reparo pcs");
        //oe.validateCredentials(12, 1401);
        //oe.consultNeigborsOccupation(12);
        oe.checkVoice(1);

       
        
    }
    
}
