package chapter16practices;

/* Add a private rehash() method to SimpleHashMap that is invoked
 * when the load factor exceeds 0.75. During rehashing, double the
 * number of buckets, then search for the first prime number greater 
 * than that to determine the new number of buckets.
 */

import java.util.*;

import chapter15practices.RandomGenerator;

class Prime {
	public static int firstPrimeAfter(int n) {
		for(int i = n + 1; i > n; i++) {
			int factors = 0;
			for(int j = 1; j < (i + 2)/2; j++) {
				if((i % j) == 0) factors++;
			}
			if(factors < 2) return i;
		}
		return 0;
	}
}

public class Ex39<K,V> extends AbstractMap<K,V> {
	static final int SIZE = 997;
	private int capacity = SIZE;
	@SuppressWarnings("unchecked")	
	LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
	public int capacity() { return capacity; }
	@SuppressWarnings("unchecked")
	private void rehash() {
		capacity = Prime.firstPrimeAfter(capacity * 2);
		LinkedList<MapEntry<K,V>>[] oldBuckets = buckets;		
		buckets = new LinkedList[capacity];
		for(LinkedList<MapEntry<K,V>> bucket : oldBuckets) {
			if(bucket == null) continue;
			for(MapEntry<K,V> mpair : bucket)
				this.put(mpair.getKey(), mpair.getValue());
		}			
	}
	public V put(K key, V value) {
		if(this.size() > 0.75 * capacity) rehash();
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
		RandomGenerator.Integer rgi = new RandomGenerator.Integer(10000);
		System.out.println("Testing map m of <String,String>: the basics:");
		Ex39<String,String> m = new Ex39<String,String>();
		m.putAll(Countries.capitals(10));
		System.out.println("m: " + m);
		System.out.println("m.get(\"CHAD\") " + m.get("CHAD"));
		System.out.println("m.size() = " + m.size());
		System.out.println("m.capacity() = " + m.capacity());
		System.out.println("Testing rehash() for a map m2 of <Integer,Integer>:");
		Ex39<Integer,Integer> m2 = new Ex39<Integer,Integer>();
		System.out.println("m2: " + m2);
		System.out.println("m2.size() = " + m2.size());
		System.out.println("m2.capacity() = " + m2.capacity());
		m2.putAll(MapData.map(rgi, rgi, 996));
		System.out.println("after m2.putAll(MapData.map(rgi, rgi, 996): ");
		System.out.println("m2.size() = " + m2.size());
		System.out.println("m2.capacity() = " + m2.capacity());
		m2.putAll(MapData.map(rgi, rgi, 2000));
		System.out.println("after m2.putAll(MapData.map(rgi, rgi, 2000): ");
		System.out.println("m2.size() = " + m2.size());
		System.out.println("m2.capacity() = " + m2.capacity());
		m2.putAll(MapData.map(rgi, rgi, 1500));
		System.out.println("after m2.putAll(MapData.map(rgi, rgi, 1500): ");
		System.out.println("m2.size() = " + m2.size());
		System.out.println("m2.capacity() = " + m2.capacity());
	}
}

/*Output:

Testing map m of <String,String>: the basics:
m: {CAPE VERDE=Praia, ANGOLA=Luanda, CHAD=N’djamena, CENTRAL AFRICAN REPUBLIC=Bangui, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, BENIN=Porto-Novo, ALGERIA=Algiers, CAMEROON=Yaounde, BOTSWANA=Gaberone}
m.get("CHAD") N’djamena
m.size() = 10
m.capacity() = 997
Testing rehash() for a map m2 of <Integer,Integer>:
m2: {}
m2.size() = 0
m2.capacity() = 997
after m2.putAll(MapData.map(rgi, rgi, 996): 
m2.size() = 952
m2.capacity() = 1997
after m2.putAll(MapData.map(rgi, rgi, 2000): 
m2.size() = 2611
m2.capacity() = 4001
after m2.putAll(MapData.map(rgi, rgi, 1500): 
m2.size() = 3639
m2.capacity() = 8009

 */