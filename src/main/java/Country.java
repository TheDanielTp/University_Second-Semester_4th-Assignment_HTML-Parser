import java.util.Objects;

public class Country
{
    private final String name;
    private final String capital;
    private final String    population;
    private final String area;

    public Country (String name, String capital, String population, String area)
    {
        this.name       = name;
        this.capital    = capital;
        this.population = population;
        this.area       = area;
    }

    @Override
    public String toString ()
    {
        String string = "";

        string += "Name: " + name + "\n";
        string += "Capital:" + capital + "\n";
        string += "Population:" + population + "\n";
        string += "Area" + area + "\n";

        return string;
    }

    @Override
    public boolean equals (Object object)
    {
        if (getClass() != object.getClass())
        {
            return false;
        }

        Country country = (Country) object;
        return Objects.equals (population, country.population) && Objects.equals (country.area, area)
                && Objects.equals (name, country.name) && Objects.equals (capital, country.capital);
    }

    /*
    GET-INFO FUNCTIONS
    */

    public String getName ()
    {
        return name;
    }

    public String getCapital ()
    {
        return capital;
    }

    public String getPopulation ()
    {
        return population;
    }

    public String getArea ()
    {
        return area;
    }
}
