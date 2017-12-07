//Alvin Ye
//APCS1 pd1
//HW48--Keep Guessing
//2017-12-6

/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;



    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
	_lo = a;
	_hi = b;
	_guessCtr = 0;
	_target = (int) (Math.random()* (b + 1) ) + a;
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() 
    {
	if(_guessCtr == 0){ //to start off the game, it prints an intro statement
	    _guessCtr ++;
	    System.out.print("Guess a number from " + _lo + " to " + _hi + ":  " );   
	    playRec();    
	}

	int guess = Keyboard.readInt(); //this needs to be instantiated here, so that playRec() runs with the print statement first

	if(guess > _target){ //if the guess is greater than _target, it will shift the upperBound down to 1 less than the guess
	    _hi = guess - 1;
	    _guessCtr ++;
	    System.out.println( "Too high. Try again...\nGuess a Number from " + _lo + " to " + _hi + ":  ");
	    playRec();
	}

	else if( guess < _target){ //if the guess is less than _target, it will shift the lowerBound up to 1 more than the guess
	    _lo = guess + 1;
	    _guessCtr ++;
	    System.out.println( "Too low. Try again...\nGuess a Number from " + _lo + " to " + _hi + ":  "); 
	    playRec();     
	}

	else{ //when the guess is equal to the _target, it will print a closing statement
	    System.out.println( "Correct. It took " + _guessCtr + " guesses");
	}
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
	int guess;

	System.out.print("Guess a number from " + _lo + " to " + _hi + ":  " ); //to start off the game, it prints an intro statement
	guess = Keyboard.readInt();

	while(_target != guess){ //keeps iterating until the user types the right input

	    if(guess > _target){ //if the guess is greater than _target, it will shift the upperBound down to 1 less than the guess
		_hi = guess - 1;
		_guessCtr ++;
		System.out.println( "Too high. Try again...\nGuess a Number from " + _lo + " to " + _hi + ":  ");
		guess = Keyboard.readInt();
	    }
      
	    if(guess < _target){ //if the guess is less than _target, it will shift the lowerBound up to 1 more than the guess
		_lo = guess + 1;
		_guessCtr ++;
		System.out.println( "Too low. Try again...\nGuess a Number from " + _lo + " to " + _hi + ":  ");
		guess = Keyboard.readInt();
	    }

	}

	System.out.println( "Correct. It took " + _guessCtr + " guesses"); //when the guess is equal to the _target, it will print a closing statement

    }



    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 
	//use one or the other below:
	//playRec();
	playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {

	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();


    }//end main

}//end class
