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

public class MatrixFinder {

    public static String finder(int[][] matrix, int target)
    {
	int c = matrix.length - 1;
	int r = 0;
	int x = matrix[0][c];

	while ( x != target)
	    {
		if ( x < target)   // if current elem is less than index
		    {
		    	if( r + 1 >= matrix.length){ //if it is currently at the last row, it has to iterate through the row

			    if(c == 0){ //if it is at column 0, it means that the value has not been found and doesn't exist in array
				return "(-1, -1)";
			    }

			    else{ // it iterates through the last row and updates x, using the while loop to check if x is equal to target
				c--;
				x = matrix[r][c]; 
			    }
			    
		    	}

			else{
			    r++;   // go down to next row
			    c = matrix.length - 1;
			    x = matrix[r][c];
			}
		    }

		else
		    {
		    	if( c - 1 < 0){
			    return "(-1,-1)";
		    	}
		    	else{
			    c--;
			    x = matrix[r][c];
			}

		    }


	    } // end while loop

	return ("(" + r + "," +  c + ")");
    } // end method finder


    public static void main(String[] args)
    {
	int[][] m =  { {1,2,3}, {2,3,4}, {3,4,5} };
	System.out.println( finder( m,  5));  // should return (2,2)
	System.out.println( finder( m,  3));  // should return (0,2) -- BEST CASE, at top-right
	System.out.println( finder( m, -1));  // should return (-1,-1)
	System.out.println( finder( m,  6));  // should return (-1,-1)


	System.out.println( "=========================================");
	
	int[][] m2 = { {1} };
	System.out.println( finder( m2, 1));  // should return (0,0)
	System.out.println( finder( m2, 0));  // should return (-1,-1)

	System.out.println( "=========================================");

	int[][] m3 = { {12, 15, 18}, {15, 18, 20}, {100, 200, 250}};
	System.out.println( finder( m3,  18)); // should return (0,2)
	System.out.println( finder( m3, 100)); // should return (2,0) -- WORST CASE, at bottom-left
	System.out.println( finder( m3, 200)); // should return (2,1)
	System.out.println( finder( m3, 250)); // should return (2,2)


    } // end main method


} // end class MatrixFinder
		
