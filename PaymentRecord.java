package healthcenter;

import java.io.Serializable;

public class PaymentRecord implements Serializable {
    //record's attributes
    private int customer;
    private int age;
    private String gender;
    private double amount;
   
   public PaymentRecord() {
       new PaymentRecord( 0, 0, "", 0.0 ); 
   } 

   public PaymentRecord(int cust, int a, String g, double am)
   {
      setCustomerID(cust);
      setAge(a);
      setGender(g);
      setAmount(am);
   }

   //set customer's id
   public void setCustomerID(int cust) {
      customer = cust;
   }

   //get customer's id
   public int getCustomerID()  { 
      return customer; 
   }

   //set customer's age
   public void setAge(int a) {
      age = a;
   } 

   //get customer's age
   public int getAge() { 
      return age; 
   } 

   //set customer's gender
   public void setGender(String g) {
      gender = g;
   } 

   //get customer's gender
   public String getGender() 
   {
      return gender; 
   } 
   
   //set customer's amount of money to be paid
   public void setAmount(double am) {
      amount = am;
   }

   //get customer's amount of money to be paid
   public double getAmount() { 
      return amount; 
   }
   
   //toString() method
   public String toString() {
       return "CustomerID: " + getCustomerID() + "   Age: " + getAge() + "   Gender: " + getGender() + "   Amount: " + getAmount() + "€\n";
   }
} 
