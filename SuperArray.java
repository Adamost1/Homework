// Alvin Ye
// APCS1 pd1
// HW45--In America, the Driver Sits on the Left
// 2017-12-2

/***************************
 * class SuperArray version 4.0
    Added functionality for all Objects to elements in the array
 ***************************/

public class SuperArray implements List
{
  //SuperArray implements ListInt, meaning it specifies the schematics of the methods established in ListInt

  private Object[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new Object[10];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
      foo += _data[i] + ",";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  private void expand()
  {
    Object[] temp = new Object[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
      temp[i] = _data[i];
    _data = temp;
  }


  //accessor -- return value at specified index
  public java.lang.Object get( int index )
  {
      if((index < 0) || (index >= _size)){
	  throw new ArrayIndexOutOfBoundsException("Cannot get value at index. Index out of range");
      }
    return _data[index];
  }


  //mutator -- set value at index to o,
  //           return old value at index
  public java.lang.Object set( int index, java.lang.Object o )
  {
      if(index < 0 || index >= _size){
	  throw new ArrayIndexOutOfBoundsException("Cannot set value at index. Index out of range");
      }
    Object temp = _data[index];
    _data[index] = o;
    return temp;
  }


  //adds an item after the last item
    public boolean add( java.lang.Object o )
  {
    add( _size, o );

    return true;
  }


  //inserts an item at index
  public void add( int index, java.lang.Object o )
  {
    //first expand if necessary
    if ( _size >= _data.length )
      expand();

    if((index < 0) || (index > _size)){
      throw new IndexOutOfBoundsException("Cannot add value at that index. Index out of range"); 
    }
    for( int i = _size; i > index; i-- ) {
      _data[i] = _data[i-1]; //each slot gets value of left neighbor
    }
    _data[index] = o;
    _size++;
  }


  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public java.lang.Object remove( int index )
  {
    Object returnObject = _data[index];

    if(index < 0 || index >= _size){
    throw new ArrayIndexOutOfBoundsException("Cannot remove value at index. Index out of range");
      }

    for( int i = index; i < _size - 1; i++ ) {
      _data[i] = _data[i+1];
    }
    _size--;

    return returnObject;
  }


  //return number of meaningful items in _data
  public int size()
  {
    return _size;
  }



  //main method for testing
  public static void main( String[] args )
  {

    List junefield = new SuperArray(); //this is an array to be added into mayfield array
    junefield.add("String");
    junefield.add(3.1415);
    junefield.add(500);

    List mayfield = new SuperArray();
    System.out.println("Printing empty SuperArray mayfield...");
    System.out.println(mayfield);

//when printing the return value of a method, it also runs the method
    System.out.println("Adding value. Should return true:\n" + mayfield.add(5));
    System.out.println("Adding value. Should return true:\n" + mayfield.add(4.12321));
    System.out.println("Adding value. Should return true:\n" + mayfield.add("3"));
    System.out.println("Adding value. Should return true:\n" + mayfield.add("Alvin"));
    System.out.println("Adding value. Should return true:\n" + mayfield.add(junefield));

    System.out.println("Printing populated SuperArray mayfield...");
    System.out.println(mayfield);

    System.out.println("Value to remove: " + mayfield.remove(3));
    System.out.println("Printing SuperArray mayfield post-remove...");
    System.out.println(mayfield);

    System.out.println("Value to remove: " + mayfield.remove(3));
    System.out.println("Printing SuperArray mayfield post-remove...");
    System.out.println(mayfield);


    mayfield.add(3,99);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    mayfield.add(2,88);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    mayfield.add(1,77);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);

    System.out.println("\nShould return Error message: \n");
    System.out.print(mayfield.get(-1));
    mayfield.set(100, 999);


  }//end main()


}//end class


/***
             ,,########################################,,
          .*##############################################*
        ,*####*:::*########***::::::::**######:::*###########,
      .*####:    *#####*.                 :*###,.#######*,####*.
     *####:    *#####*                      .###########*  ,####*
  .*####:    ,#######,                        ##########*    :####*
  *####.    :#########*,                       ,,,,,,,,.      ,####:
    ####*  ,##############****************:,,               .####*
     :####*#####################################**,        *####.
       *############################################*,   :####:
        .#############################################*,####*
          :#####:*****#####################################.
            *####:                  .,,,:*****###########,
             .*####,                            *######*
               .####* :*#######*               ,#####*
                 *###############*,,,,,,,,::**######,
                   *##############################:
                     *####*****##########**#####*
                      .####*.            :####*
                        :####*         .#####,
                          *####:      *####:
                           .*####,  *####*
                             :####*####*
                               *######
                                 *##

         -Miranda Chaiken '16

         ***/
