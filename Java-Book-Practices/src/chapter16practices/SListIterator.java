package chapter16practices;

class SListIterator<E> {
	Link<E> current;
	SListIterator(Link<E> link) {
		current = link;
	}
	public boolean hasNext() {
		return current.next != null;
	}
	public Link<E> next() {
		current = current.next;
		return current;
	}
	public void insert(E e) {
		current.next = new Link<E>(e, current.next);
		current = current.next;
	}	
	public void remove() {
		if(current.next != null) {
			current.next = current.next.next;
		}
	}
}