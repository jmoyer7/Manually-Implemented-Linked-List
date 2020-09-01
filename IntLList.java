/**
 *  A manually implemented linked list that uses a node class to call methods.
 *  @author   Jeremy Moyer CS174
 *  March 28 2020
 */

public class IntLList extends IntList{
   
    Node head;   //first node in the linked list
    Node tail;   //Last node in the linked list
    
    public IntLList(){	
	head = null;
        tail = null;
    }

     public class Node{
	 public int data;    //tracks the value stored in the relevant node
	 public Node next;    //tracks the location of the next node

	 /**
	 * Can be called to create a new node.
	 * @param  d  a user-given integer representing the node's value.
	 * @param  next  the node located one node in front of the desired location of the new node.
	 */  
	 public Node(int d,Node next) {
	    this.data = d;    
	    this.next = null;

	    //if the given node is not null, then the next node is set equal to new one.
	    if(next != null){
		next.next = this;
	    }
	}
    }
    
    /**
    * Adds a user-given value to the end of the array.
    * @param val  a user-given integer to be added to the end of the linked list.
    */
     public void add(int val){

	//if the list is not empty, creates a new node after tail and sets tail to it
        if(tail != null){
	    Node nextNode = new Node(val, tail);
	    tail = nextNode;	    	     		
	}

	//if the list is empty, creates new node at null and sets head and tail to it
	else{	    
	    head = tail = new Node(val, null);	    
	}
	size++;
     }

    /**
    * Returns the value at the given index.
    * @param  index  the index of the value to be returned.
    */
    public int get(int index){
	
	Node temp = head;   //temporary node that starts at head

	//finds the location of the node at index
	for(int i = 0; i < index; i++){
	    temp = temp.next;      				
	}		
	return temp.data;
    }

    /**
    * Sets the index at the variable index to be equal to the variable val.
    * @param  index  the location to be changed.
    * @param  val  the value that index is to be changed to.
    */
    public void set(int index, int val){

	Node temp = head;

	for(int i = 0; i < index; i++){
	    temp = temp.next;       				
	}
        temp.data = val;	
    }

    /**
    * Removes the value element at the user-given index and changes where the affected nodes are pointing.
    *
    * @param  index  the location of the value to be removed.
    */
    public void remove(int index) throws ArrayIndexOutOfBoundsException{

	Node temp = head;

	//sets head to next node if head is being removed
	if(index == 0){
	    head = head.next;
	}
	//sets tail to previous node if tail is being removed
	else if(index == size-1){	   
	    for(int i = 0; i < index-1; i++){
		temp = temp.next;      				
	    }	    
	    tail = temp; 
	}
	//finds the location of the node before index and changes where it is pointing to the node after index
	else{
	    for(int i = 0; i < index-1; i++){
		temp = temp.next;
	    }
	     Node next = temp.next.next;
	     temp.next = next;
	}
	size--;     	
    }

    //Overrides the toString() method and returns the linked list as a string.
    public String toString(){

	int counter = 0;   //tracks the location of the current node
	String toReturn = "[";  //String to be returned after being properly formatted
	String temp = "";   //temporary string that stores information to be added to toReturn

	//iterates through the linked list and adds the data from each node to toReturn in the form of a string.
	for(Node y = head; y != null; y = y.next){

	    if(counter == size-1){		
		temp = String.valueOf(y.data);
		toReturn = toReturn.concat(temp);
		toReturn = toReturn.concat("]");
	    }
	    else{
		temp = String.valueOf(y.data);
		toReturn = toReturn.concat(temp);
	        toReturn = toReturn.concat(", ");
		counter++;
	    }
	}	
	return toReturn;
    }

    //Removes the last value of the list.
    public void removeLast(){
	if(size != 0){
	   remove(size-1);
	}
	size--;	
    }

    //removes all values in list
    public void clear(){
	head = null;	
    }
    
    public static void main(String[] args) {
    }
}




