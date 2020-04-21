package healthcenter;

public class Snacks {
    
    //Snacks' attributes
    private double price;
    private String name;
    private int calories;
    
    //empty constructor
    public Snacks() {
        setPrice(3);
        setName("Snack");
        setCalories(400);
    }
    
    //full constructor
    public Snacks(double p, String n, int c) {
        setPrice(p);
        setName(n);
        setCalories(c);
    }
    
    //set snack's price
    public void setPrice(double p) {
        price = p;
    }
    
    //get snack's price
    public double getPrice() {
        return price;
    }
    
    //set snack's name
    public void setName(String n) {
        name = n;
    }
    
    //get snack's name
    public String getName() {
        return name;
    }
    
    //set snack's calories
    public void setCalories(int c) {
        calories = c;
    }
    
    //get snack's calories
    private int getCalories() {
        return calories;
    }
    
    //toString() method
    public String toString() {
        String message;
        if(getPrice() != 0)
            message = "The " + getName() + " costs " + getPrice() + "€ and contains " + getCalories() + " calories.\n";
        else
            message = "";
        return message;
    }
}
