public class TechCompany extends Stock
{
    private double faulty;
    private double newProduct;
    private double amount;


    public TechCompany(){

        super("Tech Company",0);

    }

    public double getFaulty(){

        return faulty;

    }

    public void setFaulty() {

        faulty = Math.random();
        amount = getPrice() * amount;
        setPrice(amount);

    }

    public double getNewProduct(){

        return newProduct;

    }

    public void setNewProduct(){

        newProduct = Math.random();
        amount = getPrice() * newProduct;
        setPrice(amount);

    }

}
