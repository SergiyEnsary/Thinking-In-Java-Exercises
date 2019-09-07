package chapter14practices;

/* Study the JDK documentation for EnumSet. You'll see that there's a 
* clone() method defined. However, you cannot clone() from the reference
* to the Set interface passed in Sets.java. Can you modify Sets.java to
* handle both the general case of a Set interface as shown, and the 
* special case of an EnumSet, using clone() instead of creating a new
* HashSet?
*/
import java.util.*;

public class Ex17 {
	
	public static <T> Set<T> union(Set<T> a, Set<T> b) {
		try {
			if(a instanceof EnumSet) {
				Set<T> result = ((EnumSet)a).clone();
				result.addAll(b);
				return result;
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	
	public static <T>
	Set<T> intersection(Set<T> a, Set<T> b) {
		try {
			if(a instanceof EnumSet) {
				Set<T> result = ((EnumSet)a).clone();
				result.retainAll(b);
				return result;
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}	

	public static <T> Set<T>
	difference(Set<T> superset, Set<T> subset) {
		try {
			if(superset instanceof EnumSet) {
				Set<T> result = ((EnumSet)superset).clone();
				result.removeAll(subset);
				return result;
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		Set<T> result = new HashSet<T>(superset);
		result.removeAll(subset);
		return result;
	}

	public static <T> Set<T> complement(Set<T> a, Set<T> b) {
		return difference(union(a, b), intersection(a, b));
	}
	public static void main(String[] args) {
		 Set<Watercolors> w1 = EnumSet.range(Watercolors.CRIMSON, Watercolors.SAP_GREEN);
		 Set<Watercolors> w2 = EnumSet.range(Watercolors.ULTRAMARINE, Watercolors.YELLOW_OCHRE);
		 System.out.println("w1: " + w1);
		 System.out.println("w2: " + w2);
		 System.out.println("union(w1,w2): " + union(w1,w2));
		 System.out.println("intersection(w1,w2): " + intersection(w1,w2));
		 System.out.println("difference(w1,w2): " + difference(w1,w2));
		 System.out.println("complement(w1,w2): " + complement(w1,w2));
	}
}

/*Output:

w1: [CRIMSON, MAGENTA, ROSE_MADDER, VIOLET, CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE, SAP_GREEN]
w2: [ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE, SAP_GREEN, YELLOW_OCHRE]
union(w1,w2): [CRIMSON, MAGENTA, ROSE_MADDER, VIOLET, CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE, SAP_GREEN, YELLOW_OCHRE]
intersection(w1,w2): [ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE, SAP_GREEN]
difference(w1,w2): [CRIMSON, MAGENTA, ROSE_MADDER, VIOLET, CERULEAN_BLUE_HUE, PHTHALO_BLUE]
complement(w1,w2): [CRIMSON, MAGENTA, ROSE_MADDER, VIOLET, CERULEAN_BLUE_HUE, PHTHALO_BLUE, YELLOW_OCHRE]
 
 */