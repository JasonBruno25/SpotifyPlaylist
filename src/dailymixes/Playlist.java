package dailymixes;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jason Bruno Terceros (jasonb19)

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Jason Bruno Terceros (jasonb19)
 * @version Nov 7, 2023
 */
public class Playlist
    implements Comparable<Playlist>
{
    // ~ Fields ................................................................

    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a new Playlist object.
     * 
     * @param playlistName
     * @param minPop
     * @param minRock
     * @param minCountry
     * @param maxPop
     * @param maxRock
     * @param maxCountry
     * @param playlistCap
     */
    public Playlist(
        String playlistName,
        int minPop,
        int minRock,
        int minCountry,
        int maxPop,
        int maxRock,
        int maxCountry,
        int playlistCap)
    {
        name = playlistName;
        minGenreSet = new GenreSet(minPop, minRock, minCountry);
        maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        // this has to be done before creating a song of length of capacity
        capacity = playlistCap;
        songs = new Song[capacity];
        numberOfSongs = 0;
    }

    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * accessor method that gets the minGenreSet
     * 
     * @return GenreSet is the field of a GenreSet field
     */
    public GenreSet getMinGenreSet()
    {
        return minGenreSet;
    }


    // ----------------------------------------------------------
    /**
     * mutator method that takes a string and changes the field of name. Mutator
     * methods do not return anything
     * 
     * @param playlistName
     *            is the new neame of the playlist we wish to change
     */
    public void setName(String playlistName)
    {
        name = playlistName;
    }


    // ----------------------------------------------------------
    /**
     * accessor method that gets the difference of the array. From what is
     * available to how full it is
     * 
     * @return int Of difference between capacity and numberOfSongs in the array
     */
    public int getSpacesLeft()
    {
        return capacity - numberOfSongs;
    }


    // ----------------------------------------------------------
    /**
     * accessor method that gets the maxGenreSet
     * 
     * @return GenreSet is the field of a GenreSet field for the maximum
     */
    public GenreSet getMaxGenreSet()
    {
        return maxGenreSet;
    }


    // ----------------------------------------------------------
    /**
     * 
     * 
     */
    public int compareTo(Playlist other)
    {
        // having trouble implementing this method
        
        // should implement the Comparable interface.
        
        // if 2 playlist have equal capcities then they will be ordered based
        // on spaces left (decendingly: largest to least)
        
        //int compareCapcity = capacity.compareTo(other.getCapacity());
        
        
        // if they have an equal number of slots, will be ordered based on 
        // MinGenreSet (see compareTo GenreSet)
        
        // if all of these are the same then they will be ordered on
        // MaxGenreSet
        
        
        // lastly, if these are all the same, we will order them by name
        
        return 0;
    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     */
    public int getNumberOfSongs()
    {
        return numberOfSongs;
    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     */
    public boolean addSong(Song newSong)
    {
        // a song holds name, pop, rock, country, and playlist

        // first check if we can or cannot add a song
        if (isFull() || !isQualified(newSong)) // or does not fit
        {
            return false;
        }

        songs[numberOfSongs] = newSong; // index of numberOfSongs is last
        numberOfSongs++;
        return true;

    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder();

        str.append("Playlist: ");
        str.append(name);
        str.append(", # of songs: ");
        str.append(numberOfSongs);
        str.append(" (cap: ");
        str.append(capacity);
        str.append("), Requires: Pop:");
        str.append(minGenreSet.getPop());
        str.append("%-");
        str.append(maxGenreSet.getPop());
        str.append("%, Rock:");
        str.append(minGenreSet.getRock());
        str.append("%-");
        str.append(maxGenreSet.getRock());
        str.append("%, Country:");
        str.append(minGenreSet.getCountry());
        str.append("%-");
        str.append(maxGenreSet.getCountry());
        str.append("%");

        // this might be inefficient but i don't care
        // its late and it just needs to get done

        return str.toString();

    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     */
    public boolean isFull()
    {
        return numberOfSongs >= capacity;
    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     */
    public boolean equals(Object obj)
    {

        if (obj instanceof Playlist)
        {
            Playlist other = (Playlist)obj;

            // compare and check all 8 fields
            // name, (minPop, minRock, minCoun),
            // (maxPop, maxRock, maxCoun), capacity

            // and they have to be in the same order, so compare the arrays

            return name.equals(other.name)
                && minGenreSet.equals(other.minGenreSet)
                && maxGenreSet.equals(other.maxGenreSet)
                && capacity == other.capacity && songs.equals(other.songs);

        }

        return false; // else if not all 8 are equal
    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     */
    public Song[] getSongs()
    {
        return songs; // returns the array of songs
    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     */
    public int getCapacity()
    {
        return capacity;
    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     */
    public String getName()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     */
    public boolean isQualified(Song song)
    {
        return song.getGenreSet().isWithinRange(minGenreSet, maxGenreSet);
    }

}
