//Turquoise Tortoises
//Alvin Ye, Raymond Wu, Jessica Wu
//APCS2 pd8
//2018-02-01

/*- This method takes an int[][] array and an int parameter (for the target).
  - Start at the element at the top-right corner.
  - Goes down last column until it hits a value greater than target
  - Goes left until it finds target
  - returns (r,c) coordinates if found, else returns (-1,-1)
  - this runs in O(n) time
*/

import java.lang.*;

public class MatrixFinder {

    public static String finder(int[][] matrix, int target)
    {
	int c = matrix.length - 1;
	int r = 0;
	int x = matrix[0][c];

	while ( x != target) 
	    {
		if ( x < target)   // if current elem is less than target
		    {
		    	if( r + 1 >= matrix.length){ //if it is currently at the last row, it has to iterate through the row

			    if(c == 0){ //if it is at column 0, it means that the value has not been found and doesn't exist in array
				return "(-1, -1)";
			    }

			    else{ // it iterates through the last row and updates x, using the while loop to check if x is equal to target
				c--;
				x = matrix[r][c]; //x is updated so the while loop can check to see if it found the target
			    }
			    
		    	}

			else{ // if it is not at the last row, it will just move down one row
			    r++;  
			    c = matrix.length - 1; //resets c to the last column
			    x = matrix[r][c]; //x is updated so the while loop can check to see if it found the target
			}
		    }

		else //if current element is not less than target, it means the value has to be in the current row, so it iterates through row
		    {
		    	if( c == 0){ //if it is at column 0, it means that the value has not been found and doesn't exist in array
			    return "(-1,-1)";
		    	}
		    	else{ // it iterates through the current  row and updates x, using the while loop to check if x is equal to target
			    c--;
			    x = matrix[r][c]; //x is updated so the while loop can check to see if it found the target
			}

		    }


	    } // end while loop

	return ("(" + r + "," +  c + ")"); // if it breaks out of the while loop, it means that the value has been found. Returns the row and column coordinates.
    } // end method finder


    public static int[][] randomMatrix(int n){ //creates a random matrix with a different value in the bottom left in order to allow for a "worst value" test
    	int[][] matrix = new int[n][n];
    	int increment = (int) (Math.random() * 11) + 2; //sets the increment from 2 to 10
    	matrix[0][0] = (int) (Math.random() * 101); //sets a random int in the top left row from 0 to 100

    	for(int c = 1; c < n; c ++){ //iterates through the first row to set the values
    		matrix[0][c] = ( matrix[0][c - 1] + increment ); //increases by the increment
    	}

    	for(int r = 1; r < n; r ++){ //iterates through all the other rows to set the values
    		matrix[r][0] = ( matrix[r - 1][0] + increment); //sets the first value of each row by adding the increment to the number right above it
    		for(int c = 1; c < n; c++){
    			matrix[r][c] = ( matrix[r][c - 1] + increment); //increases each successive value by the increment
    		}
    	}

    	matrix[n - 1][0] = (matrix[n - 1][1] - 1); //alters the value of the element at the bottom left of matrix
    	return matrix;
    }


