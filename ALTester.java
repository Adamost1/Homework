//Alvin Ye
//APCS1 pd1
//HW46--Al<B> Sorted!.
//2017-12-4


import java.util.ArrayList;

public class ALTester{
    //Since ArrayList is being imported, all of its methods are already available to ALTester, so it does not need to be implemented.


    //returns true if list is sorted from least to greatest, and false otherwise
    public static boolean checkSorted(ArrayList<Comparable> foo){
		
	for(int i = 0; i < foo.size() - 1; i ++){ //it is foo.size()-1, so that foo.get(i+1) won't be out of range 
	    if((int) foo.get(i) > (int) foo.get(i + 1)){
		return false;
	    }
	}
	return true;
    }

    //populates an array with a desginated number of random integers
    public static void populateArray(ArrayList<Comparable> foo, int numValues){
    	int i = 0;

    	while(i < numValues){
    		foo.add( (int) (Math.random() * 100) ) ;
    		i ++;
    	}
    }


    public static void main(String[] args){
	ArrayList<Comparable> foo = new ArrayList<Comparable>();
	ArrayList<Comparable> food = new ArrayList<Comparable>();

	populateArray(foo, 23); //populates array in foo with 23 random integers 


	System.out.println(foo); //should have 23 elements
	System.out.println("Size of Array: " + foo.size());

	System.out.println("Array is sorted?: " + checkSorted(foo) + "\n"); //expect false

	food.add(1);
	food.add(2);
	food.add(3);
	food.add(4);
	food.add(4);
	food.add(4);

	System.out.println(food);
	System.out.println("Size of Array: " + food.size());

	System.out.println("Array is sorted?: " + checkSorted(food)); //expect true




    }
}
