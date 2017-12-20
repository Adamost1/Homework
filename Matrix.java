//Alvin Ye
//APCS1 pd1
//HW57--How Deep Does the Rabbit Hole Go?
//2017-12-19

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
  private boolean isEmpty() 
  {
    return matrix.length == 0;
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
for(int counter = matrix.length; counter > 0; counter --){
    for(int column = 0; column < matrix.length; column ++){
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
    return matrix.length == ((Matrix) rightSide).size();
  }


  //swap two columns of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapColumns( int c1, int c2  ) 
  {
    Object tempVal;

    for(int row = 0; row < matrix.length; row ++){
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
    
    for(int column = 0; column < matrix.length; column++){
      tempVal = matrix[column][r1 - 1];

      matrix[column][r1 - 1] = matrix[column][r2 - 1];

      matrix[column][r2 - 1] = tempVal;
    }

  }


  //main method for testing
  public static void main( String[] args ) 
  {
    Matrix m = new Matrix(4);

    Matrix n = new Matrix(4);

    int num = 0; //populates matrix with ordered numbers
    for(int column = 0; column < m.matrix.length; column ++){
      for(int row = 0; row < m.matrix[column].length; row ++){
        m.matrix[row][column] = num;
        num ++;
      }
    }

    System.out.println( m.size()); //expect 2

    System.out.println(m); 

    System.out.println(m.equals(n)); //expect true

    m.swapColumns(1,3);

    System.out.println(m);

    m.swapRows(1,3);

    System.out.println(m);

  }

}//end class Matrix
