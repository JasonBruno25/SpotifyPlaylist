package dailymixes;

import list.AList;

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
public class PlaylistCalculator
{
    // ~ Fields ................................................................

    private Playlist[] playlist;
    public static final int NUM_PLAYLISTS = 3;
    public static final int MIN_PERCENT = 0;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;
    public static final int MAX_PERCENT = 100;
    public static final int NUM_DEFAULT = 25;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     */
    public PlaylistCalculator(ArrayQueue<Song> queue, Playlist[] list)
    {
        if (queue == null)
        {
            throw new IllegalArgumentException();
        }

        songQueue = queue;
        playlist = list;
        // it says to use default if number provided is less than default
        // however, we have no input provided
        rejectedTracks = new AList<>(NUM_DEFAULT); // default

    }

    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     */
    public void reject()
    {
        if (!songQueue.isEmpty())
        {
            Song rejectedSong = songQueue.dequeue();
            rejectedTracks.add(rejectedSong);
        }
    }


    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     */
    private Playlist getPlaylistWithMostRoom(Song song)
    {
        for (Playlist playlist : sortedPlaylists)
        {
            if (!playlist.isFull() && canAccept(playlist, song))
            {
                return playlist;
            }
        }
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     */
    public boolean addSongToPlaylist()
    {
        if (!songQueue.isEmpty())
        {
            Song nextSong = songQueue.getFront();
            Playlist suggestedPlaylist = getPlaylistForSong(nextSong);

            if (suggestedPlaylist != null)
            {
                suggestedPlaylist.addSong(nextSong);
                songQueue.dequeue();
                return true;
            }
        }

        return false;
    }


    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     */
    public Playlist getPlaylistForSong(Song nextSong)
    {
        if (nextSong == null) {
            return null;
        }

        Playlist suggestedPlaylist = nextSong.getSuggestedPlaylist();
        if (suggestedPlaylist != null && !suggestedPlaylist.isFull() && canAccept(suggestedPlaylist, nextSong)) {
            return suggestedPlaylist;
        }

        Playlist[] sortedPlaylists = Arrays.copyOf(playlists, playlists.length);
        Arrays.sort(sortedPlaylists);

        return getPlaylistWithMostRoom(nextSong, sortedPlaylists);
    
    }


    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     */
    public ArrayQueue<Song> getQueue()
    {
        return songQueue;
    }


    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     */
    private boolean canAccept(Playlist playlist, Song song)
    {
        // Implement specific logic for checking if a song can be accepted into
        // a playlist
        // For example, compare song attributes with playlist requirements
        // This method is based on your design choices
        return true;
    }


    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     */
    public int getPlaylistIndex(String playlistName)
    {
        for (int i = 0; i < playlist.length; i++)
        {
            if (playlist[i].getName().equals(playlistName))
            {
                return i;
            }
        }

        return -1;
    }


    // ----------------------------------------------------------
    /**
     * Create a new PlaylistCalculator object.
     */
    public Playlist[] getPlayLists()
    {
        return playlist;
    }

}
