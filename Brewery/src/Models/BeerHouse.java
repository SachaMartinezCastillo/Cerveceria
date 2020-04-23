package Models;

public class BeerHouse
{
    private int Stock;
    public static final int MaxStock = 100;
    public static final int MinStock = 0;
    private boolean Available = false;

    public BeerHouse()
    {
        Stock = 0;
    }

    public  void ToggleAvailable()
    {
        boolean aux;
        aux = (Available) ? false : true;
        Available = aux;
    }

    public synchronized void AddBeer(int Cant)
    {
        while (Available )
        {
            try {
            wait();
            }
            catch (InterruptedException e)
            {
                System.out.println("se interrumpio el add" + e);
            }
        }
        Stock += Cant;
        System.out.println(this.GetStock() + "P");
        if (Stock >= MaxStock)
        {
            this.ToggleAvailable();
            notify();
        }
    }

    public synchronized void RemoveBeer()
    {

        while (Available == false)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                System.out.println("se interrumpio en el Remove" + e);
            }
        }
        Stock = Stock - 1;
        System.out.println(this.GetStock() + "C");
        if (Stock <= MinStock)
        {
            this.ToggleAvailable();
            notify();
        }
    }

    public int GetStock()
    {
        return this.Stock;
    }
}
