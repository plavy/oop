package hr.fer.oop;

public class MyList<T> {
	private MyListElement<T> head;
	private int size;
	
	public MyList(){

	}
	
	int add(T item) {
		size++;
		if (head == null) {
			head = new MyListElement<T>(item);
			return 0;
		}
		MyListElement<T> current = head;
		int index = 0;
		while(current.getNext() != null) {
			current = current.getNext();
			index++;
		}
		current.setNext(new MyListElement<T>(item));
		return index + 1;
	}
	
	T elementAt(int index) {
		if (size > 0 && index >= 0 && index < size) {
		MyListElement<T> current = head;
		for(int i = 0;i<index;i++, current = current.getNext());
		return current.getContent();
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	int size() {
		return size;
	}
	
	void print() {
		MyListElement<T> current = head;
		while(current != null) {
			System.out.println(current.getContent());
			current = current.getNext();
		}
	}
}

