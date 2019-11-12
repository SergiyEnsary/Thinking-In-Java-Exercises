package chapter18practices;

//Modify PostOffice.java so it has the ability to forward mail.

import java.util.*;

class Mail {
	// The NO's lower the probability of random selection:
	enum GeneralDelivery { YES, NO1, NO2, NO3, NO4, NO5 }
	enum Scannability { UNSCANNABLE, YES1, YES2, }
	enum Readability { ILLEGIBLE, YES1, YES2, YES3, YES4 }
	enum ForwardAddress { YES, NO1, NO2, NO3, NO4, NO5 }
	enum Address { INCORRECT, OK1, OK2, OK3, OK4, OK5 }
	enum ReturnAddress { MISSING, OK1, OK2, OK3, OK4, OK5 }
	GeneralDelivery generalDelivery;
	Scannability scannability;
	Readability readability;
	ForwardAddress forwardAddress;
	Address address;
	ReturnAddress returnAddress;
	static long counter = 0;
	long id = counter++;
	public String toString() { return "Mail " + id; }
	public String details() {
		return toString() +
				", General Delivery: " + generalDelivery +
				", Address Scannability: " + scannability + 
				", Address Readability: " + readability + 
				", ForwardAddress: " + forwardAddress + 
				", Address Address: " + address +
				", Return address: " + returnAddress;
	} 
	// Generate test Mail:
	public static Mail randomMail() {
		Mail m = new Mail();
		m.generalDelivery = Enums.random(GeneralDelivery.class);
		m.scannability = Enums.random(Scannability.class);
		m.readability = Enums.random(Readability.class);
		m.forwardAddress = Enums.random(ForwardAddress.class);
		m.address = Enums.random(Address.class);
		m.returnAddress = Enums.random(ReturnAddress.class);	
		return m;
	}
	public static Iterable<Mail> generator(final int count) {
		return new Iterable<Mail>() {
			int n = count;
			public Iterator<Mail> iterator() {
				return new Iterator<Mail>() {
					public boolean hasNext() { return n-- > 0; }
					public Mail next() { return randomMail(); }
					public void remove() { // not implemented
						throw new UnsupportedOperationException();
					}	
				};
			}
		};
	}
}

public class Ex8 {
	enum MailHandler {
		GENERAL_DELIVERY {
			boolean handle(Mail m) {
				switch(m.generalDelivery) {
				case YES:
					System.out.println("Using general delivery for " + m);
					return true;
				default: return false;
				}
			}
		},
		MACHINE_SCAN {
			boolean handle(Mail m) {
				switch(m.scannability) {
				case UNSCANNABLE: return false;
				default:
					switch(m.forwardAddress) {
					case YES: 
						System.out.println("Forwarding " + m + " automatically");
						return true;
					default: 
						switch(m.address) {
						case INCORRECT: return false;
						default:
							System.out.println("Delivering " + m + " automatically");
							return true;
						}
					}						


				}
			}
		},
		FORWARDING {
			boolean handle(Mail m) {
				switch(m.forwardAddress) {
				case YES: 
					System.out.println("Forwarding " + m);
					return true;
				default: return false;

				}
			}
		},
		VISUAL_INSPECTION {
			boolean handle(Mail m) {
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
		},
		RETURN_TO_SENDER {
			boolean handle(Mail m) {
				switch(m.returnAddress) {
				case MISSING: return false;
				default:
					System.out.println("Return " + m + " to sender");
					return true;
				}
			}
		};
		abstract boolean handle(Mail m);
	}
	static void handle(Mail m) {
		for(MailHandler handler : MailHandler.values())
			if(handler.handle(m)) return;
		System.out.println(m + " is a dead letter");
	}
	public static void main(String[] args) {
		for(Mail mail : Mail.generator(20)) {
			System.out.println(mail.details());
			handle(mail);
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
Forwarding Mail 3 automatically
 *****
Mail 4, General Delivery: NO2, Address Scannability: UNSCANNABLE, Address Readability: YES1, ForwardAddress: NO1, Address Address: OK4, Return address: OK2
Delivering Mail 4 normally
 *****
Mail 5, General Delivery: YES, Address Scannability: YES1, Address Readability: ILLEGIBLE, ForwardAddress: YES, Address Address: OK4, Return address: MISSING
Using general delivery for Mail 5
 *****
Mail 6, General Delivery: NO1, Address Scannability: UNSCANNABLE, Address Readability: YES4, ForwardAddress: YES, Address Address: OK3, Return address: OK5
Forwarding Mail 6
 *****
Mail 7, General Delivery: YES, Address Scannability: YES1, Address Readability: YES1, ForwardAddress: NO1, Address Address: OK1, Return address: OK2
Using general delivery for Mail 7
 *****
Mail 8, General Delivery: NO4, Address Scannability: YES1, Address Readability: YES2, ForwardAddress: NO4, Address Address: OK4, Return address: OK5
Delivering Mail 8 automatically
 *****
Mail 9, General Delivery: NO1, Address Scannability: YES2, Address Readability: YES1, ForwardAddress: YES, Address Address: INCORRECT, Return address: OK1
Forwarding Mail 9 automatically
 *****
Mail 10, General Delivery: NO3, Address Scannability: YES2, Address Readability: YES2, ForwardAddress: NO5, Address Address: INCORRECT, Return address: OK2
Return Mail 10 to sender
 *****
Mail 11, General Delivery: NO4, Address Scannability: YES1, Address Readability: YES1, ForwardAddress: NO3, Address Address: INCORRECT, Return address: OK5
Return Mail 11 to sender
 *****
Mail 12, General Delivery: YES, Address Scannability: UNSCANNABLE, Address Readability: YES2, ForwardAddress: NO5, Address Address: OK4, Return address: OK2
Using general delivery for Mail 12
 *****
Mail 13, General Delivery: NO1, Address Scannability: YES2, Address Readability: YES1, ForwardAddress: NO2, Address Address: INCORRECT, Return address: OK4
Return Mail 13 to sender
 *****
Mail 14, General Delivery: NO3, Address Scannability: YES2, Address Readability: YES1, ForwardAddress: YES, Address Address: OK2, Return address: MISSING
Forwarding Mail 14 automatically
 *****
Mail 15, General Delivery: NO1, Address Scannability: UNSCANNABLE, Address Readability: ILLEGIBLE, ForwardAddress: YES, Address Address: OK2, Return address: OK1
Forwarding Mail 15
 *****
Mail 16, General Delivery: NO1, Address Scannability: YES2, Address Readability: YES3, ForwardAddress: NO3, Address Address: OK3, Return address: OK2
Delivering Mail 16 automatically
 *****
Mail 17, General Delivery: NO5, Address Scannability: UNSCANNABLE, Address Readability: ILLEGIBLE, ForwardAddress: NO2, Address Address: OK5, Return address: OK1
Return Mail 17 to sender
 *****
Mail 18, General Delivery: NO3, Address Scannability: UNSCANNABLE, Address Readability: YES2, ForwardAddress: NO4, Address Address: OK2, Return address: OK2
Delivering Mail 18 normally
 *****
Mail 19, General Delivery: NO2, Address Scannability: UNSCANNABLE, Address Readability: ILLEGIBLE, ForwardAddress: NO1, Address Address: OK4, Return address: MISSING
Mail 19 is a dead letter
 *****

 */