package chapter16practices;

//Produce a Map and a Set containing all the countries that begin
//with 'A'.
import java.util.*;
import java.util.regex.*;

public class Ex2 {
	public static void main(String[] args) {
		Map<String,String> hm = new HashMap<String,String>();
		Set<String> hs = hm.keySet();
		Pattern p = Pattern.compile("A[a-zA-Z]*");
		for(int i = 0; i < Countries.DATA.length; i++) {
			if(p.matcher(Countries.DATA[i][0]).matches())
				hm.put(Countries.DATA[i][0], Countries.DATA[i][1]);
		}
		System.out.println(hm);	
		System.out.println(hs);	
	}
}

/*Output:

{AUSTRALIA=Canberra, AFGHANISTAN=Kabul, AZERBAIJAN=Baku, ALBANIA=Tirana, ANDORRA=Andorra la Vella, ARGENTINA=Buenos Aires, ANGOLA=Luanda, ARMENIA=Yerevan, ALGERIA=Algiers, AUSTRIA=Vienna}
[AUSTRALIA, AFGHANISTAN, AZERBAIJAN, ALBANIA, ANDORRA, ARGENTINA, ANGOLA, ARMENIA, ALGERIA, AUSTRIA]

 */