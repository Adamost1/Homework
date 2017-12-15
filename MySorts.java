//Alvin Ye (Team Blue Tigers) (Row number 4, from the door)
//APCS1 pd1
//HW55--Never Fear, Big Oh is Here!
//2017-12-14

import java.util.ArrayList;

public class MySorts{


/*===================================
Worst Case: array is in opposite order
bubbleSort is O(n^2) because for each
element, you need to iterate through
the whole array in order to swap or 
pass every adjacent pair of numbers.

Best Case: all already in order
O(n) because it will iterate 
through the whole array and not need
to swap anything.
====================================*/

    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSort( ArrayList<Comparable> data )
    {
	//make n-1 passes across collection
	for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {

	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size()-1; i++ ) {
		//if element at i > element at i+1, swap
		if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) 
		    data.set( i, data.set(i+1,data.get(i)) );	
		//System.out.println(data); //diag: show current state of list
	    }
	}
    }//end bubbleSort



/*===================================
Worst Case: array is in opposite order
selectionSort is O(n^2) because for
element, you need to iterate through
almost the whole array to find the 
greatest number to move to the end. 

Best Case: all already in order
O(n) because it will just need to
iterate through the array once and
not need to swap any element anywhere
except to its own index
====================================*/
    public static void selectionSort( ArrayList<Comparable> data ) 
    {
	//note: this version places greatest value at rightmost end,

	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;

	for( int pass = data.size()-1; pass > 0; pass-- ) {
	    maxPos = 0;
	    for( int i = 1; i <= pass; i++ ) {
		if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
		    maxPos = i;
	    }
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
	}
    }//end selectionSort



/*===================================
Worst Case: alternating numbers {big, small, big...}
insertionSort is O(n^2) because for 
each element, you need to iterate 
through almost the whole sorted array to find
out where to insert the number. 

Best Case: all already in order
O(n) because you only need to iterate
through the array once and not need to
insert or remove anything, except to 
its own index
====================================*/

    // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void insertionSort( ArrayList<Comparable> data )
    {
	for( int partition = 1; partition < data.size(); partition++ ) {
	    //partition marks first item in unsorted region

	    //traverse sorted region from right to left
	    for( int i = partition; i > 0; i-- ) {

		// "walk" the current item to where it belongs
		// by swapping adjacent items
		if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
		    data.set( i, data.set( i-1, data.get(i) ) ); 
		}
		else 
		    break; 
	    }
	}
    }//end insertionSort

    



}
