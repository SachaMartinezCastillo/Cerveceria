import Models.BeerConsumer;
import Models.BeerHouse;
import Models.BeerProducer;

public class Main
{
    public static void main(String[] args)
    {
        BeerHouse BrewHouse = new BeerHouse();
        BeerProducer Producer1 = new BeerProducer(BrewHouse);
        BeerConsumer Consumer1 = new BeerConsumer(BrewHouse);
        Producer1.start();
        Consumer1.start();
    }
}
