
package healthcenter;

public class ExercisingPrograms {
    
    //Programs' attributes
    private double price;
    private String name;
    private int duration;

    //empty constructor
    public ExercisingPrograms() {
        setPrice(10);
        setName("Program");
        setDuration(30);
    }
    
    //full constructor
    public ExercisingPrograms(double p, String s, int m) {
        setPrice(p);
        setName(s);
        setDuration(m);
    }
    
    //set program's price
    public void setPrice(double p) {
        price = p;
    }
    
    //set program's duration
    public void setDuration(int m) {
        duration = m;
    }
    
    //get program's price
    public double getPrice() {
        return price;
    }
    
    //set program's name
    public void setName(String s) {
        name = s;
    }
    
    //get program's name
    public String getName() {
        return name;
    }

    //get program's duration
    public int getDuration() {
        return duration;
    }
    
    //toString() method
    public String toString() {
        String message;
        if(getPrice() != 0)
            message = "\nThe " + getName() + " program costs " + getPrice() + "€. and lasts for " + getDuration() + " minutes.\n";
        else
            message = "";
        return message;
    }
    
}
