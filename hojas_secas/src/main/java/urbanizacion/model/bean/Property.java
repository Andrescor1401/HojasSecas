package urbanizacion.model.bean;

public abstract class Property {
    private int idProperty;

    public Property(int idProperty){
        this.idProperty = idProperty;
    }
    public void setIdProperty(int idProperty) {
        this.idProperty = idProperty;
    }
    public int getIdProperty() {
        return idProperty;
    }
    @Override
    public String toString() {
        return "Property [idProperty=" + idProperty + "]";
    }
    



    
}
