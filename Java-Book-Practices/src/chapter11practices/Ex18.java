package chapter11practices;

//Add a second level of exception loss to LostMessage.java so that the
//HoHumException is itself replaced by a third exception.

class VeryImportantException extends Exception {
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	public String toString() {
		return "A trivial exception";
	}
}

class MeaninglessException extends Exception {
	public String toString() {
		return "A meaningless exception";
	}
}	

public class Ex18 {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}
	void dispose() throws HoHumException {
		throw new HoHumException();
	}
	void eliminate() throws MeaninglessException {
		throw new MeaninglessException();
	}
	public static void main(String[] args) {
		try {
			Ex18 lm = new Ex18();
			try {
				try {
					lm.f();
					lm.dispose();
				} finally {
					lm.eliminate();
				}
			} catch(Exception e) {
				System.out.println(e);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
