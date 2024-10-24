package urbanizacion.model.bean;
import java.util.ArrayList;
import java.util.List;

public class Owner extends Person {

    private String profession;
    private String occupation;
    private List<House> home;

    public Owner(String name, int id,int age,String mail,String phoneNumber,int password,String profession, String occupation){
        super(name, id, age,mail, phoneNumber, password);
        this.occupation = occupation;
        this.profession = profession;
        this.home = new ArrayList<>();
    }
    public void setHome(List<House> home) {
        this.home = home;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public List<House> getHome() {
        return home;
    }
    public String getOccupation() {
        return occupation;
    }
    public String getProfession() {
        return profession;
    }
    @Override
    public String toString() {
        return super.toString() + ", Owner [profession=" + profession + ", occupation=" + occupation + ", home=" + home + "]";
    }
    



    
}
