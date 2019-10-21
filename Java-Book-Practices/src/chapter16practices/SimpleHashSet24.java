package chapter16practices;

//Following the example in SimpleHashMap.java, 
//create and test a SimpleHashSet.


import java.util.*;

public class SimpleHashSet24<E> implements Set<E> {
	static final int SIZE = 997;
	@SuppressWarnings("unchecked")
	LinkedList<E>[] buckets = new LinkedList[SIZE];
	public int size() {
		int result = 0;
		for(LinkedList bucket : buckets)
			if(bucket != null) result += bucket.size();
		return result;
	}
	public boolean add(E e) {
		if(this.contains(e)) return false;
		int index = Math.abs(e.hashCode()) % SIZE;
		if(buckets[index] == null)
			buckets[index] = new LinkedList<E>();
		buckets[index].add(e);
		return true;
	}	
	public boolean addAll(Collection<? extends E> c) {
		int start = this.size();
		for(E e : c) this.add(e);
		return(this.size() > start);		
	}	
	public void clear() {
		for(LinkedList<E> bucket : buckets)
			if(bucket != null) bucket.clear();		
	}
	public boolean contains(Object o) {
		int index = Math.abs(o.hashCode()) % SIZE;
		if(buckets[index] == null) return false;
		for(E e : buckets[index])
			if(e.equals(o)) return true;
		return false;
	}	
	public boolean containsAll(Collection<?> c) {
		int count = 0; 
		for(Object o : c)
			if(this.contains(o)) count++;
		if(count == c.size()) return true;
		return false;		
	}
	public boolean equals(Object o) {
		if(o instanceof SimpleHashSet24) {
			if((this.size() == ((SimpleHashSet24)o).size())) {
				int count = 0;
				Iterator it = ((SimpleHashSet24)o).iterator();
				while(it.hasNext())
					if(this.contains(it.next())) count++;
				if(count == this.size()) return true;
			}					
		}
		return false;		
	}
	public int hashCode() {
		int result = 0;
		for(LinkedList<E> bucket : buckets)
			if(bucket != null)
				for(E e : bucket) 
					if(e != null) result += e.hashCode();	
		return result;
	}	
	public boolean isEmpty() {
		return(this.size() == 0);
	}
	private int firstNonEmptyBucket() {
		if(buckets.length < 1) return -1;
		for(int j = 0; j < buckets.length; j++) 
			if(buckets[j] != null) return j;
		return -1;		
	}
	private int start(int i) {
		int first = this.firstNonEmptyBucket();
		if(i < first) return -1;
		if(i == first) return 0;
		int result = 0;
		for(int j = first; j < i; j++) 
			if(buckets[j] != null) result += buckets[j].size();
		return result;
	}
	private int end(int i) {
		int first = this.firstNonEmptyBucket();
		if(i < first) return -1;
		return start(i) + ((buckets[i] == null) ? 0 : buckets[i].size()); 
	}
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int index = -1;
			public boolean hasNext() {
				return index < SimpleHashSet24.this.size() - 1; 
			}
			public E next() {
				int i = ++index;
				for(int j = 0; j < SIZE; j++) {
					if((start(j) <= index) && (index < end(j)))
						return buckets[j].get(index - start(j));
				}
				return null; 	
			}
			public void remove() {
				for(int j = 0; j < SIZE; j++)
					if(start(j) <= index && index < end(j))
						buckets[j].remove(index - start(j));
				index--;			
			}
		};
	}
	public boolean remove(Object o) {
		int index = Math.abs(o.hashCode()) % SIZE;
		if(buckets[index] == null) return false;
		for(E e : buckets[index]) {
			if(e.equals(o)) {
				buckets[index].remove(e); 
				return true;
			}
		}
		return false;
	}	
	public boolean removeAll(Collection<?> c) {
		int n = this.size();
		for(Object o : c) this.remove(o);
		if(n != this.size()) return true;
		return false;
	}
	public boolean retainAll(Collection<?> c) {
		int n = this.size();
		for(LinkedList<E> bucket : buckets) {
			for(E e : bucket) 
				if(!(c.contains(e))) this.remove(e);
		}
		if(n != this.size()) return true;
		return false;
	}	
	public Object[] toArray() {
		Object[] result = new Object[this.size()];
		Iterator<E> it = this.iterator();
		for(int i = 0; i < this.size(); i++) 
			result[i] = it.next(); 			
		return result;
	}
	@SuppressWarnings("unchecked")	
	public <T> T[] toArray(T[] a) {
		Iterator<E> it = this.iterator();
		for(int i = 0; i < this.size(); i++) {
			E x = it.next();
			try {
				a[i] = (T)x;
			} catch(ClassCastException e) {
				throw new RuntimeException(e);
			}
		}
		return a;
	}
	public String toString() {
		if(this.size() == 0) return "[]";
		StringBuilder s = new StringBuilder();
		s.append("[");
		for(LinkedList<E> bucket : buckets) {
			if(bucket != null)
				for(E e : bucket) 
					s.append(String.valueOf(e) + " ");				
		}		
		s.replace(s.length() - 1, s.length(), "]");
		return s.toString();
	}	
	public static void main(String[] args) {
		SimpleHashSet24<String> shs = new SimpleHashSet24<String>();
		System.out.println("New empty SimpleHashSet24, shs = " + shs);
		shs.add("hi");
		shs.add("there");
		System.out.println("After shs.add(\"hi\") and shs.add(\"there\"), shs = " + shs);			
		List<String> list = Arrays.asList("you", "cutie", "pie");
		shs.addAll(list);
		System.out.println("After shs.addAll(list) (you, cutie, pie), shs = " + shs);
		System.out.println("shs.size() = " + shs.size());
		System.out.println("shs.contains(\"you\"): " + shs.contains("you"));
		System.out.println("shs.contains(\"me\"): " + shs.contains("me"));	
		System.out.println("shs.containsAll(list): " + shs.containsAll(list));
		SimpleHashSet24<String> shs2 = new SimpleHashSet24<String>();
		System.out.println("New empty shs2 = " + shs2);		
		System.out.println("shs.containsAll(list): " + shs.containsAll(list));
		System.out.println("shs2.containAll(list): " + shs2.containsAll(list));
		System.out.println("shs.containsAll(shs2): " + shs.containsAll(shs2));
		System.out.println("shs2.containAll(shs2): " + shs2.containsAll(shs2));
		shs2.add("you");
		shs2.add("cutie");
		System.out.println("After shs2.add(\"you\"), shs2.add(\"cutie\"), shs2 = " + shs2);
		shs.removeAll(shs2);
		System.out.println("After shs.removeAll(shs2), shs = " + shs);
		System.out.println("shs.hashCode() = " + shs.hashCode());
		System.out.println("shs2 = " + shs2);
		System.out.println("shs2.isEmpty(): " + shs2.isEmpty());
		shs2.clear();
		System.out.println("After shs2.clear(), shs2.isEmpty(): " + shs2.isEmpty());
		List<String> list2 = Arrays.asList("hi", "there", "pie");
		shs2.addAll(list2);
		System.out.println("After shs2.addAll(list2) (hi, there, pie), shs2 = " + shs2);
		System.out.println("shs.equals(shs2): " + shs.equals(shs2));
		String[] sa = new String[3];
		shs.toArray(sa);
		System.out.println("After String[] sa = new String[3], shs.toArray(sa), sa holds: "); 
		for(int i = 0; i < sa.length; i++) System.out.println(sa[i] + " " );
	}
}

/*Output:

New empty SimpleHashSet24, shs = []
After shs.add("hi") and shs.add("there"), shs = [hi there]
After shs.addAll(list) (you, cutie, pie), shs = [you pie hi there cutie]
shs.size() = 5
shs.contains("you"): true
shs.contains("me"): false
shs.containsAll(list): true
New empty shs2 = []
shs.containsAll(list): true
shs2.containAll(list): false
shs.containsAll(shs2): true
shs2.containAll(shs2): true
After shs2.add("you"), shs2.add("cutie"), shs2 = [you cutie]
After shs.removeAll(shs2), shs = [pie hi there]
shs.hashCode() = 110441713
shs2 = [you cutie]
shs2.isEmpty(): false
After shs2.clear(), shs2.isEmpty(): true
After shs2.addAll(list2) (hi, there, pie), shs2 = [pie hi there]
shs.equals(shs2): true
After String[] sa = new String[3], shs.toArray(sa), sa holds: 
pie 
hi 
there 

 */