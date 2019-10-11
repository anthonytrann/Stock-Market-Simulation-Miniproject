public class Portfolio
{
    private double profit;
    private double value;
    
    public Portfolio(){
    
        profit = 0;
    
    }
    
    public double getProfit(){
    
        return profit;
    
    }
    
    public void setProfit(double newProfit){
        
        profit = newProfit;
        
    }

    public double getValue(){

        return value;

    }

    public void setValue(double value){

        this.value = value;

    }

    
}
