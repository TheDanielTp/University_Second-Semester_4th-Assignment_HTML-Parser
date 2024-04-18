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

    public static void clearTerminal ()
    {
        System.out.println ("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void sleep (int time)
    {
        try
        {
            Thread.sleep (time);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException (e);
        }
    }

    public static ArrayList <Country> sortByName ()
    {
        ArrayList <Country> sortedByName = new ArrayList <> (countries);
        sortedByName.sort (Comparator.comparing (Country :: getName));
        return sortedByName;
    }

    public static ArrayList <Country> sortByPopulation ()
    {
        ArrayList<Country> sortedByPopulation = new ArrayList<>(countries);
        sortedByPopulation.sort(Comparator.comparing(Country::getPopulation));
        Collections.reverse(sortedByPopulation);
        return sortedByPopulation;
    }

    public static ArrayList <Country> sortByArea ()
    {
        ArrayList<Country> sortedByArea = new ArrayList<>(countries);
        sortedByArea.sort(Comparator.comparing(Country::getPopulation));
        Collections.reverse(sortedByArea);
        return sortedByArea;
    }

    public static Country findCountryViaName (String name)
    {
        for (Country country : countries)
        {
            if (country.getName ().equalsIgnoreCase (name))
            {
                return country;
            }
        }
        return null;
    }

    public static ArrayList <Country> findSimilarCountries (String name)
    {
        ArrayList <Country> similarCountries = new ArrayList <> ();

        for (Country country : countries)
        {
            if (country.getName ().toLowerCase ().contains (name.toLowerCase ()))
            {
                similarCountries.add (country);
            }
        }
        return similarCountries;
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

            StringBuilder newInfo = new StringBuilder ();
            while (scanner.hasNext ())
            {
                while (scanner.hasNextLine ())
                {
                    String line = scanner.nextLine ().trim ();
                    if (! line.isEmpty ())
                    {
                        newInfo.append (line).append ("\n");
                        break;
                    }
                }
            }

            scanner = new Scanner (newInfo.toString ());

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

                if (! capital.isEmpty ())
                {
                    countries.add (new Country (name, capital, population, area));
                }
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
            clearTerminal ();
            System.out.println ("Country Information System\n");
            System.out.println ("1- Select Country");
            System.out.println ("2- View Countries According to Name");
            System.out.println ("3- View Countries According to Population");
            System.out.println ("4- View Countries According to Area");
            System.out.println ("5- Exit the Program");
            System.out.print ("\nEnter your choice: ");

            String choice = scanner.nextLine ();

            switch (choice)
            {
                case "1" ->
                {
                    System.out.print ("Enter country's name: ");

                    String name = scanner.nextLine ();
                    if (name.equals ("esc"))
                    {
                        continue;
                    }

                    while (findCountryViaName (name) == null)
                    {
                        if (findSimilarCountries (name).isEmpty ())
                        {
                            System.out.print ("Country not found. Enter country's name: ");
                        }
                        else
                        {
                            System.out.println ();
                            ArrayList<Country> similarCountries = findSimilarCountries (name);

                            System.out.println ("Did you mean:");
                            for (Country similarCountry : similarCountries)
                            {
                                System.out.println (similarCountry.getName ());
                            }
                            System.out.print ("Enter country's name: ");
                        }
                        name = scanner.nextLine ();
                        if (name.equals ("esc"))
                        {
                            break;
                        }
                    }

                    System.out.println ();
                    Country country = findCountryViaName (name);

                    if (country == null)
                    {
                        continue;
                    }

                    System.out.println (country.toString ());

                    System.out.print ("Press enter to continue");
                    scanner.nextLine ();
                    clearTerminal ();
                }
                case "2" ->
                {
                    System.out.println ("Countries sorted according to Name:");
                    System.out.println (sortByName ());
                    System.out.println ("Press enter to continue");
                    scanner.nextLine ();
                    clearTerminal ();
                }
                case "3" ->
                {
                    System.out.println ("Countries sorted according to Population:");
                    System.out.println (sortByPopulation ());
                    System.out.println ("Press enter to continue");
                    scanner.nextLine ();
                    clearTerminal ();
                }
                case "4" ->
                {
                    System.out.println ("Countries sorted according to Area:");
                    System.out.println (sortByArea ());
                    System.out.println ("Press enter to continue");
                    scanner.nextLine ();
                    clearTerminal ();
                }
                case "5" ->
                {
                    clearTerminal ();
                    System.out.println ("Exiting the Program...");
                    return;
                }
                default ->
                {
                    System.out.print ("Invalid choice. Please try again.");
                    sleep (2000);
                    clearTerminal ();
                }
            }
        }
    }
}
