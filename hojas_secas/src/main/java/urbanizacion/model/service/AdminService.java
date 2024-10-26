package urbanizacion.model.service;
import urbanizacion.model.bean.Owner;
import urbanizacion.model.bean.Admin;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class AdminService {
    private String filePath = "persistencia/admins.csv";
    private ValidateService validateService =new ValidateService();

    public void createAdmin(String name, int id,int age, String mail, String phoneNumber, int password,String startDate,String gradeService){
        if(!validateService.validateIdToCreateAdmin(id)){
            Admin newAdmin = new Admin(name,id,age,mail,phoneNumber,password,startDate,gradeService);
            saveAdmin(newAdmin);
            System.out.println("El usuario admin fue creado con exito");
        } 
        
    }
    
     private void saveAdmin(Admin admin){
        try(BufferedWriter writter = new BufferedWriter(new FileWriter(filePath,true)) ) {
            writter.write(admin.getName() + ";" + admin.getId() + ";" +admin.getAge()+ ";" +admin.getMail() + ";" +admin.getPhoneNumber() + ";" 
            + admin.getPassword() + ";" + admin.getStartDate() + ";" +admin.getGradeService());
            writter.newLine();
            
        } catch (IOException e) {
            System.out.println("Problema con el archivo csv" +e.getMessage());
    
        }
    }

    public static void main(String[] args) {
        AdminService admin = new AdminService();
        admin.createAdmin("andres", -2, 25, "andresadmin@admin.co", "3104526312", 1401, "2024-10-25", "Excelente");
    }
}
