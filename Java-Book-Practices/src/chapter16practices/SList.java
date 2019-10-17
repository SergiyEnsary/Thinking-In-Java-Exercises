package chapter16practices;


class SList<E> {
	private Link<E> headLink = new Link<E>(null);
	SListIterator<E> iterator() { return new SListIterator<E>(headLink); }
	public String toString() { 
		if(headLink.next == null) return "SList: []";
		System.out.print("SList: [");
		SListIterator<E> it = this.iterator();
		StringBuilder s = new StringBuilder(); 
		while(it.hasNext()) {
			s.append(it.next() + (it.hasNext() ? ", " : ""));
		}
		return s + "]";
	}		
}