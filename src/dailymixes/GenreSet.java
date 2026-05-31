package dailymixes;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Jason Bruno Terceros (jasonb19)
// -------------------------------------------------------------------------
/**
 * For this class we are setting up the ground work for the rest of the Project.
 * We will create what is a set that holds information about a song In this set
 * we will input percentages of pop, rock, and country
 * 
 * @author Jason Bruno Terceros (jasonb19)
 * @version Nov 7, 2023
 */
public class GenreSet
{
    // ~ Fields ................................................................

    private int rock;
    private int pop;
    private int country;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a new GenreSet object. This is the constructor
     * @param pop Is the percentage of pop in the song
     * @param rock Is the percentage of rock in the song
     * @param country Is the percentage of country in the song
     */
    public GenreSet(int pop, int rock, int country)
    {
        this.pop = pop;
        this.rock = rock;
        this.country = country;
    }

    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * Accessor method for the rock field. decided to make accessor methods
     * first
     * 
     * @return int Of rock percentage
     */
    public int getRock()
    {
        return rock;
    }


    // ----------------------------------------------------------
    /**
     * Accessor method for the pop field. decided to make accessor methods first
     * 
     * @return int Of pop percentage
     */
    public int getPop()
    {
        return pop;
    }


    // ----------------------------------------------------------
    /**
     * Accessor method for the country field. decided to make accessor methods
     * first
     * 
     * @return int Of country percentage
     */
    public int getCountry()
    {
        return country;
    }


    // ----------------------------------------------------------
    /**
     * For this method we will use the information from the instructions to use
     * a StringBuilder to append information into a string We are only getting 3
     * field details and outputting them. No need for a loop
     * 
     * @return String of the toString method we wish to override
     */
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        // str.append("GenreSet: ");
        str.append("Pop:");
        str.append(pop);
        str.append(" Rock:");
        str.append(rock);
        str.append(" Country:");
        str.append(country);
        return str.toString();
    }


    // ----------------------------------------------------------
    /**
     * For this method I am checking an instance of GenreSet Tested using
     * Strings (another object). And we have to check every single field on both
     * to see if they are the same. If so we would return true
     * 
     * @param obj
     *            Is a generic object we wish to compare
     * @return boolean Is when we compare an object to our set
     */
    public boolean equals(Object obj)
    {
        // two sets are equal if all three fields, pop, rock, and coutnry
        // are equal

        // i know it is not this but it should be something like this
        // ideally GenreSet of something = (GenreSet)

        if (obj instanceof GenreSet)
        {
            GenreSet other = (GenreSet)obj;
            return this.pop == other.pop 
                && this.rock == other.rock
                && this.country == other.country;
        }
        return false; // alternative

    }


    // ----------------------------------------------------------
    /**
     * For this method we will be calling on isLessThanOrEqualTo twice to
     * compare the min set to the current set and the current set to the max
     * set. I do not know if i should check if min is also less than the max
     * set..
     * 
     * @param minGenreSet
     *            is the minimum set we wish to compare
     * @param maxGenreSet
     *            is the maximum set we wish to have our range in
     * @return boolean Is true if the current set fits within both of the
     *             parameters
     */
    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet)
    {
        // within range if bigger than minimum and less than maximum
        // assuming the min and max ones are end bounds
        // and i do not have to check if maxGenreSet is actually bigger than
        // minGenreSet
        return this.isLessThanOrEqualTo(maxGenreSet)
            && minGenreSet.isLessThanOrEqualTo(this);
    }


    // ----------------------------------------------------------
    /**
     * Helper method to be used in another method
     * 
     * @param other
     *            Is the set we wish to compare with our current
     * @returns boolean Whether the current set is either less than or equal to
     *              the provided set.
     */
    private boolean isLessThanOrEqualTo(GenreSet other)
    {
        // compare this object to a given other

        // return ture if this is less than or equal to other

        return this.pop <= other.pop && this.rock <= other.rock
            && this.country <= other.country;

    }


    // ----------------------------------------------------------
    /**
     * This method numerically compares two different sets based one the sum of
     * the percentages of all pop, rock, and country
     * 
     * @param other
     *            Is another GenreSet to compare
     * @return int Would be the difference between the current set and the
     *             provided set
     */
    public int compareTo(GenreSet other)
    {
        // returns either negative, positive or zero when comparing
        // to the sum of the genre percent composition

        int thisCount = this.pop + this.rock + this.country;
        int otherCount = other.pop + other.rock + other.country;

        return thisCount - otherCount;
    }

}
