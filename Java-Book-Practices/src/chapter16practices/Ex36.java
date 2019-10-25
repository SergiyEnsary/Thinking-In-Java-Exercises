package chapter16practices;

/* Modify SlowMap so that instead of two ArrayLists, it holds a single
 * ArrayList of MapEntry objects. Verify that the modified version works 
 * correctly. Using MapPerformance.java, test the speed of your new Map.
 * Now change the put() method so that if performs a sort() after each 
 * pair is entered, and modify get() to use Collections.binarySearch() 
 * to look up the key. Compare the performance of the new version with 
 * the old ones.
 */
import java.util.*;

class SlowMap36a<K,V> extends AbstractMap<K,V> { 
	protected List<MapEntry<K,V>> entryList = new ArrayList<MapEntry<K,V>>();
	private EntrySet entries = new EntrySet();
	public Set<Map.Entry<K,V>> entrySet() { return entries; }
	private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
		public int size() { return entryList.size(); }
		public Iterator<Map.Entry<K,V>> iterator() {
			return new Iterator<Map.Entry<K,V>>() {
				private int index = -1;
				public boolean hasNext() {
					return index < entryList.size() - 1; 
				}
				@SuppressWarnings("unchecked")
				public Map.Entry<K,V> next() {
					int i = ++index;
					return entryList.get(i);	 
				}
				public void remove() {
					entryList.remove(index--);		
				}				
			};
		}				
	}	
	public V put(K key, V value) {
		V oldValue = get(key);
		Iterator<MapEntry<K,V>> it = entryList.iterator();
		while(it.hasNext()) {
			MapEntry<K,V> me = it.next();
			if(me.getKey().equals(key))
				me.setValue(value);
		}
		entryList.add(new MapEntry<K,V>(key, value));		
		return oldValue;
	}
	public V get(Object key) {
		Iterator<MapEntry<K,V>> it = entryList.iterator();
		while(it.hasNext()) {
			MapEntry<K,V> me = it.next();
			if(me.getKey().equals(key))
				return me.getValue(); 
		}
		return null;
	}	
}
class SlowMap36b<K,V> extends SlowMap36a<K,V> { 
	private List<MapEntry<Integer,V>> hashEntryList = new ArrayList<MapEntry<Integer,V>>();	
	public List<MapEntry<Integer,V>> hashEntryList() { return hashEntryList; }
	private final MapEntryKeyComp<K,V> comp1 = new MapEntryKeyComp<K,V>();
	private final MapEntryKeyComp<Integer,V> comp2 = new MapEntryKeyComp<Integer,V>();
	@Override
	public V put(K key, V value) {
		V oldValue = get(key);
		Iterator<MapEntry<K,V>> it = entryList.iterator();
		while(it.hasNext()) {
			MapEntry<K,V> me = it.next();
			if(me.getKey().equals(key)) {
				me.setValue(value);
			}
		}
		entryList.add(new MapEntry<K,V>(key, value));
		hashEntryList.add(new MapEntry<Integer,V>(key.hashCode(), value));
		Collections.sort(entryList, comp1);
		Collections.sort(hashEntryList, comp2);
		return oldValue;
	}
	@Override
	public V get(Object key) {
		MapEntry<Integer,V> sub = new MapEntry<Integer,V>(key.hashCode(), null); 
		int i = Collections.binarySearch(hashEntryList, sub, comp2);
		if(i >= 0) return hashEntryList.get(i).getValue();
		return null;		
	}	
}
class MapEntryKeyComp<K,V> implements Comparator<MapEntry<K,V>> {
	public int compare(MapEntry<K,V> me1, MapEntry<K,V> me2) {
		return me1.getKey().hashCode() - me2.getKey().hashCode();
	}
} 
public class Ex36 {
	static List<Test<Map<Integer,Integer>>> tests = 
			new ArrayList<Test<Map<Integer,Integer>>>();
	static {
		tests.add(new Test<Map<Integer,Integer>>("put") {
			int test(Map<Integer,Integer> map, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++) {
					map.clear();
					for(int j = 0; j < size; j++) 
						map.put(j, j);
				}
				return loops * size;
			}
		});
		tests.add(new Test<Map<Integer,Integer>>("get") {
			int test(Map<Integer,Integer> map, TestParam tp) {
				int loops = tp.loops;
				int span = tp.size * 2;
				for(int i = 0; i < loops; i++)
					for(int j = 0; j < span; j++)
						map.get(j);
				return loops * span;
			}
		});
		tests.add(new Test<Map<Integer,Integer>>("iterate") {
			int test(Map<Integer,Integer> map, TestParam tp) {
				int loops = tp.loops * 10;
				for(int i = 0; i < loops; i++) {
					Iterator it = map.entrySet().iterator();
					while(it.hasNext()) it.next();
				}
				return loops * map.size();
			}
		});
	}
	public static void main(String[] args) {
		if(args.length > 0)
			Tester.defaultParams = TestParam.array(args);
		else
			Tester.defaultParams = TestParam.array(10, 100, 50, 50, 100, 20);
		System.out.println("Tesing SlowMap36a:");
		SlowMap36a<String,String> m = new SlowMap36a<String,String>();
		m.putAll(Countries.capitals(15));
		System.out.println("m: " + m);
		System.out.println("m.get(\"BURUNDI\"): " + m.get("BURUNDI"));
		System.out.println("m.entrySet(): " + m.entrySet());
		System.out.println("m.keySet(): " + m.keySet());		
		System.out.println("m.values() = " + m.values());
		System.out.println("Two different maps: ");
		SlowMap36a<String,String> m2 = new SlowMap36a<String,String>();
		System.out.println("m.equals(m2): " + m.equals(m2)); 
		m2.putAll(Countries.capitals(15));
		System.out.println("Maps with same entries: ");
		System.out.println("m.equals(m2): " + m.equals(m2));
		m.clear();
		System.out.println("After m.clear(), m.isEmpty(): " + m.isEmpty() + ", m = " + m);	
		m2.keySet().clear();
		System.out.println("After m2.keySet().clear(), m2.isEmpty(): " + m2.isEmpty() + ", m2 = " + m2);
		System.out.println();
		System.out.println("Testing SlowMap36b:");
		SlowMap36b<String,String> m3 = new SlowMap36b<String,String>();
		m3.putAll(Countries.capitals(15));
		System.out.println("m3: " + m3);
		System.out.println("m3.get(\"BURUNDI\"): " + m3.get("BURUNDI"));
		System.out.println("m3.entrySet(): " + m3.entrySet());
		System.out.println("m3.hashEntryList(): " + m3.hashEntryList());
		m3.clear();
		System.out.println("After m3.clear(), m3.isEmpty(): " + m3.isEmpty() + ", m3 = " + m3);	
		m3.keySet().clear();
		System.out.println("After m3.keySet().clear(), m3.isEmpty(): " + m3.isEmpty() + ", m3 = " + m3);
		System.out.println();
		System.out.println("Comparative time tests:");		
		Tester.run(new SlowMap<Integer,Integer>(), tests);
		Tester.run(new SlowMap<Integer,Integer>(), tests);
		Tester.run(new SlowMap36a<Integer,Integer>(), tests);
		Tester.run(new SlowMap36b<Integer,Integer>(), tests);
		Tester.run(new HashMap<Integer,Integer>(), tests);
		Tester.run(new TreeMap<Integer,Integer>(), tests);		
		Tester.run(new LinkedHashMap<Integer,Integer>(), tests);
		Tester.run(new IdentityHashMap<Integer,Integer>(), tests);
		Tester.run(new WeakHashMap<Integer,Integer>(), tests);
		Tester.run(new Hashtable<Integer,Integer>(), tests);			
	}
}	

