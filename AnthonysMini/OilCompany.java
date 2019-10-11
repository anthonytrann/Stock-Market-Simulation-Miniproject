public class OilCompany extends Stock
{
    private double populationTax;
    private double oilExploration;
    private double amount;

    public OilCompany(){

        super("Oil Company",0);

    }

    public double getPopulationTax(){

        return populationTax;

    }

    public void setPopulationTax(){

        populationTax = Math.random();
        amount = getPrice() * populationTax;
        setPrice(amount);

    }

    public double getOilExploration(){

        return oilExploration;

    }

    public void setOilExploration(){

        oilExploration = 1 + Math.random();
        amount = getPrice() * oilExploration;
        setPrice(amount);
    }

}
