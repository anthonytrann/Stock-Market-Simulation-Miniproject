
public class Stock
{
    private String name;
    private double price;
    private double quantity;
    private double lastPrice = 0;
    private boolean random;
    
    public Stock(String name, double quantity){
        
        this.name = name;
        this.quantity = quantity;
        random = (Math.random() < 0.5 ? true : false);

        if(random == true){
            price = (0.6*Math.random())*100;
        } else {
            price = (0.6*Math.random())*40;
        }
        
    }
    
    public String getName(){
        
        return name;
        
    }
    
    public double getPrice(){
        
        return price;
        
    }

    public void setPrice(double amount){

        price = amount;

    }
    
    public double getQuantity(){
    
        return quantity;
    
    }
    
    public void addQuantity(double amount){
        
        quantity += amount;
        
    }
    
    public void takeQuantity(double amount){
        
       quantity -= amount; 
        
    }

    public void setQuantity(double quantity){

        this.quantity = quantity;

    }

    public double getLastPrice(){

        return lastPrice;

    }

    public void setLastPrice(double lastPrice) {

        this.lastPrice = lastPrice;

    }
}
