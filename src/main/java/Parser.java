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
        String filePath = "D:\\Java\\4th Assignment\\University_Second-Semester_4th-Assignment_HTML-Parser\\src\\Resources\\country-list.html";

        try
        {
            Document document  = Jsoup.parse (new File (filePath), "UTF-8");
            String   string    = document.toString ();
            String   plainText = Jsoup.parse (string).wholeText ();

            Scanner scanner = new Scanner (plainText);

            String newInfo = "";
            while (scanner.hasNext ())
            {
                while (scanner.hasNextLine ())
                {
                    String line = scanner.nextLine ().trim ();
                    if (! line.isEmpty ())
                    {
                        newInfo += line + "\n";
                        break;
                    }
                }
            }

            scanner = new Scanner (newInfo);

            scanner.nextLine ();
            scanner.nextLine ();
            while (scanner.hasNextLine ())
            {
                String name = scanner.nextLine ();
                if (scanner.hasNext ())
                {
                    scanner.next ();
                }

                String capital = "";
                if (scanner.hasNext ())
                {
                    capital = scanner.nextLine ();
                }
                if (scanner.hasNext ())
                {
                    scanner.next ();
                }

                String population = "";
                if (scanner.hasNext ())
                {
                    population = scanner.nextLine ();
                }
                if (scanner.hasNext ())
                {
                    scanner.next ();
                }

                String area = "";
                if (scanner.hasNext ())
                {
                    area = scanner.nextLine ();
                }

                countries.add (new Country (name, capital, population, area));
            }

            scanner.close ();
        }
        catch (IOException e)
        {
            throw new IOException ("File not found");
        }
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
