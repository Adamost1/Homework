// Alvin Ye
// APCS1 pd1
// HW38 -- Put It Together
// 2017-11-21

/*===================================
- I imported Keyboard and all its methods

- returnString returns a string representation of an array so it will make for easier testing

- swap takes 5 parameters, one of which is a preset array (set in main method)
  *it takes two sets of rows and columns which indicate the specific coordinate that is going to be swapped
   and the specific coordinates to swap to

- in main method, I use Keyboard.readInt() to gather information about the parameters
  that I will use for swap()
  Once I get the values, I call swap() and print the "swapped" array

=====================================*/
import cs1.Keyboard;

public class Swapper{


	public static String returnString(String[][] stringArray){ //to make it easier to print and see arrays
		String returnValue = "{";

		for(String[] array: stringArray){
			returnValue += "{";
			for(String string: array){
				returnValue += string;
				returnValue += ",";
			}
			returnValue = returnValue.substring(0, returnValue.length() - 1) + "},"; //to remove the extra comma
		}
		returnValue = returnValue.substring(0, returnValue.length() - 1); //to remove the extra comma 
		return returnValue + "}";
	}


	public static void swap(String[][] stringArray, int row, int column, int row2, int column2){
		String tempString = new String(stringArray[row2][column2]);

		stringArray[row2][column2] = stringArray[row][column];
		stringArray[row][column] = tempString;
	}




	public static void main(String[] args){
		String[][] a = { {"s1", "s2"}, {"s3", "s4"}, {"s5", "s6"} };


/*Just for testing
		System.out.println(returnString(a));
		swap(a, 0, 0, 2, 1);

		System.out.println(returnString(a));
*/

      System.out.println("Original Array:\n" + returnString(a) +"\n");

      System.out.println("What Row?");
      int row = Keyboard.readInt();

      System.out.println("What Column?");
      int column = Keyboard.readInt();

      System.out.println("What Row to Swap To?");
      int row2 = Keyboard.readInt();

      System.out.println("What Column to Swap To?");
      int column2 = Keyboard.readInt();



      swap(a, row, column, row2, column2);

      System.out.println("Swapped Array:\n" + returnString(a));


	}
}