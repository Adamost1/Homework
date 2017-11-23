// Alvin Ye
// APCS1 pd1
// HW40 -- Make it Better
// 2017-11-22

/*===================================
Version 1
=====================================
  - I imported Keyboard and all its methods

  - printArray returns a string representation of an array so it will make for easier testing

  - swap takes 5 parameters, one of which is a preset array (set in main method)
  	*it takes two sets of rows and columns which indicate the specific coordinate that is going to be swapped
 	 and the specific coordinates to swap to

  - in main method, I use Keyboard.readInt() to gather information about the parameters
     that I will use for swap()
      Once I get the values, I call swap() and print the "swapped" array

======================================
Version 2 (current version)
======================================
  - I added a fillString() method to return a single letter string with a random
 	letter from the final ALPHABET variable

 - I added a fillArray() method that iterates through an array, using fillString() to fill it with
 	4 character strings of random letters



  =====================================*/

import cs1.Keyboard;

public class Swapper{


    public final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String fillString(String string){ //returns a string of a single random letter
	int randNumber = (int) (Math.random() * 26);	
	string = ALPHABET.substring( randNumber, randNumber + 1);
	return string;
    }


    
    public static void fillArray(String[][] stringArray){ //fills an array of arrays with strings of randomly generated characters

	for(int positionRow = 0; positionRow < stringArray.length; positionRow ++){

		for(int positionColumn = 0; positionColumn < stringArray[positionRow].length; positionColumn ++){
			stringArray[positionRow][positionColumn] = fillString("") + fillString("") + fillString("") + fillString("");
		}
	}
    }



    
    public static String printArray(String[][] stringArray){ //to make it easier to print and see arrays
	String returnValue = "{\n";

	for(String[] array: stringArray){
	    returnValue += "{";
	    for(String string: array){
		returnValue += (string + ",");
	    }
	    returnValue = returnValue.substring(0, returnValue.length() - 1) + "},\n"; //substring is used to remove the extra comma
	}
	returnValue = returnValue.substring(0, returnValue.length() - 1); //substring is used to remove the extra comma 
	return returnValue + "\n}";
    }


    public static void swap(String[][] stringArray, int row, int column, int row2, int column2){ //swaps a string in an array of arrays from one coordinate to another
	String tempString = new String(stringArray[row2][column2]);

	stringArray[row2][column2] = stringArray[row][column];
	stringArray[row][column] = tempString;
    }




    public static void main(String[] args){

  
	String[][] a = new String[4][4]; //makes new String[][] array


	fillArray(a);
	System.out.println(printArray(a));


	System.out.println("\n\nOriginal Array:\n" + printArray(a) +"\n");
      
	System.out.println("What Row?" + " (Must be <= " + (a.length - 1) + ")"); 
	int row = Keyboard.readInt();

	System.out.println("What Column?"+ " (Must be <= " + (a[0].length - 1) + ")");
	int column = Keyboard.readInt();

	System.out.println("What Row to Swap To?" + " (Must be <= " + (a.length - 1) + ")");
	int row2 = Keyboard.readInt();

	System.out.println("What Column to Swap To?" + " (Must be <= " + (a[0].length - 1) + ")");
	int column2 = Keyboard.readInt();



	swap(a, row, column, row2, column2);

	System.out.println("Swapped Array:\n" + printArray(a));


    }//end main
}//end class
