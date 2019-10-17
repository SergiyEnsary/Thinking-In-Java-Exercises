package chapter16practices;

/* Create both an ArrayList and a LinkedList, and fill each using the
*  Countries.names() generator. Print each list using an ordinary 
* iterator, then insert one list into the other by using a ListIterator, 
* inserting at every other location. Now perform the insertion staring
* at the end of the first list and moving backwards.
*/
import java.util.*;

public class Ex7 {
	public static void main(String[] args) {
		List<String> al = new ArrayList<String>(Countries.names(25));
		List<String> ll = new LinkedList<String>(Countries.names(25));
		System.out.println(al);
		System.out.println(ll);		
		Iterator alit = al.iterator();
		Iterator llit = ll.iterator();
		while(alit.hasNext()) {
			System.out.println(alit.next() + (alit.hasNext() ? ", " : ""));
		}
		System.out.println();
		while(llit.hasNext()) {
			System.out.println(llit.next() + (llit.hasNext() ? ", " : ""));
		}
		System.out.println();
		System.out.println();
		ListIterator allit = al.listIterator();
		ListIterator lllit = ll.listIterator();		
		while(lllit.hasNext()) {			
			allit.add((String)lllit.next());
			allit.next();
		}
		System.out.println(al);
		System.out.println();
		List<String> al2 = new ArrayList<String>(Countries.names(25));
		ListIterator allit2 = al2.listIterator();
		while(lllit.hasPrevious()) lllit.previous();
		while(allit2.hasNext()) allit2.next();
		while(lllit.hasNext()) {
			allit2.add((String)lllit.next());
			allit2.previous();
			allit2.previous();
		}
		System.out.println(al2);
	}
}

/*Output:

[ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D’IVOIR (IVORY COAST), KENYA, LESOTHO]
[ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD, COMOROS, CONGO, DJIBOUTI, EGYPT, EQUATORIAL GUINEA, ERITREA, ETHIOPIA, GABON, THE GAMBIA, GHANA, GUINEA, BISSAU, COTE D’IVOIR (IVORY COAST), KENYA, LESOTHO]
ALGERIA, 
ANGOLA, 
BENIN, 
BOTSWANA, 
BURKINA FASO, 
BURUNDI, 
CAMEROON, 
CAPE VERDE, 
CENTRAL AFRICAN REPUBLIC, 
CHAD, 
COMOROS, 
CONGO, 
DJIBOUTI, 
EGYPT, 
EQUATORIAL GUINEA, 
ERITREA, 
ETHIOPIA, 
GABON, 
THE GAMBIA, 
GHANA, 
GUINEA, 
BISSAU, 
COTE D’IVOIR (IVORY COAST), 
KENYA, 
LESOTHO

ALGERIA, 
ANGOLA, 
BENIN, 
BOTSWANA, 
BURKINA FASO, 
BURUNDI, 
CAMEROON, 
CAPE VERDE, 
CENTRAL AFRICAN REPUBLIC, 
CHAD, 
COMOROS, 
CONGO, 
DJIBOUTI, 
EGYPT, 
EQUATORIAL GUINEA, 
ERITREA, 
ETHIOPIA, 
GABON, 
THE GAMBIA, 
GHANA, 
GUINEA, 
BISSAU, 
COTE D’IVOIR (IVORY COAST), 
KENYA, 
LESOTHO


[ALGERIA, ALGERIA, ANGOLA, ANGOLA, BENIN, BENIN, BOTSWANA, BOTSWANA, BURKINA FASO, BURKINA FASO, BURUNDI, BURUNDI, CAMEROON, CAMEROON, CAPE VERDE, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CENTRAL AFRICAN REPUBLIC, CHAD, CHAD, COMOROS, COMOROS, CONGO, CONGO, DJIBOUTI, DJIBOUTI, EGYPT, EGYPT, EQUATORIAL GUINEA, EQUATORIAL GUINEA, ERITREA, ERITREA, ETHIOPIA, ETHIOPIA, GABON, GABON, THE GAMBIA, THE GAMBIA, GHANA, GHANA, GUINEA, GUINEA, BISSAU, BISSAU, COTE D’IVOIR (IVORY COAST), COTE D’IVOIR (IVORY COAST), KENYA, KENYA, LESOTHO, LESOTHO]

[ALGERIA, LESOTHO, ANGOLA, KENYA, BENIN, COTE D’IVOIR (IVORY COAST), BOTSWANA, BISSAU, BURKINA FASO, GUINEA, BURUNDI, GHANA, CAMEROON, THE GAMBIA, CAPE VERDE, GABON, CENTRAL AFRICAN REPUBLIC, ETHIOPIA, CHAD, ERITREA, COMOROS, EQUATORIAL GUINEA, CONGO, EGYPT, DJIBOUTI, DJIBOUTI, EGYPT, CONGO, EQUATORIAL GUINEA, COMOROS, ERITREA, CHAD, ETHIOPIA, CENTRAL AFRICAN REPUBLIC, GABON, CAPE VERDE, THE GAMBIA, CAMEROON, GHANA, BURUNDI, GUINEA, BURKINA FASO, BISSAU, BOTSWANA, COTE D’IVOIR (IVORY COAST), BENIN, KENYA, ANGOLA, LESOTHO, ALGERIA]

*/