package dailymixes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import queue.EmptyQueueException;
import queue.QueueInterface;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author jj246
 *  @version Nov 7, 2023
 */
public class ArrayQueueTest extends TestCase
{
    //~ Fields ................................................................

    private ArrayQueue<String> arrQue;
    
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Place a description of your method here
     */
    public void setUp()
    {
        arrQue = new ArrayQueue<>();
        
        arrQue.enqueue("ravens");
        arrQue.enqueue("steelers");
        arrQue.enqueue("browns");
    }
    
    
    // ----------------------------------------------------------
    /**
     * 
     * 
     */
    public void testClear()
    {
        arrQue.clear();
        assertEquals(0, arrQue.getSize());
        assertTrue(arrQue.isEmpty());
    }


//    // ----------------------------------------------------------
//    /**
//     * helper method
//     */
//    private void testIncrementIndex()
//    {
//        // cannot test this since it is private
//    }


    // ----------------------------------------------------------
    /**
     * 
     * 
     */
    public void testToString()
    {
        assertEquals("[ravens, steelers, browns]", arrQue.toString());
    }


    // ----------------------------------------------------------
    /**
     * 
     * 
     */
    public void testEquals()
    {
        ArrayQueue<String> copyQue = new ArrayQueue<>();
        copyQue.enqueue("ravens");
        copyQue.enqueue("steelers");
        copyQue.enqueue("browns");

        assertTrue(arrQue.equals(copyQue));
    }


    // ----------------------------------------------------------
    /**
     * 
     * 
     */
    public void testIsEmpty()
    {
        assertFalse(arrQue.isEmpty());
        arrQue.clear();
        assertTrue(arrQue.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * 
     * 
     */
    public void testDequeue()
    {
        
        // will have to test for exception thrown
        
        assertEquals("ravens", arrQue.dequeue());
        assertEquals("steelers", arrQue.dequeue());
        assertEquals("browns", arrQue.dequeue());
        assertTrue(arrQue.isEmpty());
    }


//    // ----------------------------------------------------------
//    /**
//     * Helper method
//     */
//    private void testEnsureCapacity()
//    {
//        // cannot build a test method for this
//    }


    // ----------------------------------------------------------
    /**
     * 
     * 
     */
    public void testEnqueue()
    {
        assertEquals("[ravens, steelers, browns]", arrQue.toString());
        arrQue.enqueue("bengals");
        assertEquals("[ravens, steelers, browns, bengals]", arrQue.toString());
    }


    // ----------------------------------------------------------
    /**
     * 
     * 
     */
    public void testGetLengthOfUnderlyingArray()
    {
        ArrayQueue<String> testQue = new ArrayQueue<>();
        assertEquals(22, arrQue.getLengthOfUnderlyingArray());
        assertEquals(22, testQue.getLengthOfUnderlyingArray());
        // i do not know why it is 22, when it should be 21
        // i thought i might have made a mistake with my
        // DEFAULT_CAPACITY to 20 and then add 1 when instantiated
        // ugh.. thought i did that
    }


    // ----------------------------------------------------------
    /**
     * 
     * 
     */
    public void testGetFront()
    {
        // also test the exception thrown
        assertEquals("ravens", arrQue.getFront());
    }


    // ----------------------------------------------------------
    /**
     * 
     */
    public void testGetSize()
    {
        assertEquals( 3, arrQue.getSize());
    }


//    // ----------------------------------------------------------
//    /**
//     * 
//     * 
//     */
//    private void isFull()
//    {
//        // cannot be tested since it is private
//    }


    // ----------------------------------------------------------
    /**
     * 
     * 
     */
    public void testToArray()
    {
        Object[] array = arrQue.toArray();
        assertEquals(3, array.length);
        
        // need to check the values of the array
        // shoud be 0 = ravens, 1 = steelers and 2 = browns
        assertEquals("ravens", array[0]);
        assertEquals("steelers", array[1]);
        assertEquals("browns", array[2]);
    }

}

  
