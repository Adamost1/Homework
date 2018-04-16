//Alvin Ye, Alan Wang
//APCS2 pd8
//HW35--Nor Do Aussies
//2018-04-16

import java.util.ArrayList;

public class ALQueue<T> implements Queue<T>{

    private ArrayList<T> queue = new ArrayList<T>();
    
    public T dequeue(){
	if(queue.isEmpty()){
	    return null;
	}
	else{
	    return queue.remove(queue.size() - 1);
	}
    }

    public void enqueue(T x){
	queue.add(0, x); //you need to use add at index because add() just adds to the END
    }

    public boolean isEmpty(){
	return queue.isEmpty();
    }

    public T peekFront(){
        return queue.get(queue.size() - 1);
    }

    public String toString(){
        String retVal = "Back|| [";

        for(int i = 0; i < queue.size(); i++){
            retVal += queue.get(i) + ", ";
        }

        return retVal.substring(0, retVal.length() - 2) + "] ||Front";
    }


    public static void main(String[] args){
        ALQueue<String> q = new ALQueue<String>();

        q.enqueue("0");
        q.enqueue("1");
        q.enqueue("2");

        System.out.println(q);
        System.out.println("Front element of queue: " + q.peekFront());

        
        q.dequeue();

        System.out.println(q);

        System.out.println("Front element of queue: " + q.peekFront());

    }





}
