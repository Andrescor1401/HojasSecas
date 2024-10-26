package urbanizacion.model.service;
import urbanizacion.model.bean.CommonArea;
import urbanizacion.model.bean.House;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class CommonAreaService {
    private ValidateService validateService = new ValidateService();
    private String filePath = "persistencia/areasComunes.csv";

    public void createCommonArea(int idProperty,String description, String startHour, String finishHour, double amountMantenimiento, int capacity){
        if(idProperty<0){
            if(!validateService.validateIdToCreateCommonArea(idProperty)){
                CommonArea newCommonArea = new CommonArea(idProperty, description, startHour, finishHour, amountMantenimiento, capacity);
                saveCommonArea(newCommonArea);
            }
        }else{
            System.out.println("Las areas comúnes deben tener id negativo");
        }
        
        
    }
    private void saveCommonArea(CommonArea commonArea){
        try(BufferedWriter writter = new BufferedWriter(new FileWriter(filePath,true))) {
            writter.write(commonArea.getIdProperty() + ";" + commonArea.getDescription() + ";" + commonArea.getStartHour() + ";" +commonArea.getFinishHour()
            + ";" + commonArea.getAmountMantenimiento() + ";" + commonArea.getCapacity());
            writter.newLine();
            
        } catch (IOException e) {
            System.out.println("Problema con el archivo csv" +e.getMessage());
    
        }
    }

    public static void main(String[] args) {
        CommonAreaService area = new CommonAreaService();
        area.createCommonArea(-14, "piscina", "8am", "5pm", 120000, 40);
    }
    
}
