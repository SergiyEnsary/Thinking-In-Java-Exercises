package chapter18practices;

//Modify class PostOffice so that it uses an EnumMap.

import java.util.*;

interface Handler { abstract boolean handle(Mail m); }

public class Ex9 {
	enum MailHandler { GENERAL_DELIVERY, MACHINE_SCAN, VISUAL_INSPECTION, RETURN_TO_SENDER }
	public static void handle(Mail m, EnumMap<MailHandler,Handler> em) {	
		for(Map.Entry<MailHandler,Handler> e : em.entrySet()) {
			if(e.getValue().handle(m)) return; 							
		}
		System.out.println(m + " is a dead letter");		
	}	
	public static void main(String[] args) {
		EnumMap<MailHandler,Handler> em = new EnumMap<MailHandler,Handler>(MailHandler.class);
		em.put(MailHandler.GENERAL_DELIVERY, new Handler() {
			public boolean handle(Mail m) {
				switch(m.generalDelivery) {
				case YES:
					System.out.println("Using general delivery for " + m);
					return true;
				default: return false;
				}
			}
		});
		em.put(MailHandler.MACHINE_SCAN, new Handler() {
			public boolean handle(Mail m) {
				switch(m.scannability) {
				case UNSCANNABLE: return false;
				default:
					switch(m.address) {
					case INCORRECT: return false;
					default:
						System.out.println("Delivering " + m + " automatically");
						return true;
					}
				}
			}	
		});
		em.put(MailHandler.VISUAL_INSPECTION, new Handler() {
			public boolean handle(Mail m) {
				switch(m.readability) {
				case ILLEGIBLE: return false;
				default:
					switch(m.address) {
					case INCORRECT: return false;
					default:
						System.out.println("Delivering " + m + " normally");
						return true;
					}
				}
			}
		});
		em.put(MailHandler.RETURN_TO_SENDER, new Handler() {
			public boolean handle(Mail m) {
				switch(m.returnAddress) {
				case MISSING: return false;
				default:
					System.out.println("Return " + m + " to sender");
					return true;
				}
			}
		});
		for(Mail mail : Mail.generator(10)) {
			System.out.println(mail.details());
			handle(mail, em);
			System.out.println("*****");	
		}
	}
}

/*Output:

Mail 0, General Delivery: NO2, Address Scannability: YES2, Address Readability: YES3, ForwardAddress: NO5, Address Address: OK1, Return address: OK5
Delivering Mail 0 automatically
*****
Mail 1, General Delivery: NO4, Address Scannability: YES2, Address Readability: YES2, ForwardAddress: NO1, Address Address: INCORRECT, Return address: MISSING
Mail 1 is a dead letter
*****
Mail 2, General Delivery: NO3, Address Scannability: YES1, Address Readability: YES4, ForwardAddress: NO4, Address Address: OK4, Return address: OK1
Delivering Mail 2 automatically
*****
Mail 3, General Delivery: NO2, Address Scannability: YES1, Address Readability: YES1, ForwardAddress: YES, Address Address: OK1, Return address: MISSING
Delivering Mail 3 automatically
*****
Mail 4, General Delivery: NO2, Address Scannability: UNSCANNABLE, Address Readability: YES1, ForwardAddress: NO1, Address Address: OK4, Return address: OK2
Delivering Mail 4 normally
*****
Mail 5, General Delivery: YES, Address Scannability: YES1, Address Readability: ILLEGIBLE, ForwardAddress: YES, Address Address: OK4, Return address: MISSING
Using general delivery for Mail 5
*****
Mail 6, General Delivery: NO1, Address Scannability: UNSCANNABLE, Address Readability: YES4, ForwardAddress: YES, Address Address: OK3, Return address: OK5
Delivering Mail 6 normally
*****
Mail 7, General Delivery: YES, Address Scannability: YES1, Address Readability: YES1, ForwardAddress: NO1, Address Address: OK1, Return address: OK2
Using general delivery for Mail 7
*****
Mail 8, General Delivery: NO4, Address Scannability: YES1, Address Readability: YES2, ForwardAddress: NO4, Address Address: OK4, Return address: OK5
Delivering Mail 8 automatically
*****
Mail 9, General Delivery: NO1, Address Scannability: YES2, Address Readability: YES1, ForwardAddress: YES, Address Address: INCORRECT, Return address: OK1
Return Mail 9 to sender
*****

*/