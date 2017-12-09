//Alvin Ye
//APCS1 pd1
//HW50--That Bubbly Though
//2017-12-8

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 ******************************/

import java.util.ArrayList;

public class BubbleSort {

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {

  for(int counter = data.size(); counter > 0; counter --){//this counter just loops the for loop many times, enough to sort the whole array (number of loops determined by the size of the data array)
      for(int i = 0; i < data.size() - 1; i++){ //swaps every two consective element in an array, putting the smaller value first

    int tempVal = Math.min((int)data.get(i), (int)data.get(i + 1));

    data.set(i+1, Math.max((int)data.get(i), (int)data.get(i + 1)));
    data.set(i, tempVal);        
      }
  }

  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    bubbleSortV(input); //sorts the array then returns it
    return input;
  }


  public static void main( String [] args )
  {

//====== for BubbleSortV method =============
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );

      System.out.println("");


//====== for bubbleSort method ===============
    	ArrayList ben = new ArrayList<Integer>();
      ben.add(7);
      ben.add(1);
      ben.add(5);
      ben.add(12);
      ben.add(3);
      System.out.println( "ArrayList ben before sorting:\n" + ben );
      ArrayList benSorted = bubbleSort( ben );
      System.out.println( "sorted version of ArrayList ben:\n" 
      + benSorted );
      System.out.println( "ArrayList ben after sorting:\n" + ben );

      ArrayList cocoa = populate( 10, 1, 1000 );
      System.out.println( "ArrayList cocoa before sorting:\n" + cocoa );
      ArrayList cocoaSorted = bubbleSort( cocoa );
      System.out.println( "sorted version of ArrayList cocoa:\n" 
      + cocoaSorted );
      System.out.println( "ArrayList cocoa after sorting:\n" + cocoa );

  

  }//end main

}//end class BubbleSort
