/***************************
 * interface ListInt
 * Declares methods that will be implemented by any
 *  class wishing to adhere to this specification.
 * This interface specifies behaviors of a list of ints.
 ***************************/

public interface List
{
  // Return number of elements in the list
  int size();

  // Append an int to the end. Return true.
  boolean add( java.lang.Object x );

  // Insert an int at index
  void add( int index, java.lang.Object o ); 

  // Retrieve the int at index
  java.lang.Object get( int index );

  // Overwrite the int at index
    java.lang.Object set( int index, java.lang.Object o );

  // Remove the int at index,
  // shifting any elements after it to the left.
  // Return removed value.
  java.lang.Object remove( int index );

}//end interface ListInt
