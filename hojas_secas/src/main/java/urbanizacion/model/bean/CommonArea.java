package urbanizacion.model.bean;

public class CommonArea {
    private String description;
    private String startHour;
    private String finishHour;
    private double amountMantenimiento;
    private int capacity;

    public CommonArea(String description, String startHour, String finishHour, double amountMantenimiento, int capacity){
        this.description = description;
        this.startHour = startHour;
        this.finishHour = finishHour;
        this.amountMantenimiento = amountMantenimiento;
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(String finishHour) {
        this.finishHour = finishHour;
    }

    public double getAmountMantenimiento() {
        return amountMantenimiento;
    }

    public void setAmountMantenimiento(double amountMantenimiento) {
        this.amountMantenimiento = amountMantenimiento;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "CommonArea [description=" + description + ", startHour=" + startHour + ", finishHour=" + finishHour
                + ", amountMantenimiento=" + amountMantenimiento + ", capacity=" + capacity + "]";
    }
    

    
}
