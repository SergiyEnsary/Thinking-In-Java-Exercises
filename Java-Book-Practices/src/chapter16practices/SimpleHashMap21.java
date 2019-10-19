package chapter16practices;

/* Modify SimpleHashMap.java to that it reports the number of
 * "probes" necessary when collisions occur. That is, how 
 * many calls to next() must be made on the Iterators that
 * walk the LinkedLists looking for matches?
 */
import java.util.*;

public class SimpleHashMap21<K,V> extends AbstractMap<K,V> {
	static final int SIZE = 99;
	@SuppressWarnings("unchecked")
	LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] == null)
			buckets[index] = new LinkedList<MapEntry<K,V>>();
		LinkedList<MapEntry<K,V>> bucket = buckets[index];
		MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
		boolean found = false;
		ListIterator<MapEntry<K,V>> it = bucket.listIterator();
		int probes = 0;
		while(it.hasNext()) {
			MapEntry<K,V> iPair = it.next();
			probes++;
			if(iPair.getKey().equals(key)) {
				oldValue = iPair.getValue();
				it.set(pair);
				found = true;
				System.out.println("Collision at " + iPair + ": " + probes + " probe" 
						+ ((probes == 1) ? "" : "s") +" needed");
				break;
			}
		}	
		if(!found)
			buckets[index].add(pair);
		return oldValue;
	}
	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] == null) return null;
		for(MapEntry<K,V> iPair : buckets[index])
			if(iPair.getKey().equals(key))
				return iPair.getValue();
		return null;
	}
	public Set<Map.Entry<K,V>> entrySet() {
		Set<Map.Entry<K,V>> set = new HashSet<Map.Entry<K,V>>();
		for(LinkedList<MapEntry<K,V>> bucket : buckets) {
			if(bucket == null) continue;
			for(MapEntry<K,V> mpair : bucket)
				set.add(mpair);
		}
		return set;
	}
	public static void main(String[] args) {
		SimpleHashMap21<String,String> m = new SimpleHashMap21<String,String>();
		m.putAll(Countries.capitals(5));
		System.out.println(m);
		m.put("EGYPT","Berlin?");
		m.put("EGYPT", "New York?");
		m.put("EGYPT", "Cairo");
		System.out.println();
		m.putAll(Countries.capitals(6));
		System.out.println(m);
	}
}

/*

{ANGOLA=Luanda, BURKINA FASO=Ouagadougou, BENIN=Porto-Novo, ALGERIA=Algiers, BOTSWANA=Gaberone}
Collision at EGYPT=Berlin?: 1 probe needed
Collision at EGYPT=New York?: 1 probe needed

Collision at ALGERIA=Algiers: 1 probe needed
Collision at ANGOLA=Luanda: 1 probe needed
Collision at BENIN=Porto-Novo: 1 probe needed
Collision at BOTSWANA=Gaberone: 1 probe needed
Collision at BURKINA FASO=Ouagadougou: 1 probe needed
{ANGOLA=Luanda, EGYPT=Cairo, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, BENIN=Porto-Novo, ALGERIA=Algiers, BOTSWANA=Gaberone}

 */