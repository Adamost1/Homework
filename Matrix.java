//Alvin Ye
//APCS1 pd1
//HW59--Make the Matrix Work For You
//2017-12-20

/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/


public class Matrix 
{
    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix( ) 
    {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) 
    {
	matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    private int size() 
    {
	return matrix.length;
    }


    //return the item at the specified row & column   
    private Object get( int r, int c ) 
    {
	return matrix[r][c];
    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) 
    {
	return get(r,c) == null;

    }

    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) 
    {
	Object tempVal = matrix[r][c];

	matrix[r][c] = newVal;

	return tempVal; 
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() 
    {
	String retVal = "| ";
	int row = 0;
	for(int counter = size(); counter > 0; counter --){
	    for(int column = 0; column < size(); column ++){
		retVal += (matrix[column][row] + " ");
	    }
	    retVal += "|\n| ";
	    row ++;
	}

	return retVal.substring(0, retVal.length()-2) ; //removes the extra "|"
 

    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) 
    {
	return size() == ((Matrix) rightSide).size();
    }


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) 
    {
	Object tempVal;

	for(int row = 0; row < size(); row ++){
	    tempVal = matrix[c1 - 1][row];

	    matrix[c1 - 1][row] = matrix[c2 - 1][row];

	    matrix[c2 - 1][row] = tempVal;
	}
    }


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) 
    {
	Object tempVal;
    
	for(int column = 0; column < size(); column++){
	    tempVal = matrix[column][r1 - 1];

	    matrix[column][r1 - 1] = matrix[column][r2 - 1];

	    matrix[column][r2 - 1] = tempVal;
	}

    }

    //returns copy of row r

    public Object[] getRow( int r ) {
	Object[] retVal = new Object[size()];

	for(int column = 0; column < size(); column ++){
	    retVal[column] = matrix[column][r - 1];  
	}
	return retVal;
    }//O(n)


    //replaces row r with 1D array newRow

    //returns old row

    public Object [] setRow( int r, Object[] newRow ) {

	Object[] oldRow = new Object[size()];

	for(int column = 0; column < size(); column ++){
	    oldRow[column] = matrix[column][r - 1];

	    matrix[column][r - 1] = newRow[column];
	}

	return oldRow;
    }//O(n)


    //replaces column c with 1D array newCol

    //returns old column
    public Object [] setCol( int c, Object[] newCol ) {

	Object[] oldCol = new Object[size()];

	for(int row = 0; row < size(); row ++){
	    oldCol[row] = matrix[c - 1][row];

	    matrix[c - 1][row] = newCol[row];
	}

	return oldCol;
    }//O(n)

    //turns all of the rows of the matrix into columns and vice versa
    public void transpose() {
	Object[][] newMatrix = new Object[size()][size()];

	for(int column = 0; column < size(); column ++){
	    for(int row = 0; row < size(); row ++){
		newMatrix[row][column] = matrix[column][row]; //reverses the order of row and column
	    }
	}

	matrix = newMatrix;
    }//O(n^2)


    //main method for testing
    public static void main( String[] args ) 
    {
	Matrix m = new Matrix(4);

	Matrix l = new Matrix(4);

	Matrix n = new Matrix(4);

	int num = 0; //populates matrix m with ordered numbers
	for(int column = 0; column < m.size(); column ++){
	    for(int row = 0; row < m.matrix[column].length; row ++){
		m.matrix[row][column] = num;
		num ++;
	    }
	}

	int num0 = 0; //populates matrix m with ordered numbers
	for(int column = 0; column < l.size(); column ++){
	    for(int row = 0; row < l.matrix[column].length; row ++){
		l.matrix[row][column] = num0;
		num0 ++;
	    }
	}

	System.out.println( m.size()); //expect 2

	System.out.println(m); 

	System.out.println(m.equals(n)); //expect true

	System.out.println(n.isEmpty(0, 3)); //expect true

	m.swapColumns(1,3);

	System.out.println(m);

	m.swapRows(1,3);

	System.out.println(m);

	for(Object o: m.getRow(3)){ //tests getRow
	    System.out.print(o);
	}

	System.out.println();

	Object[] newRow = new Object[4];
	newRow[0] = 1;
	newRow[1] = 2;
	newRow[2] = 3;
	newRow[3] = 4;

	m.setRow(2, newRow);

	System.out.println(m);

	Object[] newCol = new Object[4];
	newCol[0] = 1;
	newCol[1] = 2;
	newCol[2] = 3;
	newCol[3] = 4;

	m.setCol(3, newCol);

	System.out.println(m);


	System.out.println("Before Transposing:\n" + l);

	l.transpose();

	System.out.println(l);


    }

}//end class Matrix
