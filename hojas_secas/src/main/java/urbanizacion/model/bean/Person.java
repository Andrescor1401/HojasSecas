package urbanizacion.model.bean;

public class Person {
    private String name;
    private int id;
    private int age;
    private String mail;
    private String phoneNumber;
    private int password;

    public Person(String name, int id,int age,String mail,String phoneNumber,int password){
        this.name = name;
        this.id = id;
        this.age = age;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public int getAge(){
        return age;
    }
    public String getMail() {
        return mail;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public int getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", id=" + id + ", age=" + age +", mail=" + mail + ", phoneNumber=" + phoneNumber + ", password="
                + password + "]";
    }
    
   
    
}
