// Auther: Seif Mohamed 
public class myQueue {
	private LinkedList theQueue;

	public myQueue(){
		theQueue = new LinkedList();

	}

	public void enqueue (Object x){
		theQueue.addLast(x);
	}

	public Object dequeue(){
		return theQueue.getFirst();
	}

	public boolean isEmpty(){
		if (theQueue.isEmpty() == true)
			return true;
		else 
			return false;
	}
	public void show(){
		theQueue.show();
	}

	public Object getFirst(){
		return theQueue.getFirstWithoutPop();
	}
}