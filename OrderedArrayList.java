//Alvin Ye
//APCS1 pd1
//HW47-- ascending
//2017-12-5


import java.util.ArrayList;

public class OrderedArrayList{
    //Since ArrayList is being imported, all of its methods are already available to ALTester, so it does not need to be implemented.


    //returns true if list is sorted from least to greatest, and false otherwise
    public static boolean checkSorted(ArrayList<Comparable> foo){
		
	for(int i = 0; i < foo.size() - 1; i ++){ //it is foo.size()-1, so that foo.get(i+1) won't be out of range 
	    if( ((Integer) foo.get(i)).compareTo((Integer) foo.get(i + 1)) > 0){
		return false;
	    }
	}
	return true;
    }

    //populates an array with a designated number of random integers
    public static void populateArray(ArrayList<Comparable> foo, int numValues){
    	int i = 0;

    	while(i < numValues){
    		foo.add( (int) (Math.random() * 100) ) ;
    		i ++;
    	}
    }


//sorts the objects in an array from least to greatest
    public static void sort(ArrayList<Comparable> foo){

	for(int counter = foo.size(); counter > 0; counter --){//this counter just loops the for loop many times, enough to sort the whole array (number of loops determined by the size of the foo array)
    	for(int i = 0; i < foo.size() - 1; i++){ //swaps every two consective element in an array, putting the smaller value first

    			int tempVal = Math.min((int)foo.get(i), (int)foo.get(i + 1));

    			foo.set(i+1, Math.max((int)foo.get(i), (int)foo.get(i + 1)));
    			foo.set(i, tempVal);    		
    	}
    }
	}



    public static void main(String[] args){
	ArrayList<Comparable> foo = new ArrayList<Comparable>();
	ArrayList<Comparable> food = new ArrayList<Comparable>();
	ArrayList<Comparable> fool = new ArrayList<Comparable>();

	populateArray(foo, 23); //populates array in foo with 23 random integers 


	System.out.println(foo); //should have 23 elements
	System.out.println("Size of Array: " + foo.size());

	System.out.println("Array is sorted?: " + checkSorted(foo) + "\n"); //expect false

	food.add(1);
	food.add(2);
	food.add(3);
	food.add(3);
	food.add(4);
	food.add(4);

	System.out.println(food);
	System.out.println("Size of Array: " + food.size());
	System.out.println("Array is sorted?: " + checkSorted(food)); //expect true


	populateArray(fool, 13);

	System.out.println("\n" + fool);
	System.out.println("Size of Array: " + fool.size());

	System.out.println("Array is sorted?: " + checkSorted(fool)); //expect false
	System.out.println("Sorted array:");
	sort(fool);
	System.out.println(fool);



    }
}//end class
