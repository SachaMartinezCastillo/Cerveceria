package Models;

public class BeerConsumer extends Thread
{
    private  BeerHouse Brewery;

    public BeerConsumer(BeerHouse BH)
    {
            Brewery = BH;
    }

    public void run()
    {
        while (Brewery.GetStock() > 0)
        {
            Brewery.RemoveBeer();

        }
    }
}
