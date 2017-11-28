//Alvin Ye
//APCS1 pd1
//HW42--Array of Grade 316
//2017-11-28


/***************************
 * class SuperArray version 2.0
 * (SKELETON)
 * Wrapper class for array. Facilitates resizing,
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 ***************************/

public class SuperArray
{

    private int[] _data;  //underlying container
    private int _size;    //number of "meaningful" elements in this SuperArray


    //default constructor – initializes 10-item array
    public SuperArray()
    {
	_data = new int[10];
	_size = 0; //zero meaningful elements to start off
    }


    //output SuperArray in [a,b,c] format
    public String toString()
    {
	String foo = "[";
	for( int i = 0; i < _size; i++ ) { //iterates up to size, because there's no need to print the non-meaningful elements
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
	int[] temp = new int[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }


    //accessor -- return value at specified index
    public int get( int index )
    {
	return _data[index];
    }


    //mutator -- set value at index to newVal,
    //           return old value at index
    public int set( int index, int newVal )
    {
	int temp = _data[index];
	_data[index] = newVal;
	_size += 1; //after setting a new value, the _size increases

	return temp;
    }


    //adds an item after the last item
    public void add( int newVal )
    {
	_data[_size] = newVal;
	_size += 1; //after adding a value, the _size increases
    }


    //inserts an item at index
    //shifts elements right to insert the value
    public void add( int index, int newVal )
    {
	for(int position = _data.length - 1; position >= index; position --){ //iterates backwards from last position to index

	    int tempValue = _data[position - 1];

	    _data[position] = tempValue;   //replaces every value in each position with the value in the previous position

	}
	_data[index] = newVal;
	_size += 1; //after inserting an element and shifting the elements right, _size increases
    }
  

    
    //removes the item at index
    //shifts elements left to open up a newly empty index
    public void remove( int index )
    {
	for(int position = index; position < _data.length -1; position ++){ //iterates from index to last position
	    int tempValue = _data[position + 1];

	    _data[position] = tempValue; //assigns the current value at the position the value of the next position
	}
	_size -= 1; //after removing an element and shifting the array, _size decreases
    }


    //return number of meaningful items in _data
    public int size()
    {
	return _size;
    }



    //main method for testing
    public static void main( String[] args )
    {

	SuperArray curtis = new SuperArray();
	System.out.println( "Printing empty SuperArray curtis..." );
	System.out.println( curtis );

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set( i, i * 2 );
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < 3; i++ ) {
	    curtis.expand();
	    System.out.println("Printing expanded SuperArray curtis...");
	    System.out.println(curtis);
	    System.out.println("new length of underlying array: "
			       + curtis._data.length );
	}
 
	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

/*
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
*/
	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);


	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);

	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);



    }//end main()


}//end class
