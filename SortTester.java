//Alvin Ye (Team Blue Tigers) (Row number 4, from the door)
//APCS1 pd1
//HW53--Solid Comparative Analysis
//2017-12-13

import java.util.ArrayList;

public class SortTester{

    public static void main(String[] args){
	
	ArrayList<Comparable> bestCaseBub = new ArrayList<Comparable>();
	ArrayList<Comparable> worstCaseBub = new ArrayList<Comparable>();

	ArrayList<Comparable> bestCaseSel = new ArrayList<Comparable>();
	ArrayList<Comparable> worstCaseSel = new ArrayList<Comparable>();

	ArrayList<Comparable> bestCaseIns = new ArrayList<Comparable>();
	ArrayList<Comparable> worstCaseIns = new ArrayList<Comparable>();


/*===================================
--------Bubble sort------------------
best case scenario is when the array is
all sorted because you won't need to 
swap anything
=====================================*/
	bestCaseBub.add(1); 
	bestCaseBub.add(2);
	bestCaseBub.add(3);
	bestCaseBub.add(4);
	bestCaseBub.add(5);

/*===================================
---------Bubble sort------------------
worst case scenario is when the array is 
in the opposite order you want to sort it
in because then you would need to keep 
swapping every element until it reaches 
the end of the array
=====================================*/
	worstCaseBub.add(5); 
	worstCaseBub.add(4);
	worstCaseBub.add(3);
	worstCaseBub.add(2);
	worstCaseBub.add(1);

/*==================================
---------Selection sort-------------
best case scenario is when the array 
is all sorted because then you won't 
need to swap anything.
===================================*/
	bestCaseSel.add(1);
	bestCaseSel.add(2);
	bestCaseSel.add(3);
	bestCaseSel.add(4);
	bestCaseSel.add(5);

/*==================================
---------Selection sort-------------
worst case scenario is when the array
is alternating from biggest value,
smallest value, etc... so that every
swap will make the array a little 
"worse" by moving each of the smallest
values to the end, furthest from where
they belong.
===================================*/

	worstCaseSel.add(5);
	worstCaseSel.add(1);
	worstCaseSel.add(4);
	worstCaseSel.add(2);
	worstCaseSel.add(3);

/*==================================
-----------Insertion sort-----------
best case scenario is when the array is
all sorted, so that you won't need to 
insert any values into the sorted array,
only needing to increase the size of the
sorted array.
===================================*/   
	
	bestCaseIns.add(1);
	bestCaseIns.add(2);
	bestCaseIns.add(3);
	bestCaseIns.add(4);
	bestCaseIns.add(5);

/*==================================
-----------Insertion sort-----------
worst case scenario is when the array is
in the opposite order you want to sort
it in, because then you would need to 
iterate more to find the right index
in the sorted array to find the right 
place to insert the current value
===================================*/

	worstCaseIns.add(5);
	worstCaseIns.add(4);
	worstCaseIns.add(3);
	worstCaseIns.add(2);
	worstCaseIns.add(1);

//============================Tests==========================
MySorts.bubbleSort(bestCaseBub);
System.out.println(bestCaseBub);

MySorts.bubbleSort(worstCaseBub);
System.out.println(worstCaseBub);

MySorts.selectionSort(bestCaseSel);
System.out.println(bestCaseSel);

MySorts.selectionSort(worstCaseSel);
System.out.println(worstCaseSel);

MySorts.insertionSort(bestCaseIns);
System.out.println(bestCaseIns);

MySorts.insertionSort(worstCaseIns);
System.out.println(worstCaseIns);

    }

}
