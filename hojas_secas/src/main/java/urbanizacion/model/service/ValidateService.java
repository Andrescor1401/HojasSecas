package urbanizacion.model.service;
import java.io.*;

import urbanizacion.model.bean.House;


public class ValidateService {
    private String filePathHouse = "persistencia/houses.csv";
    private String filepathOwners = "persistencia/propietarios.csv";
    private String filePathCommonArea = "persistencia/areasComunes.csv";
    private String filepathAdmins = "persistencia/admins.csv";

    public boolean validateHouse(int idHouse) {
            boolean found = false;
            BufferedReader buffer = null;
            try {
                buffer = new BufferedReader(new FileReader(filePathHouse));
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

    public boolean validateIdOwner(int id){
        boolean found = false;
            BufferedReader buffer = null;
            try {
                buffer = new BufferedReader(new FileReader(filepathOwners));
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
                System.out.println("El propietario debe existir");
            }
            return false;
    }

    public boolean validateCredentials(int id, int password) {
        boolean found = false;
        BufferedReader buffer = null;
        try {
            buffer = new BufferedReader(new FileReader(filepathOwners));
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

    public boolean validateIdToCreateOwner(int id){
        boolean found = false;
            BufferedReader buffer = null;
            try {
                buffer = new BufferedReader(new FileReader(filepathOwners));
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
            }
            return false;
    }
    
    public boolean validateIdToCreateHouse(int idHouse) {
        boolean found = false;
        BufferedReader buffer = null;
        try {
            buffer = new BufferedReader(new FileReader(filePathHouse));
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
                        found = true;
                        System.out.println("House already exist");
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
        }
        return false;
}

public boolean validateIdToCreateCommonArea(int idcommonArea) {
    boolean found = false;
    BufferedReader buffer = null;
    try {
        buffer = new BufferedReader(new FileReader(filePathCommonArea));
        String line = null;
        buffer.readLine();
        while ((line = buffer.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue; 
            }
            String[] parts = line.split(";");
            if (parts.length != 6) {
                System.out.println("Línea malformada: " + line);
                continue; 
            }
            try {
                int commonAreaId = Integer.parseInt(parts[0].trim());
                if (commonAreaId == idcommonArea) {
                    found = true;
                    System.out.println("Common area already exist");
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
    }
    return false;
}
    public boolean validateTypeProperty(int idProperty){
        if(idProperty<0){
            //si el id es negativo es un area común
            return true;
        }
        //si es positivo es una casa
        return false ;
    }
    public boolean validateTypeUser(int idUser){
        if(idUser<0){
            return true;
            //admin
        }
        return false;
        //propietario
    }
    

    public boolean validateCommonArea(int idcommonArea){
        boolean found = false;
            BufferedReader buffer = null;
            try {
                buffer = new BufferedReader(new FileReader(filePathCommonArea));
                String line = null;
                buffer.readLine();
                while ((line = buffer.readLine()) != null) {
                    if (line.trim().isEmpty()) {
                        continue; 
                    }
                    String[] parts = line.split(";");
                    if (parts.length != 6) {
                        System.out.println("Línea malformada: " + line);
                        continue; 
                    }
                    try {
                        int commonAreaId = Integer.parseInt(parts[0].trim());
                        if (commonAreaId == idcommonArea) {
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
                System.out.println("Common Area not found");
            }
            return false;
    }

    public boolean validateIdToCreateAdmin(int idAdmin){
        boolean found = false;
            BufferedReader buffer = null;
            try {
                buffer = new BufferedReader(new FileReader(filepathAdmins));
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
                        int userAdminId = Integer.parseInt(parts[1].trim());
                        if (userAdminId == idAdmin || idAdmin>0) {
                            System.out.println("User admin already exist or id invalid");
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
            }
            return false;
    }

    public double getSquareMetersFromHouse(int idHouse) {
        BufferedReader buffer = null;
        boolean found = false;
        try {
            buffer = new BufferedReader(new FileReader(filePathHouse));
            String line = null;
            buffer.readLine(); // Salta la primera línea si es un encabezado
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
                        double squareMeters = Double.parseDouble(parts[3].trim()); 
                        found = true;
                        return squareMeters; // Retorna los metros cuadrados de la casa
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
                    System.out.println("Error al cerrar el buffer: " + e.getMessage());
                }
            }
        }if(!found){
            System.out.println("House not found");
        }
        return -1; // Retorna -1 si la casa no fue encontrada
    }
  
    public House foundHouseById(int idHouse) {
        boolean found = false;
        BufferedReader buffer = null;
        try {
            buffer = new BufferedReader(new FileReader(filePathHouse));
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
                        found = true;
                        int idOwner = Integer.parseInt(parts[1].trim());
                        double currentBalance = Double.parseDouble(parts[2].trim());
                        double squareMeters = Double.parseDouble(parts[3].trim());
                        return new House(houseId,idOwner,currentBalance,squareMeters);
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
        }
        return null;
}

public boolean validateCredentialsAdmins(int id, int password) {
    boolean found = false;
    BufferedReader buffer = null;
    try {
        buffer = new BufferedReader(new FileReader(filepathAdmins));
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
}  


