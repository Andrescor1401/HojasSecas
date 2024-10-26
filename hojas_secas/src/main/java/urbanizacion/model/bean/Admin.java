package urbanizacion.model.bean;

public class Admin extends Person{
    private String startDate;
    private String gradeService;

    public Admin(String name, int id,int age, String mail, String phoneNumber, int password,String startDate,String gradeService){
        super(name, id,age, mail, phoneNumber, password);
        this.startDate = startDate;
        this.gradeService = gradeService;
    }

    public void setGradeService(String gradeService) {
        this.gradeService = gradeService;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getGradeService() {
        return gradeService;
    }
    public String getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Admin [startDate=" + startDate + ", gradeService=" + gradeService + "]";
    }
    
    
}
