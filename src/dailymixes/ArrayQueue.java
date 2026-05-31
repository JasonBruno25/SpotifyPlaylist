package dailymixes;

import queue.EmptyQueueException;
import queue.QueueInterface;

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
 * @param <T>
 *            Is the generic value we would wish to use to instantiate our class
 *            with later when we implement it
 */
public class ArrayQueue<T>
    implements QueueInterface<T>
{
    // ~ Fields ................................................................

    /**
     * we were told to set default capacity to 20
     */
    public static final int DEFAULT_CAPACITY = 20;
    private T[] queue;
    private int dequeueIndex;
    private int size;
    private int enqueueIndex;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     * This is a default constructor. Does not take on any parameters or
     * returns anything. Creates an instance with a queue size of 20+1
     */
    public ArrayQueue()
    {
// queue = (T[]) new Object[DEFAULT_CAPACITY + 1];
// dequeueIndex = 0;
// size = 0;
// enqueueIndex = 0;
        this(DEFAULT_CAPACITY + 1);

    }


    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object but this is not a default constructor
     * This is constructor setups a queue array that takes in some capacity 
     * we will to instantiate it with
     * @param initialCapacity is the int value we will to set our queue array 
     * size to
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity)
    {
        // checked ArrayQueue from canvas
        queue = (T[])new Object[initialCapacity + 1];
        dequeueIndex = 0;
        size = 0;
        enqueueIndex = 0;

    }

    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * This essentially sets up a new array, it removes all values from the 
     * queue array, and sets the index's to 0 and size to 0
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear()
    {
        // way to re-call the constructor. like a newly constructed
        // object of DEFAULT CAPACITY
        // we are not running a while loop while it is not Empty
        // and dequeue all of them

        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        dequeueIndex = 0;
        size = 0;
        enqueueIndex = 0;

    }


    // ----------------------------------------------------------
    /**
     * For this method, it will be implemented as a circular array
     * It will go back around the queue
     * @param index Is the integer we wish to increment through
     * @return int Of the way the array will incrememnt
     */
    private int incrementIndex(int index)
    {
        return ((index + 1) % queue.length);
    }


    // ----------------------------------------------------------
    /**
     * This toString will neatly organize all the information within 
     * the queue array
     * @return String is the values from the queue, neatly organized
     * and contains all information 
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("[");

        // now if it is empty, just return []
        if (!isEmpty())
        {
            int index = dequeueIndex;

            for (int i = 0; i < size; i++)
            {
                str.append(queue[index]);

                if (i < size - 1)
                {
                    str.append(", ");
                }
                // now i want to increment index
                index = incrementIndex(index);
            }

        }

        str.append("]");
        return str.toString();

    }


    // ----------------------------------------------------------
    /**
     * This method will create an instance of an object, and compare it
     * to our ArrayQueue
     * @param obj Is an object we wish to compare to our current ArrayQueue
     * @return boolean Tells us if they are the same/equal
     */
    public boolean equals(Object obj)
    {

        // implement this almost like the last one

        if (obj instanceof ArrayQueue)
        {
            @SuppressWarnings("unchecked")
            ArrayQueue<T> other = (ArrayQueue<T>)obj;

            if (size != other.size)
            {
                return false;
            }

            int index = dequeueIndex;

            for (int i = 0; i < size; i++)
            {
                if (!queue[index].equals(other.queue[other.dequeueIndex]))
                {
                    return false;
                }

                index = incrementIndex(index);
                other.dequeueIndex = other.incrementIndex(other.dequeueIndex);
            }

            return true;
        }

        // now the alternative
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Only checks the size of the array to see if it has any value inside
     * it or not
     * @return boolean Is a true when the array is empty and false
     * when not
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }


    // ----------------------------------------------------------
    /**
     * This would remove the first value of our array (FIFO)
     * @return T is the generic value that is within our queue array
     */
    @Override
    public T dequeue()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }

        T value = queue[dequeueIndex]; // get the front queue
        queue[dequeueIndex] = null; // // remove the value at this index
        dequeueIndex = incrementIndex(dequeueIndex);

        size--; // adjust the size
        return value;

    }


    // ----------------------------------------------------------
    /**
     * Helper method
     * This method is meant to expand the capacity of the array queue
     * so that it can fit all of the desired information into the 
     * array
     */
    private void ensureCapacity()
    {
        // this can help upgrade the length of the array when queue is full
        // this should essentially double the capacity of the queue

        // size is different than length
        // capacity of 20, will double to 21. However there are 21 slots
        // after upgrade, there will be length 41 but holds 40 elements

        if (size == queue.length - 1) // so one less than the length
        {
            int newValue = (queue.length) * 2; // doubles the size

            @SuppressWarnings("unchecked")
            T[] newQueue = (T[])new Object[newValue];

            // now we will iterate through the queue and input them
            // into our new queue that holds the new capacity
            for (int i = 0; i < size; i++)
            {
                newQueue[i] = queue[dequeueIndex];
                dequeueIndex = incrementIndex(dequeueIndex);
                // this incrementes the desired index value
            }

            queue = newQueue; // setting the new queue to the old one
            dequeueIndex = 0; // reset it
            enqueueIndex = size;
        }
    }


    // ----------------------------------------------------------
    /**
     * Enqueue adds a data value to the end of the queue
     * @param eng Is the generic value that we wish to add to our queue
     */
    @Override
    public void enqueue(T enq)
    {
        if (isFull())
        {
            ensureCapacity();
        }

        queue[enqueueIndex] = enq;
        enqueueIndex = incrementIndex(enqueueIndex);
        size++;

    }


    // ----------------------------------------------------------
    /**
     * accessor method that returns the appropriate field
     * @return int Is the length of the queue Array
     */
    public int getLengthOfUnderlyingArray()
    {
        return queue.length;
    }


    // ----------------------------------------------------------
    /**
     * this is not an accessor method but returns the first value in the
     * queue. This should call on dequeueIndex since it dequeues from the 
     * front of the array (FIFO)
     * @return T is the generic value data that is held within the array
     * 
     */
    @Override
    public T getFront()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }

        return queue[dequeueIndex];
    }


    // ----------------------------------------------------------
    /**
     * accessor method to get size field
     * 
     * @return int of the size field
     */
    public int getSize()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * helper method
     * It gets the information when size is equivalent to the default capacity
     * since we always want a free space available in the queue, we will 
     * have 1 available space whenever this is true
     * @return boolean If size is equal to Default_Capacity or not
     * 
     */
    private boolean isFull()
    {
        return size == DEFAULT_CAPACITY;
    }


    // ----------------------------------------------------------
    /**
     * 
     */
    public Object[] toArray()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }

        // needs to start at index 0
        // this is what will iterate through
        Object[] result = new Object[size];

        int index = dequeueIndex;

        // now we iterate beginning at 0
        for (int i = 0; i < size; i++)
        {
            result[i] = queue[index];
            index = incrementIndex(index);
        }

        return result; // this is all the information we gathered from our
        // queue
    }

}
