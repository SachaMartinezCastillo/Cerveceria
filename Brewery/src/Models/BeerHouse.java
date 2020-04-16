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
        if (Available == true)
        {
            Available = false;
        }
        else
        {
            Available = true;
        }
    }

    public synchronized void AddBeer(int Cant)
    {
        while (Available == true)
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
         //   notify();
        }
    }

    public int GetStock()
    {
        return this.Stock;
    }
}
