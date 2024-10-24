package urbanizacion.model.bean;

import java.util.Date;

public class Admin extends Person{
    private Date startDate;
    private String gradeService;

    public Admin(String name, int id,int age, String mail, String phoneNumber, int password,Date startDate,String gradeService){
        super(name, id,age, mail, phoneNumber, password);
        this.startDate = startDate;
        this.gradeService = gradeService;
    }

    public void setGradeService(String gradeService) {
        this.gradeService = gradeService;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public String getGradeService() {
        return gradeService;
    }
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Admin [startDate=" + startDate + ", gradeService=" + gradeService + "]";
    }
    
    
}
