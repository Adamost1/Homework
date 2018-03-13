//Alvin Ye
//APCS2 pd8
//HW18 -- QuickSort
//2018-03-13
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): 
    1) if the array to-be-partitioned reaches 1 element, end the call
    2) partition the original array
    3) make a recurisive call to number 1 with the left and right partitions of the array 
    4) After 1-3, combine both left and right, which should be sorted
 *
 * 2a. Worst pivot choice and associated runtime: 
 *  If the pivot ends up being either of the extremes, the runtime will be slightly longer but still O(nlogn)

 * 2b. Best pivot choice and associated runtime:
 * If the pivot ends up being the median, then the runtime will be O(nlogn)
 
 * 3. Approach to handling duplicate values in array:
 *  Let the algorithm run, it will place duplicates next to each other
 *****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array 
  public static void printArr( int[] a ) {
    for ( int o : a )
	    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------

  public static int partition( int arr[], int a, int b, int c)
  {
    int v = arr[c];

    swap( c, b, arr);
    int s = a;

    for( int i = a; i < b; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
    }
    swap(s,b,arr);

    return s;
  }//end partition

  /*****************************************************
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   *****************************************************/
  public static void qsort( int[] d )
  { 
    if(d.length <= 1){ //if the array is 1 elements, end current call  
      return;
    }

    else{
      int pivotIndex = partition(d, 0, d.length - 1, d.length - 1 ); //pivot is set to last index

      int[] left = new int[pivotIndex]; //creates new temp array for left of pivot

      for(int i = 0; i < pivotIndex; i++){ //fills up temporary array
        left[i] = d[i];
      }

      int[] right = new int[d.length - pivotIndex]; //creates new temp array for right of pivot

      for(int i = pivotIndex + 1; i < d.length; i++){ //fills up temporary array
        right[i - pivotIndex] = d[i];
      }

      qsort(left); //partitions left side
      qsort(right); //partitions right side

      for(int i = 0; i < pivotIndex; i++){ //fills up original array with the new left side
        d[i] = left[i];
      }

      for(int i = pivotIndex + 1; i < d.length; i++){ //fills up original array with the new right side
        d[i] = right[i - pivotIndex];
      }


    }

  }

  //you may need a helper method...


  //main method for testing
  public static void main( String[] args )
  {


    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );	
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;
       
    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);

        /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/




    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );	
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );
       
    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);


    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);


    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);


    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
