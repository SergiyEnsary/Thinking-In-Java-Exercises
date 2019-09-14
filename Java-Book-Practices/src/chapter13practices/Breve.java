package chapter13practices;

public class Breve extends Coffee {
	public static class Factory implements chapter13practices.Factory<Breve> {
		public Breve create() { return new Breve(); }
	}
}