import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser
{
    static ArrayList <Country> countries = new ArrayList <> ();

    public ArrayList <Country> sortByName ()
    {
        ArrayList <Country> sortedByName = new ArrayList <> (countries);
        //TODO
        return sortedByName;
    }

    public ArrayList <Country> sortByPopulation ()
    {
        ArrayList <Country> sortedByPopulation = new ArrayList <> (countries);
        //TODO
        return sortedByPopulation;
    }

    public ArrayList <Country> sortByArea ()
    {
        ArrayList <Country> sortedByArea = new ArrayList <> (countries);
        //TODO
        return sortedByArea;
    }

    public static Country findCountryViaName (String name)
    {
        for (Country country : countries)
        {
            if (country.getName ().equals (name))
            {
                return country;
            }
        }
        return null;
    }

    public static void setUp () throws IOException
    {
        
    }

    public static void main (String[] args) throws IOException
    {
        setUp ();
        Scanner scanner = new Scanner (System.in);

        while (true)
        {
            System.out.println ("Enter country's name: ");
            String name = scanner.nextLine ();
            if (name.equals ("esc"))
            {
                break;
            }
            while (findCountryViaName (name) == null)
            {
                System.out.println ("Country not found. Enter country's name: ");
                name = scanner.nextLine ();
            }
            Country country = findCountryViaName (name);
            assert country != null;
            System.out.println (country.toString ());
        }
    }
}
