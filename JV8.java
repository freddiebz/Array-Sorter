/*Author: Frederica Zhang
  Date: Nov. 25, 2019
  Purpose: test different sorting and searching methods
*/

// The "JV8" class.
import java.awt.*;
import hsa.Console;

public class JV8
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();

	SortMethods test;
	int size;
	long start, stop, bubbleTime, selecTime, insertTime, quickTime, combTime, shellTime;

	char retry = 'y';

	while (retry == 'y')
	{
	    test = new SortMethods (100);
	    c.println ("Testing the Methods: ");

	    for (int count = 0 ; count < 6 ; count++)
	    {
		c.println ("Original: " + test.toString ());

		if (count == 0)
		{
		    test.bubble ();
		    c.println ("Bubble:  (sorted = " + test.sorted () + ") " + test.toString ());
		    c.println ("Press any key to see the next sort: ");
		}
		else if (count == 1)
		{
		    test.selection ();
		    c.println ("Selection:  (sorted = " + test.sorted () + ") " + test.toString ());
		    c.println ("Press any key to see the next sort: ");
		}
		else if (count == 2)
		{
		    test.insertion ();
		    c.println ("Insertion:  (sorted = " + test.sorted () + ") " + test.toString ());
		    c.println ("Press any key to see the next sort: ");
		}
		else if (count == 3)
		{
		    test.quick ();
		    c.println ("Quick:  (sorted = " + test.sorted () + ") " + test.toString ());
		    c.println ("Press any key to see the next sort: ");
		}
		else if (count == 4)
		{
		    test.comb ();
		    c.println ("Comb:  (sorted = " + test.sorted () + ") " + test.toString ());
		    c.println ("Press any key to see the next sort: ");
		}
		else
		{
		    test.shell ();
		    c.println ("Shell:  (sorted = " + test.sorted () + ") " + test.toString ());
		    c.println ("Press any key to move onto the time trials: ");
		}
		test.reset ();
		c.getChar ();
		c.println ();
	    }


	    c.println ("Time Trials: (sorts are maxed out after passing 10000ms)");
	    c.print ("    Size", 8);
	    c.print ("  Bubble", 10);
	    c.print ("Selection", 11);
	    c.print ("Insertion", 11);
	    c.print (" Quick", 8);
	    c.print ("  Comb", 8);
	    c.println (" Shell", 8);
	    bubbleTime = 0;
	    selecTime = 0;
	    insertTime = 0;
	    quickTime = 0;
	    combTime = 0;
	    shellTime = 0;
	    size = 4000;

	    for (int count = 0 ; count < 13 ; count++)
	    {
		test = new SortMethods (size);
		c.print (size, 8);

		if (bubbleTime < 10000)
		{
		    start = System.currentTimeMillis ();
		    test.bubble ();
		    stop = System.currentTimeMillis ();
		    bubbleTime = stop - start;
		    test.reset ();
		    c.print (bubbleTime, 8);
		}
		else
		    c.print ("     ---", 8);

		if (selecTime < 10000)
		{
		    start = System.currentTimeMillis ();
		    test.selection ();
		    stop = System.currentTimeMillis ();
		    selecTime = stop - start;
		    test.reset ();
		    c.print (selecTime, 11);
		}
		else
		    c.print ("        ---", 11);

		if (insertTime < 10000)
		{
		    start = System.currentTimeMillis ();
		    test.insertion ();
		    stop = System.currentTimeMillis ();
		    insertTime = stop - start;
		    test.reset ();
		    c.print (insertTime, 11);
		}
		else
		    c.print ("        ---", 11);

		if (quickTime < 10000)
		{
		    start = System.currentTimeMillis ();
		    test.quick ();
		    stop = System.currentTimeMillis ();
		    quickTime = stop - start;
		    c.print (quickTime, 8);
		}
		else
		    c.print ("      ---", 8);

		if (combTime < 10000)
		{
		    start = System.currentTimeMillis ();
		    test.comb ();
		    stop = System.currentTimeMillis ();
		    combTime = stop - start;
		    c.print (combTime, 8);
		}
		else
		    c.print ("      ---", 8);

		if (shellTime < 10000)
		{
		    start = System.currentTimeMillis ();
		    test.shell ();
		    stop = System.currentTimeMillis ();
		    shellTime = stop - start;
		    c.println (shellTime, 8);
		}
		else
		    c.print ("      ---", 8);

		size = (int) (size * 1.75);

	    }

	    c.println ("Would you like to test with a different set of numbers? (y/n)");
	    retry = c.getChar ();
	    while (retry != 'y' && retry != 'n')
	    {
		c.println ("Please input 'y' or 'n'! ");
		retry = c.getChar ();
	    }
	    c.clear ();
	}
	c.println("Thank you for visiting! :D");




    } // main method
} // JV8 class

