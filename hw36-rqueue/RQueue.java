//Team QueueTips
//Jessica Wu and Alvin Ye
//APCS2 pd8
//HW36 -- Now Let’s Consider You Lot at Fake Terry’s
//2018-04-17

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/


public class RQueue<T> implements Queue<T>
{
    //instance variables
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
    {
	_front = null;
	_end = null;
	_size = 0;
    }//end default constructor


    //O(1) because you are adding a node to the _end of the list
    public void enqueue(T x){
	//If queue is empty, initialize the first node.
	//Both first and last need to be set to this node
    	if(isEmpty()){
    	    LLNode<T> temp = new LLNode<T>(x, null);
    	    _front = temp;
    	    _end = _front; 
        }

    	else{
    	    LLNode<T> temp = new LLNode<T>(x, null); //initializes an LLNode
    	    _end.setNext(temp); //adds the LLNode to the back of the queue
    	    _end = temp; //sets the last to be the new LLNode
	}

	_size++;
    }
    //end enqueue()


    // remove and return thing at front of queue
    //O(n) because you're removing a node from the _front and sample()-ing for a random number of times
    public T dequeue() 
    {   
        if(isEmpty()){
            return null;
        }
        else{
        T retVal = _front.getValue();
        _front = _front.getNext();
        _size--;
        sample();  //shuffles the queue
        return retVal;
        }
    }//end dequeue()


    public T peekFront() 
    {
        return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo: O(n)
     * - move the _end element to the _front n times (where n is a random int from 0 to _size - 1) 
     * - Change the front pointer to that node
     ******************************************/
    public void sample () 
    {
        for(int i = 0; i < (int) (Math.random()*_size); i++){
            enqueue(dequeue()); //shuffles the person from the front of the queue to the back
        }
      
    }//end sample()


    public boolean isEmpty() 
    {
	return _size == 0;
    } //O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
        String retVal = "Front of Queue|| ";

        LLNode<T> tmp = _front;

        while(tmp != null){
            retVal += tmp.getValue() + " -> ";
            tmp = tmp.getNext();
        }

        return retVal + "null ||Back of Queue";
    }//end toString()



    //main method for testing
    public static void main( String[] args )
    {


	  Queue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...

	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );

	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );

      RQueue<String> q = new RQueue<String>();
      System.out.println("\nnow enqueuing..."); 
      q.enqueue("Dread");
      q.enqueue("Pirate");
      q.enqueue("Robert");
      q.enqueue("Blackbeard");
      q.enqueue("Peter");
      q.enqueue("Stuyvesant");
      System.out.println( q );

      System.out.println("\nnow sampling...");
      q.sample();
      System.out.println("_front: " + q.peekFront());
      System.out.println( q );

      System.out.println("\nnow sampling...");
      q.sample();
      System.out.println("_front: " + q.peekFront());
      System.out.println( q );

      System.out.println("\nnow sampling...");
      q.sample();
      System.out.println("_front: " + q.peekFront()); 
      System.out.println( q );

    }//end main

}//end class RQueue
