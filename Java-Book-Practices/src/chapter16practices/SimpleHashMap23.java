package chapter16practices;

//Implement the rest of the Map interface for SimpleHashMap.


import java.util.*;

public class SimpleHashMap23<K,V> implements Map<K,V> {
	static final int SIZE = 997;
	@SuppressWarnings("unchecked")
	LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
	public int size() {
		int result = 0;
		for(LinkedList bucket : buckets)
			if(bucket != null) result += bucket.size();
		return result;
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
	private EntrySet entries = new EntrySet();
	private KeySet keys = new KeySet();
	public Set<Map.Entry<K,V>> entrySet() { return entries; }
	public Set<K> keySet() { return keys; }
	public boolean isEmpty() {
		return this.size() == 0;
	}	
	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] == null)
			buckets[index] = new LinkedList<MapEntry<K,V>>();
		LinkedList<MapEntry<K,V>> bucket = buckets[index];
		MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
		boolean found = false;
		ListIterator<MapEntry<K,V>> it = bucket.listIterator();
		while(it.hasNext()) {
			MapEntry<K,V> iPair = it.next();
			if(iPair.getKey().equals(key)) {
				oldValue = iPair.getValue();
				it.set(pair);
				found = true;
				break;
			}
		}	
		if(!found)
			buckets[index].add(pair);
		return oldValue;
	}
	public void putAll(Map<? extends K, ? extends V> m) {
		for(Map.Entry<? extends K,? extends V> me : m.entrySet())
			this.put(me.getKey(), me.getValue());
	}
	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] == null) return null;
		for(MapEntry<K,V> iPair : buckets[index])
			if(iPair.getKey().equals(key))
				return iPair.getValue();
		return null;
	}
	public void clear() {
		for(LinkedList<MapEntry<K,V>> bucket : buckets)
			if(bucket != null) bucket.clear();		
	}
	public boolean containsKey(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] == null) return false;
		for(MapEntry<K,V> iPair : buckets[index])
			if(iPair.getKey().equals(key))
				return true;
		return false;
	}	
	public boolean containsValue(Object value) {
		for(LinkedList<MapEntry<K,V>> bucket : buckets) {
			if(bucket != null) 
				for(MapEntry<K,V> iPair : bucket)
					if(iPair.getValue().equals(value)) return true;
		}
		return false;
	}
	public Collection<V> values() {
		HashSet<V> vals = new HashSet<V>();
		for(LinkedList<MapEntry<K,V>> bucket : buckets) {
			if(bucket != null) 
				for(MapEntry<K,V> iPair : bucket)
					vals.add(iPair.getValue()); 
		}
		return vals;
	}
	public boolean equals(Object o) {
		if(o instanceof SimpleHashMap23) {
			if(this.entrySet().equals(((SimpleHashMap23)o).entrySet()))
				return true;
		}
		return false;
	}
	public int hashCode() {
		return this.entrySet().hashCode();
	}	
	public V remove(Object o) {
		V v = null;
		if(this.get(o) != null) {
			int index = Math.abs(o.hashCode()) % SIZE;
			for(MapEntry<K,V> iPair : buckets[index])
				if(iPair.getKey().equals(o)) {
					v = iPair.getValue();
					int i =
							buckets[index].indexOf(iPair);
					buckets[index].remove(i);
					break;		
				}
		}
		return v;		
	}
	private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
		public int size() { return SimpleHashMap23.this.size(); }
		public Iterator<Map.Entry<K,V>> iterator() {
			return new Iterator<Map.Entry<K,V>>() {
				private int index = -1;
				public boolean hasNext() {
					return index < SimpleHashMap23.this.size() - 1; 
				}
				@SuppressWarnings("unchecked")
				public Map.Entry<K,V> next() {
					int i = ++index;
					for(int j = 0; j < SIZE; j++) {
						if((start(j) <= index) && (index < end(j)))
							return new MapEntry(
									buckets[j].get(index - start(j)).getKey(),
									buckets[j].get(index - start(j)).getValue());	
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
	}	
	private class KeySet extends AbstractSet<K> {
		public int size() { return SimpleHashMap23.this.size(); }
		public Iterator<K> iterator() {
			return new Iterator<K>() {
				private int index = -1;
				public boolean hasNext() {
					return index < SimpleHashMap23.this.size() - 1; 
				}
				public K next() {
					int i = ++index;
					for(int j = 0; j < SIZE; j++) {
						if((start(j) <= index) && (index < end(j)))
							return buckets[j].get(index - start(j)).getKey();
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
	} 
	public String toString() {
		return this.entrySet().toString();
	}	
	public static void main(String[] args) {
		SimpleHashMap23<String,String> map = new SimpleHashMap23<String,String>();
		map.putAll(Countries.capitals(3));
		System.out.println("map = " + map);
		System.out.println("map.entrySet(): " + map.entrySet());
		System.out.println("map.keySet(): " + map.keySet());
		System.out.println("map.values() = " + map.values());
		System.out.println("map.isEmpty(): " + map.isEmpty());
		System.out.println("map.containsKey(\"ALGERIA\"): " + map.containsKey("ALGERIA"));
		System.out.println("map.containsValue(\"Algiers\"): " + map.containsValue("Algiers"));
		System.out.println("map.get(\"ALGERIA\"): " + map.get("ALGERIA"));
		System.out.println("map.remove(\"ALGERIA\"): " + map.remove("ALGERIA"));
		System.out.println("After map.remove(\"ALGERIA\"), map.containsKey(\"ALGERIA\"): " +
				map.containsKey("ALGERIA"));
		System.out.println(" and map.get(\"ALGERIA\"): " + map.get("ALGERIA"));
		System.out.println(" and map: = " + map);	
		map.clear();
		System.out.println("After map.clear(), map = " + map);
		System.out.println(" and map.isEmpty(): " + map.isEmpty());
		map.putAll(Countries.capitals(3));
		System.out.println("After map.putAll(Countries.capitals(3)), map = " + map);
		SimpleHashMap23<String,String> map2 = new SimpleHashMap23<String,String>();
		map2.putAll(Countries.capitals(4));
		System.out.println("After map2.putAll(Countries.capitals(4)), map2 = " + map2);
		System.out.println(" and map.equals(map2): " + map.equals(map2));
		map2.remove("BOTSWANA");	
		System.out.println("After map2.remove(\"BOTSWANT\"), map.equals(map2): " + map.equals(map2));
		map.entrySet().clear();
		System.out.println("After map.entrySet().clear, map = " + map);
		map.putAll(Countries.capitals(3));
		System.out.println("After map.putAll(Countries.capitals(3)), map = " + map);
		map.keySet().clear();
		System.out.println("After map.keySet().clear(), map = " + map);				
	}
}

/*Output:

map = [BENIN=Porto-Novo, ALGERIA=Algiers, ANGOLA=Luanda]
map.entrySet(): [BENIN=Porto-Novo, ALGERIA=Algiers, ANGOLA=Luanda]
map.keySet(): [BENIN, ALGERIA, ANGOLA]
map.values() = [Algiers, Porto-Novo, Luanda]
map.isEmpty(): false
map.containsKey("ALGERIA"): true
map.containsValue("Algiers"): true
map.get("ALGERIA"): Algiers
map.remove("ALGERIA"): Algiers
After map.remove("ALGERIA"), map.containsKey("ALGERIA"): false
 and map.get("ALGERIA"): null
 and map: = [BENIN=Porto-Novo, ANGOLA=Luanda]
After map.clear(), map = []
 and map.isEmpty(): true
After map.putAll(Countries.capitals(3)), map = [BENIN=Porto-Novo, ALGERIA=Algiers, ANGOLA=Luanda]
After map2.putAll(Countries.capitals(4)), map2 = [BOTSWANA=Gaberone, BENIN=Porto-Novo, ALGERIA=Algiers, ANGOLA=Luanda]
 and map.equals(map2): false
After map2.remove("BOTSWANT"), map.equals(map2): true
After map.entrySet().clear, map = []
After map.putAll(Countries.capitals(3)), map = [BENIN=Porto-Novo, ALGERIA=Algiers, ANGOLA=Luanda]
After map.keySet().clear(), map = []

 */