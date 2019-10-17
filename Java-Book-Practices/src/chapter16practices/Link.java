package chapter16practices;

class Link<E> {
	E e;
	Link<E> next;
	Link(E e, Link<E> next) { 
		this.e = e;
		this.next = next; 
	}
	Link(E e) {
		this(e, null);
	} 	
	public String toString() {
		if(e == null) return "null";
		return e.toString();
	}
}