/* Class SortMethods
   Author: Frederica Zhang
   Date: Nov. 25, 2019
   Purpose: use various types of sorts to sort an arrayof random integers
   Fields:
   - original (int []): orignal array of random int
   - aClone (int []): clone of original used by the sorting methods (becomes sorted after)
   - size (int): size of original
   Methods:
   - constructor
   - reset: clone orignal into aClone
   - toString: converts aClone into a string
   - sorted: returns true if aClone is sorted (ascending)
   - bubble: sort the aClone using a bubble sort algorithm
   - selection: sort the aClone using a selection sort algorithm
   - insertion: sort the aClone using a insertion sort algorithm
   - quick: sort the aClone using a quick sort algorithm
*/
class SortMethods
{
    public int[] original;
    public int[] aClone;
    public int size;

    public SortMethods (int[] user)
    {
	original = user;
	aClone = (int[]) user.clone ();
	size = user.length;
    }


    public SortMethods (int length)
    {
	original = new int [length];
	for (int count = 0 ; count < length ; count++)
	    original [count] = (int) (Math.random () * 100);

	aClone = (int[]) original.clone ();
	size = length;
    }


    public SortMethods ()
    {
	original = new int [0];
	aClone = new int [0];
	size = 0;
    }


    /*reset
      Author: Frederica Zhang
      Date: Nov. 26, 2019
      Purpose: clone orignal into aClone
      Parameters: none
      Returns: nothing
    */
    public void reset ()
    {
	aClone = (int[]) this.original.clone ();
    }


    /*toString
     Author: Frederica Zhang
     Date: Nov. 26, 2019
     Purpose: converts aClone into a string
     Parameters: none
     Returns: String verions of aClone
    */
    public String toString ()
    {
	String output = Integer.toString (this.aClone [0]);

	for (int count = 1 ; count < size ; count++)
	{
	    output = output + " " + this.aClone [count];
	}

	return output;
    }


    /*sorted
     Author: Frederica Zhang
     Date: Nov. 26, 2019
     Purpose: returns true if aClone is sorted (ascending)
     Parameters: none
     Returns: true if aClone is sorted
    */
    public boolean sorted ()
    {
	boolean up = true;
	int count = 1;

	while (up == true && count < size)
	{
	    if (this.aClone [count] < this.aClone [count - 1])
		up = false;
	    count++;
	}

	return up;
    }


    /*bubble
     Author: Frederica Zhang
     Date: Nov. 27, 2019
     Purpose: sort the aClone using a bubble sort algorithm
     Parameters: none
     Returns: nothing
    */
    public void bubble ()
    {
	int higher;

	for (int pass = 0 ; pass < size - 1 ; pass++)
	{
	    for (int count = 0 ; count < size - 1 - pass ; count++)
	    {
		if (this.aClone [count] > this.aClone [count + 1])
		{
		    higher = this.aClone [count];
		    this.aClone [count] = this.aClone [count + 1];
		    this.aClone [count + 1] = higher;
		}
	    }
	}
    }


