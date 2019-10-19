package chapter16practices;

//Modify SimpleHashMap so that it reports collisions, and test
//this by adding the same data twice so that you see collisions.

import java.util.*;

public class SimpleHashMap20<K,V> extends AbstractMap<K,V> {
	static final int SIZE = 997;
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
		while(it.hasNext()) {
			MapEntry<K,V> iPair = it.next();
			if(iPair.getKey().equals(key)) {
				System.out.println("Collision: new " + pair + " for old " + iPair);
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
		SimpleHashMap20<String,String> m = new SimpleHashMap20<String,String>();
		m.putAll(Countries.capitals(10));
		System.out.println(m);
		m.put("EGYPT","Berlin?");
		m.put("EGYPT","Cairo");
		System.out.println(m);
		m.putAll(Countries.capitals(10));
	}
}
/*Output:

{CAPE VERDE=Praia, ANGOLA=Luanda, CHAD=N’djamena, CENTRAL AFRICAN REPUBLIC=Bangui, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, BENIN=Porto-Novo, ALGERIA=Algiers, CAMEROON=Yaounde, BOTSWANA=Gaberone}
Collision: new EGYPT=Cairo for old EGYPT=Berlin?
{CAPE VERDE=Praia, ANGOLA=Luanda, CHAD=N’djamena, CENTRAL AFRICAN REPUBLIC=Bangui, EGYPT=Cairo, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, BENIN=Porto-Novo, ALGERIA=Algiers, CAMEROON=Yaounde, BOTSWANA=Gaberone}
Collision: new ALGERIA=Algiers for old ALGERIA=Algiers
Collision: new ANGOLA=Luanda for old ANGOLA=Luanda
Collision: new BENIN=Porto-Novo for old BENIN=Porto-Novo
Collision: new BOTSWANA=Gaberone for old BOTSWANA=Gaberone
Collision: new BURKINA FASO=Ouagadougou for old BURKINA FASO=Ouagadougou
Collision: new BURUNDI=Bujumbura for old BURUNDI=Bujumbura
Collision: new CAMEROON=Yaounde for old CAMEROON=Yaounde
Collision: new CAPE VERDE=Praia for old CAPE VERDE=Praia
Collision: new CENTRAL AFRICAN REPUBLIC=Bangui for old CENTRAL AFRICAN REPUBLIC=Bangui
Collision: new CHAD=N’djamena for old CHAD=N’djamena

*/