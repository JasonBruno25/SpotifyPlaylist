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
 * Tests the song Class.
 * Here we are checking and getting the standard method to test
 * 
 * 
 * @author Jason Bruno Terceros (jasonb19)
 * @version Nov 7, 2023
 */
public class SongTest
    extends TestCase
{
    // ~ Fields ................................................................

    private Song song;
    private Song testSong;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @throws java.lang.Exception
     */
    @Before
    public void setUp()
    {
        song = new Song("Odio", 76, 21, 1, "latin");
        testSong = new Song("Promise", 80, 20, 1, "");
    }


    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     */
    public void testGetName()
    {
        assertEquals("Odio", song.getName());
        assertEquals("Promise", testSong.getName());
    }


    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     */
    public void testGetPlaylistName()
    {
        assertEquals("latin", song.getPlaylistName());
        assertEquals("", testSong.getPlaylistName());
    }


    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     */
    public void testGetGenreSet()
    {
        GenreSet required = new GenreSet(76, 21, 1);
        assertEquals(required, song.getGenreSet());
    }


    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     */
    public void testEquals()
    {

        Song copySong = new Song("Odio", 76, 21, 1, "latin");
        
        // first test when other is not an instance of Genre set
        String value = "";
        assertFalse(song.equals(value));
        
        // now when it is an instance of
        assertFalse(song.equals(testSong));
        
        
        // now lets check when it is true
        assertTrue(song.equals(song));
        assertTrue(song.equals(copySong));
        assertTrue(copySong.equals(song));
    }


    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     */
    public void testToString()
    {
        assertEquals(
            "Odio Pop:76 Rock:21 Country:1 Suggested: latin",
            song.toString());
        assertEquals(
            "No-Playlist Promise Pop:80 Rock:20 Country:1",
            testSong.toString());
    }

}
