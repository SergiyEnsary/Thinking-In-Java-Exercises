package chapter16practices;

import java.util.*;

public class SlowMap<K,V> implements Map<K,V> {
	private List<K> keys = new ArrayList<K>();	
	private List<V> values = new ArrayList<V>();
	private EntrySet entries = new EntrySet();
	private Set<K> keySet = new KeySet();	
	public Set<Map.Entry<K,V>> entrySet() { return entries; }
	public Set<K> keySet() { return keySet; }
	public V put(K key, V value) {
		V oldValue = get(key);
		if(!keys.contains(key)) {
			keys.add(key);
			values.add(value);
		} else
			values.set(keys.indexOf(key), value);
		return oldValue;
	}
	public V get(Object key) {
		if(!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}
	private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
		public int size() { return keys.size(); }
		public Iterator<Map.Entry<K,V>> iterator() {
			return new Iterator<Map.Entry<K,V>>() {
				private int index = -1;
				public boolean hasNext() {
					return index < keys.size() - 1; 
				}
				@SuppressWarnings("unchecked")
				public Map.Entry<K,V> next() {
					int i = ++index;
					return new MapEntry(
					keys.get(i), values.get(i));	 
				}
				public void remove() {
					keys.remove(index);
    					values.remove(index--);		
				}				
			};
		}				
	}
	public void clear() {
		keys.clear();
		values.clear();
	}
	public boolean containsKey(Object key) {
		return keys.contains(key);
	}
	public boolean containsValue(Object value) {
		return values.contains(value);
	}
	public boolean equals(Object o) {
		if(o instanceof SlowMap) {
			if(this.entrySet().equals(((SlowMap)o).entrySet()))
				return true;
		}
		return false;
	}
	public int hashCode() {
		return this.entrySet().hashCode();
	}	
	public boolean isEmpty() {
		return this.entrySet().isEmpty();
	}	
	private class KeySet extends AbstractSet<K> {
		public int size() { return keys.size(); }
		public Iterator<K> iterator() {
			return new Iterator<K>() {
				private int index = -1;
				public boolean hasNext() {
					return index < keys.size() - 1; 
				}
				public K next() {
					int i = ++index;
					return keys.get(index);	 
				}
				public void remove() {
					keys.remove(index--);
    				}				
			};
		}
		
	}
	public void putAll(Map<? extends K,? extends V> m) {
		for(Map.Entry<? extends K,? extends V> me : m.entrySet())
			this.put(me.getKey(), me.getValue());
	}
	public V remove(Object key) {
		V v = this.get(key);	
		int i = keys.indexOf(key);
		keys.remove(i);
		values.remove(i);
		return v;
	}
	public int size() { return keys.size(); }
	public Collection<V> values() { 
		return values;
	}
	public String toString() {
		return this.entrySet().toString();
	}	
	public static void main(String[] args) {
		SlowMap<String,String> m = new SlowMap<String,String>();
		m.putAll(Countries.capitals(15));
		System.out.println("m: " + m);
		System.out.println("m.get(\"BURUNDI\"): " + m.get("BURUNDI"));
		System.out.println("m.entrySet(): " + m.entrySet());
		System.out.println("m.keySet(): " + m.keySet());		
		System.out.println("m.values() = " + m.values());
		System.out.println("Two different maps: ");
		SlowMap<String,String> m2 = new SlowMap<String,String>();
		System.out.println("m.equals(m2): " + m.equals(m2));
		m2.putAll(Countries.capitals(15));
		System.out.println("Maps with same entries: ");
		System.out.println("m.equals(m2): " + m.equals(m2));
		m.clear();
		System.out.println("After m.clear(), m.isEmpty(): " + m.isEmpty() + ", m = " + m);
		m2.keySet().clear();
		System.out.println("After m2.keySet().clear(), m2.isEmpty(): " + m2.isEmpty() + ", m2 = " + m2);
	}
}