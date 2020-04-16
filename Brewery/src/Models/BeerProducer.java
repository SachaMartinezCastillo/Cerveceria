package Models;

public class BeerProducer extends Thread
{
    private BeerHouse Brewery;

    public BeerProducer(BeerHouse BH)
    {
        Brewery = BH;
    }

  // @Override                                               esto lo dude de si va o no porque estarias sobrescribiendo el metodo de la clase Thread
    public void run()
    {
        while (Brewery.GetStock() < 100)
        {
            Brewery.AddBeer(1);

        }
    }


}