    public static void main(String[] args)
    {

    int[][] matrix = randomMatrix(4);

//prints out string representation of matrix
    for(int[] r: matrix){
    	System.out.print("| ");
    	for(int i: r){
    		System.out.print(i + " ");
    	}
    	System.out.print("|\n");
    }

    System.out.println("\nWorst Case: finding " + matrix[matrix.length - 1][0]);

//=====================================================================================================================
//=====================================================================================================================
    System.out.println("\n============== Running 5,000,000 times... ==============");
	long timeBefore0 = System.currentTimeMillis();

    for(int counter = 0; counter <= 5000000; counter ++){
		finder(matrix, matrix[matrix.length - 1][0]);
    }

    long timeAfter0 = System.currentTimeMillis();

    System.out.print("\nTime Before: ");
    System.out.println(timeBefore0);

    System.out.print("\nTime After: ");
    System.out.println(timeAfter0);

    System.out.println("\nMilliseconds Elapsed: ");
    System.out.println(timeAfter0 - timeBefore0);

//=====================================================================================================================
//=====================================================================================================================
    System.out.println("\n============== Running 10,000,000 times... ==============");
	long timeBefore1 = System.currentTimeMillis();

    for(int counter = 0; counter <= 10000000; counter ++){
		finder(matrix, matrix[matrix.length - 1][0]);
    }

    long timeAfter1 = System.currentTimeMillis();

    System.out.print("\nTime Before: ");
    System.out.println(timeBefore1);

    System.out.print("\nTime After: ");
    System.out.println(timeAfter1);

    System.out.println("\nMilliseconds Elapsed: ");
    System.out.println(timeAfter1 - timeBefore1);

//=====================================================================================================================
//=====================================================================================================================
    System.out.println("\n============== Running 15,000,000 times... ==============");
	long timeBefore2 = System.currentTimeMillis();

    for(int counter = 0; counter <= 15000000; counter ++){
		finder(matrix, matrix[matrix.length - 1][0]);
    }

    long timeAfter2 = System.currentTimeMillis();

    System.out.print("\nTime Before: ");
    System.out.println(timeBefore2);

    System.out.print("\nTime After: ");
    System.out.println(timeAfter2);

    System.out.println("\nMilliseconds Elapsed: ");
    System.out.println(timeAfter2 - timeBefore2);

//=====================================================================================================================
//=====================================================================================================================
    System.out.println("\n============== Running 20,000,000 times... ==============");
	long timeBefore3 = System.currentTimeMillis();

    for(int counter = 0; counter <= 20000000; counter ++){
		finder(matrix, matrix[matrix.length - 1][0]);
    }

    long timeAfter3 = System.currentTimeMillis();

    System.out.print("\nTime Before: ");
    System.out.println(timeBefore3);

    System.out.print("\nTime After: ");
    System.out.println(timeAfter3);

    System.out.println("\nMilliseconds Elapsed: ");
    System.out.println(timeAfter3 - timeBefore3);

//=====================================================================================================================
//=====================================================================================================================
    System.out.println("\n============== Running 25,000,000 times... ==============");
	long timeBefore4 = System.currentTimeMillis();

    for(int counter = 0; counter <= 25000000; counter ++){
		finder(matrix, matrix[matrix.length - 1][0]);
    }

    long timeAfter4 = System.currentTimeMillis();

    System.out.print("\nTime Before: ");
    System.out.println(timeBefore4);

    System.out.print("\nTime After: ");
    System.out.println(timeAfter4);

    System.out.println("\nMilliseconds Elapsed: ");
    System.out.println(timeAfter4 - timeBefore4);

//=====================================================================================================================
//=====================================================================================================================
    System.out.println("\n============== Running 30,000,000 times... ==============");
	long timeBefore5 = System.currentTimeMillis();

    for(int counter = 0; counter <= 30000000; counter ++){
		finder(matrix, matrix[matrix.length - 1][0]);
    }

    long timeAfter5 = System.currentTimeMillis();

    System.out.print("\nTime Before: ");
    System.out.println(timeBefore5);

    System.out.print("\nTime After: ");
    System.out.println(timeAfter5);

    System.out.println("\nMilliseconds Elapsed: ");
    System.out.println(timeAfter5 - timeBefore5);

//=====================================================================================================================
//=====================================================================================================================

    //**************** EDIT THESE VALUES AS YOU EDIT THE TEST CASES ***************
    System.out.println("\n============== Useful Data ============== ");

    System.out.println("Rate [runs / millisecond] of Each Test (constant number indicates O(n) runtime): ");
    System.out.println((double) 5000000 / (timeAfter0 - timeBefore0));
    System.out.println((double) 10000000 / (timeAfter1 - timeBefore1));
    System.out.println((double) 15000000 / (timeAfter2 - timeBefore2));
    System.out.println((double) 20000000 / (timeAfter3 - timeBefore3));
    System.out.println((double) 25000000 / (timeAfter4 - timeBefore4));
    System.out.println((double) 30000000 / (timeAfter5 - timeBefore5));

    System.out.print("\nApproximate Average Slope (runs per millisecond): ");
    System.out.print((double) (30000000 - 5000000) / ((timeAfter5 - timeBefore5) - (timeAfter0 - timeBefore0))); 


//=====================================================================================================================
//=====================================================================================================================
   System.out.println("\n\n============== Running 1 time for a new random 2,000 x 2,000 Matrix ==============");
   int[][] matrix0 = randomMatrix(2000);

   long before0 = System.currentTimeMillis();


   		finder(matrix0, matrix0[matrix0.length - 1][0]);

   long after0 = System.currentTimeMillis();

    System.out.print("\nTime Before: ");
    System.out.println(before0);

    System.out.print("\nTime After: ");
    System.out.println(after0);

    System.out.println("\nMilliseconds Elapsed: ");
    System.out.println(after0 - before0);

//=====================================================================================================================
//=====================================================================================================================
   System.out.println("\n============== Running 1 time for a new random 4,000 x 4,000 Matrix ==============");
   int[][] matrix1 = randomMatrix(4000);

   long before1 = System.currentTimeMillis();


   	finder(matrix1, matrix1[matrix1.length - 1][0]);

   long after1 = System.currentTimeMillis();

    System.out.print("\nTime Before: ");
    System.out.println(before1);

    System.out.print("\nTime After: ");
    System.out.println(after1);

    System.out.println("\nMilliseconds Elapsed: ");
    System.out.println(after1 - before1);

//=====================================================================================================================
//=====================================================================================================================
   System.out.println("\n============== Running 1 time for a new random 6,000 x 6,000 Matrix ==============");
   int[][] matrix2 = randomMatrix(6000);

   long before2 = System.currentTimeMillis();


   	finder(matrix2, matrix2[matrix2.length - 1][0]);

   long after2 = System.currentTimeMillis();

    System.out.print("\nTime Before: ");
    System.out.println(before2);

    System.out.print("\nTime After: ");
    System.out.println(after2);

    System.out.println("\nMilliseconds Elapsed: ");
    System.out.println(after2 - before2);

//=====================================================================================================================
//=====================================================================================================================
   System.out.println("\n============== Running 1 time for a new random 8,000 x 8,000 Matrix ==============");
   int[][] matrix3 = randomMatrix(8000);

   long before3 = System.currentTimeMillis();


   finder(matrix3, matrix3[matrix3.length - 1][0]);

   long after3 = System.currentTimeMillis();

    System.out.print("\nTime Before: ");
    System.out.println(before3);

    System.out.print("\nTime After: ");
    System.out.println(after3);

    System.out.println("\nMilliseconds Elapsed: ");
    System.out.println(after3 - before3);

//=====================================================================================================================
//=====================================================================================================================
   System.out.println("\n============== Running 1 time for a new random 10,000 x 10,000 Matrix ==============");
   int[][] matrix4 = randomMatrix(10000);

   long before4 = System.currentTimeMillis();


   finder(matrix4, matrix4[matrix4.length - 1][0]);

   long after4 = System.currentTimeMillis();

    System.out.print("\nTime Before: ");
    System.out.println(before4);

    System.out.print("\nTime After: ");
    System.out.println(after4);

    System.out.println("\nMilliseconds Elapsed: ");
    System.out.println(after4 - before4);

//=====================================================================================================================
//=====================================================================================================================

    //**************** EDIT THESE VALUES AS YOU EDIT THE TEST CASES ***************
    System.out.println("\n============== Useful Data ============== ");

    System.out.println("Rate [milliseconds / length of of matrix (n)] of Each Test (constant number indicates O(n) runtime): ");
    System.out.println((double) (after0 - before0) / 2000);
    System.out.println((double) (after1 - before1) / 4000);
    System.out.println((double) (after2 - before2) / 6000);
    System.out.println((double) (after3 - before3) / 8000);
    System.out.println((double) (after4 - before4) / 10000);












    } // end main method


} // end class MatrixFinder
		
