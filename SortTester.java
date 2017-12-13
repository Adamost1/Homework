import java.util.ArrayList;

public class SortTester{

    public static void main(String[] args){
	
	ArrayList<Comparable> foo = new ArrayList<Comparable>();

	foo.add(10);
	foo.add(20);
	foo.add(60);
	foo.add(80);
	foo.add(100);

	System.out.println(foo);
        MySorts.insertionSortV(foo);

	System.out.println(foo);
	

   
	

	
    }

}
