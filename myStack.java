// Auther: Seif Mohamed
public class myStack {
	private LinkedList theStack;

	public myStack(){
		theStack = new LinkedList();

	}

	public void push (Object x){
		theStack.addFirst(x);
	}

	public Object pop(){
		return theStack.getFirst();
	}

	public boolean isEmpty(){
		if (theStack.isEmpty() == true)
			return true;
		else 
			return false;
	}

	public Object getFirst(){
		return theStack.getFirstWithoutPop();
	}

	public int getLength(){
		return theStack.getLength();
	}
	public void show(){
		theStack.show();
	}
}