/*Output:

Tesing SlowMap36a:
m: {ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo, BOTSWANA=Gaberone, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N’djamena, COMOROS=Moroni, CONGO=Brazzaville, DJIBOUTI=Dijibouti, EGYPT=Cairo, EQUATORIAL GUINEA=Malabo}
m.get("BURUNDI"): Bujumbura
m.entrySet(): [ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo, BOTSWANA=Gaberone, BURKINA FASO=Ouagadougou, BURUNDI=Bujumbura, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N’djamena, COMOROS=Moroni, CONGO=Brazzaville, DJIBOUTI=Dijibouti, EGYPT=Cairo, EQUATORIAL GUINEA=Malabo]
m.keySet(): [ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA]
m.values() = [Algiers, Luanda, Porto-Novo, Gaberone, Ouagadougou, Bujumbura, Yaounde, Praia, Bangui, N’djamena, Moroni, Brazzaville, Dijibouti, Cairo, Malabo]
Two different maps: 
m.equals(m2): false
Maps with same entries: 
m.equals(m2): true
After m.clear(), m.isEmpty(): true, m = {}
After m2.keySet().clear(), m2.isEmpty(): true, m2 = {}

Testing SlowMap36b:
m3: {ALGERIA=Algiers, BENIN=Porto-Novo, EGYPT=Cairo, BURUNDI=Bujumbura, BURKINA FASO=Ouagadougou, ANGOLA=Luanda, BOTSWANA=Gaberone, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N’djamena, CONGO=Brazzaville, DJIBOUTI=Dijibouti, COMOROS=Moroni, EQUATORIAL GUINEA=Malabo}
m3.get("BURUNDI"): null
m3.entrySet(): [ALGERIA=Algiers, BENIN=Porto-Novo, EGYPT=Cairo, BURUNDI=Bujumbura, BURKINA FASO=Ouagadougou, ANGOLA=Luanda, BOTSWANA=Gaberone, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN REPUBLIC=Bangui, CHAD=N’djamena, CONGO=Brazzaville, DJIBOUTI=Dijibouti, COMOROS=Moroni, EQUATORIAL GUINEA=Malabo]
m3.hashEntryList(): [-198280703=Algiers, 63085264=Porto-Novo, 65926203=Cairo, 957516733=Bujumbura, 1232689159=Ouagadougou, 1935122954=Luanda, -1356130423=Gaberone, 633061458=Yaounde, -2005115977=Praia, -3715245=Bangui, 2067272=N’djamena, 64306634=Brazzaville, 1656099706=Dijibouti, 1668453352=Moroni, -535406310=Malabo]
After m3.clear(), m3.isEmpty(): true, m3 = {}
After m3.keySet().clear(), m3.isEmpty(): true, m3 = {}

Comparative time tests:
---------- SlowMap ----------
 size     put     get iterate
   10    1528     583     242
   50     285     145      83
  100     313     193      59
---------- SlowMap ----------
 size     put     get iterate
   10     201      94      75
   50     220     121      37
  100     204     161      23
--------- SlowMap36a ---------
 size     put     get iterate
   10    1838     294      56
   50    1783    1013      39
  100    2148     189      49
--------- SlowMap36b ---------
 size     put     get iterate
   10   16262     263      30
   50   13976      81      34
  100   22155      77       8
---------- HashMap ----------
 size     put     get iterate
   10     173      49     148
   50     102      37      34
  100      89      37      25
---------- TreeMap ----------
 size     put     get iterate
   10    1839     907     218
   50     308      95      43
  100     259     117      25
------- LinkedHashMap -------
 size     put     get iterate
   10     441      91     193
   50     154      39      19
  100     184      37      19
------ IdentityHashMap ------
 size     put     get iterate
   10     575     245     224
   50     148      24      36
  100      79      42      34
-------- WeakHashMap --------
 size     put     get iterate
   10     687     389     269
   50     117      27      52
  100     187      58      55
--------- Hashtable ---------
 size     put     get iterate
   10     448     139     417
   50     147      25      24
  100     103      24      19

 */