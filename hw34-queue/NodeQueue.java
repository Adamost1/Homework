//Alvin Ye
//APCS2 pd8
//HW34: The English Do Not Wait in Line
//2018-04-15

public class NodeQueue<T> implements Queue<T>{

	private LLNode<T> first = null;
	private LLNode<T> last = null;
	private int size = 0;

	public void enqueue(T x){
   	 //If list is empty, initialize the first node.
      //Both head and tail need to be set to this node
    	if(isEmpty()){
    	    LLNode<T> temp = new LLNode<T>(x, null);
    	    first = temp;
    	    last = first; 
        }

    	else{
    	    LLNode<T> temp = new LLNode<T>(x, null); //makes tmp point forwards to _head
    	    last.setNext(temp);
    	    last = temp;
  	     }

       size++;
	}


	public T dequeue(){
		T retVal = first.getValue();
		first = first.getNext();
		size--;

		return retVal;
	}


	public boolean isEmpty(){
		return size == 0;
	}

	public T peekFront(){
		return first.getValue();
	}

	public String toString(){
		String retVal = "Front of Queue|| ";

		LLNode<T> tmp = first;

		while(tmp != null){
			retVal += tmp.getValue() + " -> ";
			tmp = tmp.getNext();
		}

		return retVal + "null ||Back of Queue";
	}

	public static void main(String[] args){
		NodeQueue<String> q = new NodeQueue<String>();

		q.enqueue("0");
		q.enqueue("1");
		q.enqueue("2");

		System.out.println("After enqueue-ing 3 elements: ");
		System.out.println(q);

		System.out.println("Front of queue: ");
		System.out.println(q.peekFront());

		q.dequeue();
		q.dequeue();

		System.out.println("After dequeue-ing 2 elements: ");
		System.out.println(q);
		System.out.println("Front of queue: ");
		System.out.println(q.peekFront());




	}
}