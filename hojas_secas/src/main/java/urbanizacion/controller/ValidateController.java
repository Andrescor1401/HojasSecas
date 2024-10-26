package urbanizacion.controller;

import urbanizacion.model.service.ValidateService;

public class ValidateController {
    private ValidateService validate;

    public ValidateController(){
        this.validate = new ValidateService();
    }
    public boolean validateCredentials(int id, int password){
        return validate.validateCredentials(id, password);
    }
    public boolean validateTypeUser(int id){
        return validate.validateTypeUser(id);
    }
    public boolean validateCredentialsAdmins(int id, int password){
        return validate.validateCredentialsAdmins(id, password);
    }
    public double validateSquareMeters(int idHouse){
        return validate.getSquareMetersFromHouse(idHouse);
    }
    
}
