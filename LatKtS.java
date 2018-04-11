//Alvin Ye
//APCS2 pd8
//HW31 -- Stack: What Is It Good For? 
//2018-04-11 

/*****************************************************
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{

  /**********************************************************
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **********************************************************/
  public static String flip( String s )
  {
    String retStr = "";
    Latkes stack = new Latkes(s.length());

    for(int i = 0; i < s.length(); i++){ //pushes every character of string into an array
      stack.push(s.substring(i, i + 1));
    }

    for(int i = 0; i < s.length(); i++){ //pops out every character of array, which will reverse the array
      retStr += stack.pop();
    }

    return retStr;
  }//end flip()


  /**********************************************************
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **********************************************************/
  public static boolean allMatched( String s )
  {
    String retStr = "";
    Latkes stack = new Latkes(s.length());

    for(int i = 0; i < s.length(); i++){
      String currentChar = s.substring(i, i + 1);

      if(currentChar.equals("(") || currentChar.equals("[") || currentChar.equals("{") ){
        stack.push(currentChar);
      }

      else{ //else if the currentChar is any closing parenthesis

        if(stack.isEmpty()){
          return false; //there is no opening parenthesis for the closing parenthesis
        }

        //all these cases check for matching parentheses
        else if(currentChar.equals(")") && stack.peek().equals("(")){
          stack.pop();
        }
        else if(currentChar.equals("]") && stack.peek().equals("[")){
          stack.pop();
        }
        else if(currentChar.equals("}") && stack.peek().equals("{")){
          stack.pop();
        }       
      }
    }//end for loop

    if(stack.isEmpty()){ //if stack is empty, it means no lonely parenthesis
      return true;
    }
    else{  //otherwise, there is an extra
      return false;
    }

  }//end allMatched()


  //main method to test
  public static void main( String[] args )
  {

    System.out.println(flip("stressed"));

    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