    /*selection
     Author: Frederica Zhang
     Date: Nov. 27, 2019
     Purpose: sort the aClone using a selection sort algorithm
     Parameters: none
     Returns: nothing
    */
    public void selection ()
    {
	int higher;
	int index;

	for (int pass = 0 ; pass < size - 1 ; pass++)
	{
	    index = 0;
	    for (int count = 1 ; count < size - pass ; count++)
	    {
		if (this.aClone [index] < this.aClone [count])
		    index = count;
	    }

	    higher = this.aClone [index];
	    this.aClone [index] = this.aClone [size - 1 - pass];
	    this.aClone [size - 1 - pass] = higher;
	}
    }


    /*insertion
     Author: Frederica Zhang
     Date: Nov. 28, 2019
     Purpose: sort the aClone using a insertion sort algorithm
     Parameters: none
     Returns: nothing
    */
    public void insertion ()
    {
	int insert;
	int count;

	for (int pass = 1 ; pass < size ; pass++)
	{
	    insert = this.aClone [pass];
	    for (count = pass ; count > 0 && this.aClone [count - 1] > insert ; count--)
		this.aClone [count] = this.aClone [count - 1];

	    this.aClone [count] = insert;
	}
    }


    /*quick
     Author: Frederica Zhang
     Date: Nov. 29, 2019
     Purpose: sort the aClone using a quick sort algorithm
     Parameters: none
     Returns: nothing
    */
    public void quick ()
    {
	moreQuick (0, size - 1);
    }


    /*moreQuick
     Author: Frederica Zhang
     Date: Nov. 29, 2019
     Purpose: sort one section the aClone
     Parameters: start and end indexes (int)
     Returns: nothing
    */
    protected void moreQuick (int start, int end)
    {
	int pivot = this.aClone [(end + start) / 2];
	int swap;
	int left = start - 1;
	int right = end + 1;

	while (left <= right)
	{
	    left++;
	    right--;
	    while (left < end && this.aClone [left] < pivot)
		left++;
	    while (right > start && this.aClone [right] > pivot)
		right--;

	    if (left < right)
	    {
		swap = this.aClone [left];
		this.aClone [left] = this.aClone [right];
		this.aClone [right] = swap;
	    }
	}

	if (start < right)
	    moreQuick (start, right);

	if (end > left)
	    moreQuick (left, end);
    }


    /*comb
     Author: Frederica Zhang (based on pseudocode in notes)
     Date: Dec. 10, 2019
     Purpose: sort the aClone using a comb sort algorithm
     Parameters: none
     Returns: nothing
    */
    public void comb ()
    {
	boolean inorder = false;
	int gap = size;
	int higher;

	do
	{
	    if ((int) (0.77 * gap) > 1)
		gap = (int) (0.77 * gap);
	    else
		gap = 1;

	    inorder = true;
	    for (int count = 0 ; count < size - gap ; count++)
	    {
		if (aClone [count] > aClone [count + gap])
		{
		    higher = aClone [count];
		    aClone [count] = aClone [count + gap];
		    aClone [count + gap] = higher;
		    inorder = false;
		}
	    }
	}
	while (gap > 1 || !inorder);

    }


    /*shell
     Author: Frederica Zhang (based on pseudocode in notes)
     Date: Dec. 10, 2019
     Purpose: sort the aClone using a shell sort algorithm
     Parameters: none
     Returns: nothing
    */
    public void shell ()
    {
	int gap = 1;
	int hold;
	int index;
	int temp;

	while (gap <= size)
	    gap = gap * 3 + 1;

	do
	{
	    gap = gap / 3;
	    for (int count = gap ; count < size ; count++)
	    {
		hold = aClone [count];
		index = count - gap;
		while (index >= 0 && aClone [index] > hold)
		{
		    temp = aClone [index + gap];
		    aClone [index + gap] = aClone [index];
		    aClone [index] = temp;
		    index = index - gap;
		}
		hold = aClone [index + gap];
	    }
	}
	while (gap > 1);
    }
}






