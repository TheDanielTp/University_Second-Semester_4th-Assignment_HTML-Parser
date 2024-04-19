import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser
{
    static ArrayList <Country> countries = new ArrayList <> ();

    //region Basic Functions

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

    //endregion

    //region Sort Functions

    public static ArrayList <Country> sortByName ()
    {
        ArrayList <Country> sortedByName = new ArrayList <> (countries);
        sortedByName.sort (Comparator.comparing (Country :: getName));
        return sortedByName;
    }

    public static ArrayList <Country> sortByPopulation ()
    {
        ArrayList <Country> sortedByPopulation = new ArrayList <> (countries);
        sortedByPopulation.sort (Comparator.comparing (Country :: getPopulation));
        Collections.reverse (sortedByPopulation);
        return sortedByPopulation;
    }

    public static ArrayList <Country> sortByArea ()
    {
        ArrayList <Country> sortedByArea = new ArrayList <> (countries);
        sortedByArea.sort (Comparator.comparing (Country :: getArea));
        Collections.reverse (sortedByArea);
        return sortedByArea;
    }

    //endregion

    //region Search Functions

    public static Country findCountryViaName (String name)
    {
        if (name.equalsIgnoreCase ("Persia"))
        {
            return findCountryViaName ("Iran");
        }
        if (name.equalsIgnoreCase ("Côte d'Ivoire"))
        {
            return findCountryViaName ("Ivory Coast");
        }
        if (name.equalsIgnoreCase ("Republic of Korea"))
        {
            return findCountryViaName ("South Korea");
        }
        if (name.equalsIgnoreCase ("Czechia"))
        {
            return findCountryViaName ("Czech Republic");
        }


        if (name.equalsIgnoreCase ("US") || name.equalsIgnoreCase ("U.S.") || name.equalsIgnoreCase ("America"))
        {
            return findCountryViaName ("United States");
        }
        if (name.equalsIgnoreCase ("UK") || name.equalsIgnoreCase ("U.K.") || name.equalsIgnoreCase ("Britain") || name.equalsIgnoreCase ("England"))
        {
            return findCountryViaName ("United Kingdom");
        }
        if (name.equalsIgnoreCase ("Democratic People's Republic of Korea") || name.equalsIgnoreCase ("DPRK") || name.equalsIgnoreCase ("D.P.R.K."))
        {
            return findCountryViaName ("North Korea");
        }
        if (name.equalsIgnoreCase ("UAE") || name.equalsIgnoreCase ("U.A.E."))
        {
            return findCountryViaName ("United Arab Emirates");
        }

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

        if (name.equalsIgnoreCase ("Nuclear"))
        {
            similarCountries.add (findCountryViaName ("Russia"));
            similarCountries.add (findCountryViaName ("United States"));
            similarCountries.add (findCountryViaName ("China"));
            similarCountries.add (findCountryViaName ("France"));
            similarCountries.add (findCountryViaName ("United Kingdom"));
            similarCountries.add (findCountryViaName ("Pakistan"));
            similarCountries.add (findCountryViaName ("India"));
            similarCountries.add (findCountryViaName ("Israel"));
            similarCountries.add (findCountryViaName ("Iran"));

            return similarCountries;
        }
        if (name.equalsIgnoreCase ("Islam") || name.equalsIgnoreCase ("Muslim"))
        {
            similarCountries.add (findCountryViaName ("Algeria"));
            similarCountries.add (findCountryViaName ("Iran"));
            similarCountries.add (findCountryViaName ("Turkey"));
            similarCountries.add (findCountryViaName ("Pakistan"));
            similarCountries.add (findCountryViaName ("Egypt"));
            similarCountries.add (findCountryViaName ("Indonesia"));
            similarCountries.add (findCountryViaName ("Morocco"));
            similarCountries.add (findCountryViaName ("Bangladesh"));
            similarCountries.add (findCountryViaName ("India"));
            similarCountries.add (findCountryViaName ("Saudi Arabia"));
            similarCountries.add (findCountryViaName ("Iraq"));
            similarCountries.add (findCountryViaName ("Sudan"));
            similarCountries.add (findCountryViaName ("Jordan"));
            similarCountries.add (findCountryViaName ("Niger"));
            similarCountries.add (findCountryViaName ("Uzbekistan"));
            similarCountries.add (findCountryViaName ("Yemen"));
            similarCountries.add (findCountryViaName ("Afghanistan"));
            similarCountries.add (findCountryViaName ("Libya"));
            similarCountries.add (findCountryViaName ("Malaysia"));
            similarCountries.add (findCountryViaName ("United Arab Emirates"));
            similarCountries.add (findCountryViaName ("Somalia"));
            similarCountries.add (findCountryViaName ("Tunisia"));
            similarCountries.add (findCountryViaName ("Azerbaijan"));
            similarCountries.add (findCountryViaName ("Djibouti"));

            return similarCountries;
        }
        if (name.equalsIgnoreCase ("Sigma") || name.equalsIgnoreCase ("Anti Gay") || name.equalsIgnoreCase ("Chad"))
        {
            similarCountries.add (findCountryViaName ("Indonesia"));
            similarCountries.add (findCountryViaName ("Saudi Arabia"));
            similarCountries.add (findCountryViaName ("Iran"));
            similarCountries.add (findCountryViaName ("Russia"));

            return similarCountries;
        }

        for (Country country : countries)
        {
            if (country.getName ().toLowerCase ().contains (name.toLowerCase ()))
            {
                similarCountries.add (country);
            }
        }
        return similarCountries;
    }

    public static Country findCountryViaCapital (String name)
    {
        for (Country country : countries)
        {
            if (country.getCapital ().equalsIgnoreCase (name))
            {
                return country;
            }
        }
        return null;
    }

    //endregion

    //region Main Functions

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
                    capital = capital.substring (1);

                    population = population.trim ();
                    int populationInt = Integer.parseInt (population);


                    area = area.replaceAll ("[^\\d.]", "");
                    double areaDouble = Double.parseDouble (area);

                    countries.add (new Country (name, capital, populationInt, areaDouble));
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

                    Country country = null;
                    while (findCountryViaName (name) == null)
                    {
                        if (findSimilarCountries (name).isEmpty ())
                        {
                            if (findCountryViaCapital (name) == null)
                            {
                                System.out.print ("Country not found. Enter country's name: ");

                                name = scanner.nextLine ();
                                if (name.equals ("esc"))
                                {
                                    break;
                                }
                            }
                            else
                            {
                                country = findCountryViaCapital (name);
                                assert country != null;
                                name = country.getName ();
                            }
                        }
                        else
                        {
                            System.out.println ();
                            ArrayList <Country> similarCountries = findSimilarCountries (name);

                            System.out.println ("Did you mean:");
                            for (Country similarCountry : similarCountries)
                            {
                                System.out.println (similarCountry.getName ());
                            }
                            System.out.print ("Enter country's name: ");

                            name = scanner.nextLine ();
                            if (name.equals ("esc"))
                            {
                                break;
                            }
                        }
                    }

                    System.out.println ();

                    if (country == null)
                    {
                        country = findCountryViaName (name);
                    }

                    if (country == null)
                    {
                        continue;
                    }

                    System.out.println (country.toString ());

                    System.out.print ("Press enter to continue ");
                    scanner.nextLine ();
                    clearTerminal ();
                }
                case "2" ->
                {
                    System.out.println ("Countries sorted according to Name:");
                    for (Country country : sortByName ())
                    {
                        System.out.println (country.toString ());
                    }
                    System.out.print ("Press enter to continue ");
                    scanner.nextLine ();
                    clearTerminal ();
                }
                case "3" ->
                {
                    System.out.println ("Countries sorted according to Population:");
                    for (Country country : sortByPopulation ())
                    {
                        System.out.println (country.toString ());
                    }
                    System.out.print ("Press enter to continue ");
                    scanner.nextLine ();
                    clearTerminal ();
                }
                case "4" ->
                {
                    System.out.println ("Countries sorted according to Area:");
                    for (Country country : sortByArea ())
                    {
                        System.out.println (country.toString ());
                    }
                    System.out.print ("Press enter to continue ");
                    scanner.nextLine ();
                    clearTerminal ();
                }
                case "5" ->
                {
                    clearTerminal ();
                    System.out.println ("Exiting the Program... ");
                    return;
                }
                default ->
                {
                    System.out.print ("Invalid choice. Please try again.");
                    sleep (1000);
                    clearTerminal ();
                }
            }
        }
    }

    //endregion
}
