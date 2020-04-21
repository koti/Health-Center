    
package healthcenter;

import java.util.HashMap;

public class Massages {
    
    //massages' attributes
    private double price;
    private String name;
    private int duration;
   
    //empty constructor
    public Massages() {
        setPrice(40);
        setDuration(45);
        setName("Massage");
    }
    
    //full constructor
    public Massages(double p, String n, int m) {
        setPrice(p);
        setDuration(m);
        setName(n);
    }
    
    //set massage's price
    public void setPrice(double p) {
        price = p;
    }
    
    //get massage's price
    public double getPrice() {
        return price;
    }
    
    //set massage's duration
    public void setDuration(int m) {
        duration = m;
    }
    
    //get massage's duration
    public int getDuration() {
        return duration;
    }
    
    //set massage's name
    public void setName(String n){
        name = n;
    }
    
    //get massage's name
    public String getName() {
        return name;
    }
    
    //toString() method
    public String toString() {
        String message;
        if(getPrice() != 0)
            message = "The " + getName() + " massage costs " + getPrice() + "€ and lasts for " + getDuration() + " minutes.\n";
        else message = "";
        return message;
    }
}
