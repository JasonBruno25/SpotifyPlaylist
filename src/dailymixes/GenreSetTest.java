package dailymixes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import student.TestCase;


//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Jason Bruno Terceros (jasonb19)
// -------------------------------------------------------------------------
/**
 * We are testing the GenreSet Class to make sure it creates Set properly
 * It takes on the genre properties. and testing our comparable classes
 * 
 * @author Jason Bruno Terceros (jasonb19)
 * @version Nov 7, 2023
 */
public class GenreSetTest
    extends TestCase
{
    // ~ Fields ................................................................

    private GenreSet genreSet; // declares a GenreSet
    private GenreSet testSet;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * This setUp method is made for the testing
     */
    public void setUp()
    {
        genreSet = new GenreSet(76, 21, 1); // instantiates it
        testSet = new GenreSet(20, 51, 43); // testing oject
    }


    // ----------------------------------------------------------
    /**
     * Accessor method for the rock field. decided to make accessor methods
     * first
     */
    public void testGetRock()
    {
        assertEquals(21, genreSet.getRock());
        assertEquals(51, testSet.getRock());
        
    }


    // ----------------------------------------------------------
    /**
     * Accessor method for the pop field. decided to make accessor methods first
     */
    public void testGetPop()
    {
        assertEquals(76, genreSet.getPop());
        assertEquals(20, testSet.getPop());
    }


    // ----------------------------------------------------------
    /**
     * Accessor method for the country field. decided to make accessor methods
     * first
     */
    public void testGetCountry()
    {
        assertEquals(1, genreSet.getCountry());
        assertEquals(43, testSet.getCountry());
    }


    // ----------------------------------------------------------
    /**
     * Create a new GenreSet object.
     */
    public void testToString()
    {
        assertEquals("Pop:76 Rock:21 Country:1", genreSet.toString());
        assertEquals("Pop:20 Rock:51 Country:43", testSet.toString());
        
    }


    // ----------------------------------------------------------
    /**
     * tests the equals()
     * by checking instances when there is an object
     * tests compared to itself
     * to another instance that is GenreSet but not same values
     * 
     */
    public void testEquals()
    {
        GenreSet copySet = new GenreSet(76, 21, 1);
        
        // first test when other is not an instance of Genre set
        String value = "";
        assertFalse(genreSet.equals(value));
        
        // now when it is an instance of
        assertFalse(genreSet.equals(testSet));
        assertFalse(testSet.equals(genreSet));
        
        // now lets check when it is true
        assertTrue(genreSet.equals(copySet));
        assertTrue(copySet.equals(genreSet));
        
        assertTrue(genreSet.equals(genreSet));
       
    }


    // ----------------------------------------------------------
    /**
     * Checks a set maximum value and minimum value
     * 
     */
    public void testIsWithinRange()
    {
        // testing the smallest possible conditions and the biggest
        GenreSet minSet = new GenreSet(1, 1, 1);
        GenreSet maxSet = new GenreSet(99, 99, 99);
        
        assertTrue(genreSet.isWithinRange(minSet, maxSet));
        assertTrue(testSet.isWithinRange(minSet, maxSet));
        
        // now when the condition is not true
        assertFalse(genreSet.isWithinRange(testSet, maxSet));
        assertFalse(genreSet.isWithinRange(minSet, testSet));
        
    }


    // ----------------------------------------------------------
    /**
     * Helper method Create a new GenreSet object.
     */
//    private void testIsLessThanOrEqualTo()
//    {
//        GenreSet minSet = new GenreSet(1, 1, 1);
//        GenreSet copySet = new GenreSet(76, 21, 1);
//        // is less than or equal to is private.. would have to test through
//        // isWithinRange
//        assertTrue(genreSet.isLessThanOrEqualTo());
//        
//    }


    // ----------------------------------------------------------
    /**
     * 
     * comparing some values to one another to see if the sum
     * is output is correct.
     */
    public void testCompareTo()
    {
        GenreSet minSet = new GenreSet(1, 1, 1);
        
        assertEquals( 95, genreSet.compareTo(minSet));
        assertEquals( -95, minSet.compareTo(genreSet));
        
        // genreSet = 98
        // testSet = 114
        assertEquals( 16, testSet.compareTo(genreSet));
        assertEquals( -16, genreSet.compareTo(testSet));
    }

}
