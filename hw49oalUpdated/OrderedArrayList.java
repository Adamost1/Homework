//Alvin Ye
//APCS1--pd1
//hw49--Halving the Halves
//2017-12-7

/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList()
    {
	_data = new ArrayList<Comparable>();    
    }


    public String toString()
    {
	return _data.toString(); 
    }


    public Comparable remove( int index )
    {	
	return _data.remove(index); 
    }


    public int size()
    { 
	return _data.size();
    }

    
    public Comparable get( int index )
    { 
	return _data.get(index); 
    }


    /***
     * add takes as input any comparable object 
     * (i.e., any object of a class implementing interface Comparable)
     * inserts newVal at the appropriate index
     * maintains ascending order of elements
     * uses a linear search to find appropriate index
     ***/
    public void add( Comparable newVal )
    { 
	for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
		//newVal < oal[p]
		_data.add( p, newVal );
		return; //Q:why not break?
	    }
	}
	_data.add( newVal ); //newVal > every item in oal, so add to end 
    }




    public void addBin(Comparable newVal){
 
	int upperBound = _data.size();
	int lowerBound = 0;
	int index = ((upperBound + lowerBound) / 2);

	if((newVal.compareTo(_data.get(_data.size()-1))) >= 0){ //if it is greater than the greatest number, add the newVal to the end of array
	    _data.add(_data.size(), newVal);
	    return;
	}

	else if((newVal.compareTo(_data.get(0)) <= 0)){ //if it is less than the least number, add the newVal
	    _data.add(0, newVal);
	    return;
	}



	while( !(   (newVal.compareTo(_data.get(index + 1)) <= 0) && (newVal.compareTo(_data.get(index - 1)) >= 0)    )) { //while(!(newVal<=_data[index + 1] && newVal>=_data[index - 1]) 
	    System.out.println("lowerBound: " + lowerBound);
	    System.out.println("upperBound: " + upperBound);

	    if(  (newVal.compareTo(_data.get(index))) < 0  ){
		upperBound = index;
		index = ((upperBound + lowerBound) / 2);

	    }

	    else if( (newVal.compareTo(_data.get(index))) > 0 ){
		lowerBound = index;
		index = ((upperBound + lowerBound) / 2);
	    }


	}


	_data.add(index, newVal); //if newVal is sandwiched between a greater and smaller number, add newVal to that index
	return;


    }



    

    // main method solely for testing purposes
    public static void main( String[] args )
    {
	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
	for( int i = 0; i < 15; i++ )
	    Franz.add( (int)( 50 * Math.random() ) );
	System.out.println( Franz );

	//check for sorted-ness
	//if msg does not appear, list was sorted
	for( int i=0; i<Franz.size()-1; i++ ) {
	    System.out.println("at i: " + Franz.get(i) );
	    if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
		System.out.println( " *** NOT sorted *** " );
		break;
	    }
	}

	System.out.println("\nBefore adding:\n" + Franz);
	Franz.addBin(-100);
	System.out.println("After adding value:\n" + Franz);

	System.out.println("\nBefore adding:\n" + Franz);
	Franz.addBin(100);
	System.out.println("After adding value:\n" + Franz);

	System.out.println("\nBefore adding:\n" + Franz);
	Franz.addBin(27);
	System.out.println("After adding value:\n" + Franz);

    }//end main()

}//end class OrderedArrayList
