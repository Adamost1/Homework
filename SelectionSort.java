//Alvin Ye
//APCS1 pd1
//HW51 -- Selection
//2017-12-11

/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/

import java.util.ArrayList;

public class SelectionSort 
{
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
    for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data ) 
  {
      Comparable minNum;
      int minIndex = 0;

      for(int i = 0; i < (int) data.size() - 1; i ++){ //iterates through the whole array, < size() - 1 so won't produce OOB error
        minNum = data.get(i); //minumum value is set to the element at current index, so that if no value is less than current value, it will swap with itself


        for(int index = (i + 1); index < (int) data.size(); index ++){ //this for loop iterates through the rest of the array, ahead of the current index
          if((int) data.get(index) < (int) minNum){    // checks to see if each element is less than the minNum (element at current position). If so, it becomes the new minNum
            minNum = data.get(index);
            minIndex = index;          //minIndex set to index where the minNum is found, so it can be used to swap later
          }
        }

        data.set(minIndex, data.get(i)); //sets element at index of the minNum to the element in the current position
        data.set(i, minNum); //sets element at current index with the minNum

        minIndex = (i + 1); //resets minIndex to the current index, because its the new minNum
      }
 
  }//end selectionSortV


  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  

  public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) 
  {

    ArrayList<Comparable> foo = new ArrayList<Comparable>();
    for( Comparable c : input )
      foo.add(c);
    selectionSortV( foo );
    return foo;    
  }//end selectionSort 


  public static void main( String [] args ) 
  {
              /*===============for VOID methods=============
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    selectionSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );


      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      selectionSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );

      ============================================*/


    	ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = selectionSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = selectionSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
          /*==========for AL-returning methods==========
      ============================================*/

  }//end main

}//end class SelectionSort
