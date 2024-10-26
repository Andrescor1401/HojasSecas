package urbanizacion.controller;
import java.util.*;

import urbanizacion.model.service.OwnerService;

public class OwnerController {
    private OwnerService owner;

    public OwnerController(){
        this.owner = new OwnerService();
    }
    public void createOwner(String name, int id,int age,String mail,String phoneNumber,int password,String profession, String occupation){
    
        owner.createOwner(name, id, age, mail, phoneNumber, password, profession, occupation);
    }

    public double checkAmountAdministration(int idHouse){
        return owner.checkAmountAdministration(idHouse);
    }

    public String ocupationNeibor(int idVecino){
        return owner.consultNeigborsOccupation(idVecino);
    }

    public List<String> checkVoice(int idHouse){
        return owner.checkVoice(idHouse);
    }

    

        
    


    
    
}
