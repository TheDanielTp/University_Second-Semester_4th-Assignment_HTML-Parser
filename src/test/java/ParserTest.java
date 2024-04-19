import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest
{

    public static Parser handle;

    @BeforeAll
    static void setUp () throws IOException
    {
        handle = new Parser ();
        handle.setUp ();
    }

    @Test
    public void testSortByName ()
    {
        List <Country> sortedCountries = Parser.sortByName ();

        Country c1 = new Country ("Democratic Republic of the Congo", "Kinshasa", 70916439, 2345410.0);
        Country c2 = new Country ("Gambia", "Bathurst", 1593256, 11300.0);
        Country c3 = new Country ("Greece", "Athens", 11000000, 131940.0);
        Country c4 = new Country ("Vietnam", "Hanoi", 89571130, 329560.0);
        Country c5 = new Country ("Mali", "Bamako", 13796354, 1240000.0);

        assertEquals (250, sortedCountries.size ());
        assertEquals (sortedCountries.get (57), c1);
        assertEquals (sortedCountries.get (79), c2);
        assertEquals (sortedCountries.get (84), c3);
        assertEquals (sortedCountries.get (243), c4);
        assertEquals (sortedCountries.get (134), c5);
    }

    @Test
    public void testSortByPopulation ()
    {
        List <Country> sortedCountries = Parser.sortByPopulation ();

        Country c1 = new Country ("Democratic Republic of the Congo", "Kinshasa", 70916439, 2345410.0);
        Country c2 = new Country ("Gambia", "Bathurst", 1593256, 11300.0);
        Country c3 = new Country ("Greece", "Athens", 11000000, 131940.0);
        Country c4 = new Country ("Vietnam", "Hanoi", 89571130, 329560.0);
        Country c5 = new Country ("Mali", "Bamako", 13796354, 1240000.0);
        Country c6 = new Country ("Canada", "Ottawa", 33679000, 9984670.0);
        Country c7 = new Country ("Monaco", "Monaco", 32965, 1.95);

        assertEquals (250, sortedCountries.size ());
        assertEquals (sortedCountries.get (18), c1);
        assertEquals (sortedCountries.get (148), c2);
        assertEquals (sortedCountries.get (74), c3);
        assertEquals (sortedCountries.get (12), c4);
        assertEquals (sortedCountries.get (66), c5);
        assertEquals (sortedCountries.get (35), c6);
        assertEquals (sortedCountries.get (217), c7);
    }

    @Test
    public void testSortByArea ()
    {
        List <Country> sortedCountries = Parser.sortByArea ();

        Country c1 = new Country ("Democratic Republic of the Congo", "Kinshasa", 70916439, 2345410.0);
        Country c2 = new Country ("Gambia", "Bathurst", 1593256, 11300.0);
        Country c3 = new Country ("Greece", "Athens", 11000000, 131940.0);
        Country c4 = new Country ("Vietnam", "Hanoi", 89571130, 329560.0);
        Country c5 = new Country ("Mali", "Bamako", 13796354, 1240000.0);
        Country c6 = new Country ("Canada", "Ottawa", 33679000, 9984670.0);
        Country c7 = new Country ("Monaco", "Monaco", 32965, 1.95);

        assertEquals (250, sortedCountries.size ());
        assertEquals (sortedCountries.get (11), c1);
        assertEquals (sortedCountries.get (166), c2);
        assertEquals (sortedCountries.get (97), c3);
        assertEquals (sortedCountries.get (67), c4);
        assertEquals (sortedCountries.get (24), c5);
        assertEquals (sortedCountries.get (2), c6);
        assertEquals (sortedCountries.get (247), c7);
    }
}
