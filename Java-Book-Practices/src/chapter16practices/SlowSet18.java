package chapter16practices;

//Using SlowMap.java for inspiration, create a SlowSet.
import java.util.*;

public class SlowSet18<E> implements Set<E> {
	private List<E> elements = new ArrayList<E>();	
	public boolean add(E e) {
		if(elements.contains(e)) return false;
		elements.add(e);
		return true;
	}
	public boolean addAll(Collection<? extends E> c) {
		return(elements.addAll(c));
	}	
	public void clear() {
		elements.clear();
	}
	public boolean contains(Object o) {
		return elements.contains(o);
	}
	public boolean containsAll(Collection<?> c) {
		int count = 0; 
		for(Object o : c)
			if(elements.contains(o)) count++;
		if(count == c.size()) return true;
		return false;		
	}
	public boolean equals(Object o) {
		if(o instanceof SlowSet18) {
			if((elements.size() == ((SlowSet18)o).size())) {
				int count = 0;
				for(int i = 0; i < elements.size(); i++)
					if(elements.get(i).equals(((SlowSet18)o).elements.get(i)))
						count++;
				if(count == elements.size()) return true;
			}					
		}
		return false;		
	}
	public int hashCode() {
		int result = 0;
		for(int i = 0; i < elements.size(); i++)
			result += elements.get(i).hashCode();
		return result;
	}	
	public boolean isEmpty() {
		return(elements.size() == 0);
	}
	public Iterator<E> iterator() {
		return elements.iterator();
	}
	public boolean remove(Object o) {
		return(elements.remove(o));
	}
	public boolean removeAll(Collection<?> c) {
		int n = elements.size();
		for(Object o : c) elements.remove(o);
		if(n != elements.size()) return true;
		return false;
	}
	public boolean retainAll(Collection<?> c) {
		int n = elements.size();
		for(int i = 0; i < elements.size(); i++) { 
			E e = elements.get(i);
			if(!(c.contains(e))) elements.remove(e);
		}
		if(n != elements.size()) return true;
		return false;
	}
	public int size() { return elements.size(); }
	public Object[] toArray() {
		return elements.toArray();
	}
	public <T> T[] toArray(T[] a) {
		return elements.toArray(a);
	}

	public String toString() {
		if(elements.size() == 0) return "[]";
		StringBuilder s = new StringBuilder();
		s.append("[");
		for(int i = 0; i < elements.size() - 1; i++)
			s.append(String.valueOf(elements.get(i)) + ", ");
		s.append(String.valueOf(elements.get(elements.size() -1)));
		s.append("]");
		return s.toString();
	}

	public static void main(String[] args) {
		SlowSet18<String> ss = new SlowSet18<String>();
		ss.add("hi");
		System.out.println(ss);
		ss.add("there");
		System.out.println(ss);		
		List<String> list = Arrays.asList("you", "cutie", "pie");
		ss.addAll(list);
		System.out.println(ss);
		System.out.println("ss.size() = " + ss.size());
		System.out.println("ss.contains(\"you\"): " + ss.contains("you"));
		System.out.println("ss.contains(\"me\"): " + ss.contains("me"));	
		System.out.println("ss.containsAll(list): " + ss.containsAll(list));
		SlowSet18<String> ss2 = new SlowSet18<String>();
		System.out.println("ss2 = " + ss2);
		System.out.println("ss.containsAll(ss2): " + ss.containsAll(ss2));
		System.out.println("ss2.containAll(ss): " + ss2.containsAll(ss));
		ss2.add("you");
		ss2.add("cutie");
		ss.removeAll(ss2);
		System.out.println("ss = " + ss);
		System.out.println("ss.hashCode() = " + ss.hashCode());
		List<String> list2 = Arrays.asList("hi", "there", "pie");
		ss2.remove("you");
		System.out.println(ss2);
		System.out.println("ss2.isEmpty(): " + ss2.isEmpty());
		ss2.clear();
		System.out.println("ss2.isEmpty(): " + ss2.isEmpty());
		ss2.addAll(list2);
		System.out.println("ss2 = " + ss2);
		System.out.println("ss.equals(ss2): " + ss.equals(ss2));
		String[] sa = new String[3];
		System.out.println("ss.toArray(sa): " + ss.toArray(sa));
		for(int i = 0; i < sa.length; i++) System.out.println(sa[i] + " " );				
	}
}

/*Output:

[hi]
[hi, there]
[hi, there, you, cutie, pie]
ss.size() = 5
ss.contains("you"): true
ss.contains("me"): false
ss.containsAll(list): true
ss2 = []
ss.containsAll(ss2): true
ss2.containAll(ss): false
ss = [hi, there, pie]
ss.hashCode() = 110441713
[cutie]
ss2.isEmpty(): false
ss2.isEmpty(): true
ss2 = [hi, there, pie]
ss.equals(ss2): true
ss.toArray(sa): [Ljava.lang.String;@3cd1a2f1
hi 
there 
pie 

 */