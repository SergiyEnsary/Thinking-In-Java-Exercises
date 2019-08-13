package chapter11practices;

//Repair the problem in LostMessage.java by guarding the call in the
//finally clause.

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

public class Ex19 {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}
	void dispose() throws HoHumException {
		throw new HoHumException();
	}
	public static void main(String[] args) {
		try {
			Ex19 lmf = new Ex19();
			try {
				lmf.f();
			} catch(Exception e) {
				System.out.println(e);
			} finally {
				lmf.dispose();
			}

		} catch(Exception e) {
			System.out.println(e);
		}
	}
}