// Auther: Seif Mohamed 
public class LinkedList {
	Node head;
	Node tail;

	

	public void addFirst(Object data){
		Node n = new Node();
		n.next = head;
		n.data = data;
		head = n;
	}
	public void addLast(Object data){
		Node n = new Node();
			n.data = data;
			if (head == null)
			head = n;
		
		else {
			if (tail != null){
			tail.next = n;
			tail = n;
		}
		if (tail == null){
			tail = n;
			head.next = tail;
		}
		}
	}

	public void show(){
		if (head == null)
			System.out.println("The list is empty");
		else {
		Node n = head;
		while (n.next != null){
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}
	}

	public Object getFirst(){
		if (head == null)
			return null;
		else{
		Object temp = head.data;
		head = head.next;
		return temp;
	}
	}

	public Object getFirstWithoutPop(){
		if (head == null)
			return null;
		else{
		return head.data;
	}
	}

	public boolean isEmpty(){
		if (head == null)
			return true;
		else 
			return false;
	}

	public int getLength(){
		if (head == null)
			return  0;
		else {
		Node n = head;
		int i = 1;
		while (n.next != null){
			i++;
			n = n.next;
		}
		return i;
	}
}
	
}