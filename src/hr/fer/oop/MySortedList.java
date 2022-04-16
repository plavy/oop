package hr.fer.oop;

public class MySortedList<T extends Comparable<T>>{
	private MyListElement<T> head;
	private int size;
	
	public MySortedList(){

	}
	
	int add(T item) {
		size++;
		if (head == null) {
			head = new MyListElement<T>(item);
			return 0;
		}
		MyListElement<T> current = head;
		for(int i = 0;i<size-1;i++) {
			if(i == size - 2) {
				if(item.compareTo(current.getContent()) < 0) {
					head = new MyListElement<T>(item, current);
					return i;
				} else {
					current.setNext(new MyListElement<T>(item));
					return i + 1;
				}
			} else {
				if(item.compareTo(current.getNext().getContent()) < 0) {
					current.setNext(new MyListElement<T>(item, current.getNext()));
					return i + 1;
				}
			}
			current = current.getNext();
		}
		return -1;
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
