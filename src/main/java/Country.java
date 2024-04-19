import java.util.Objects;

public class Country
{
    private final String name;
    private final String capital;
    private final int    population;
    private final double area;

    public Country (String name, String capital, int population, double area)
    {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
    }

    //region Override Functions

    @Override
    public String toString ()
    {
        String string = "";

        string += "Name: " + name + "\n";
        string += "Capital: " + capital + "\n";
        string += "Population: " + population + "\n";
        string += "Area: " + area + "\n";

        return string;
    }

    @Override
    public boolean equals (Object object)
    {
        if (getClass () != object.getClass ())
        {
            return false;
        }

        Country country = (Country) object;
        return Objects.equals (population, country.population) && Double.compare (country.area, area) == 0
                && Objects.equals (name, country.name) && Objects.equals (capital, country.capital);
    }

    //endregion

    //region Get-Info Functions

    public String getName ()
    {
        return name;
    }

    public String getCapital ()
    {
        return capital;
    }

    public int getPopulation ()
    {
        return population;
    }

    public double getArea ()
    {
        return area;
    }

    //endregion
}
