package chapter11practices;

/* Modify Human.java so that the exceptions inherit from 
 * RuntimeException. Modify main() so that the technique
 * in TurnOffChecking.java is used to handle the different
 * types of exceptions.
 */

class Annoyance extends RuntimeException {}
class Sneeze extends Annoyance {}


class WrapCheckedExceptions {
	void throwRuntimeException(int type) {
		try {
			switch(type) {
			case(0): 
				throw new Annoyance();
			case(1): 
				throw new Sneeze();
			case(2): 
				throw new RuntimeException("Where am I?");
			default: return;
			}
		} 	catch(Exception e) { 
			// Adapt to unchecked:
			throw new RuntimeException(e);
		}
	}	
}

public class Ex30 {
	public static void main(String[] args) {
		WrapCheckedExceptions wce = new WrapCheckedExceptions();
		for(int i = 0; i < 3; i++) {
			try {
				if(i < 3) {
					wce.throwRuntimeException(i);
				}
				else {
					throw new RuntimeException();
				}
			}	catch(RuntimeException re) {
				try {
					throw re.getCause();
				} 	catch(Sneeze e) {
					System.out.print("Sneeze: " + e);
				}	catch(Annoyance e) {
					System.out.print("Annoyance: " + e);
				}	catch(Throwable e) {
					System.out.print("Throwable: " + e);
				}
			}		
		}
	}
}
