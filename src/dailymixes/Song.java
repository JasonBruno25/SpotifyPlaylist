package dailymixes;


//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- Jason Bruno Terceros (jasonb19)
// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Jason Bruno Terceros (jasonb19)
 * @version Nov 7, 2023
 */
public class Song
{
    // ~ Fields ................................................................

    private String name;
    private String suggestedPlaylist;
    private GenreSet genreSet;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * This is the constrcutor to the Song class
     * @param name Is the name of the song
     * @param 
     */
    public Song(String name, int pop, int rock, int country, String suggested)
    {
        this.name = name;
        genreSet = new GenreSet(pop, rock, country);
        suggestedPlaylist = suggested;
    }

    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder();

        if (suggestedPlaylist.equals(""))
        {
            str.append("No-Playlist ");
        }

        // str.append("GenreSet: ");
        str.append(name);
        str.append(" Pop:");
        str.append(genreSet.getPop());
        str.append(" Rock:");
        str.append(genreSet.getRock());
        str.append(" Country:");
        str.append(genreSet.getCountry());

        if (suggestedPlaylist.length() > 0)
        {
            str.append(" Suggested: ");
            str.append(suggestedPlaylist);
        }

        return str.toString();
    }


    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     */
    public String getPlaylistName()
    {
        return suggestedPlaylist;
    }


    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     */
    public boolean equals(Object obj)
    {
        // two songs are equal when their name
        // when their GenreSet
        // and suggested Playlist values are the same...
        // all of the values have to be compared

        // one call i can make is genreSet.equals(obj) since this already works

        if (obj instanceof Song)
        {
            Song other = (Song)obj;
            return this.name.equals(other.name)
                && this.suggestedPlaylist.equals(other.suggestedPlaylist)
                && this.genreSet.equals(other.genreSet);
        }
        return false; // alternative
    }


    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     */
    public String getName()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Create a new Song object.
     */
    public GenreSet getGenreSet()
    {
        return genreSet;
    }

}
