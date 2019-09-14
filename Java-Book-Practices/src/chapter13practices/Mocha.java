package chapter13practices;

public class Mocha extends Coffee {
	public static class Factory implements chapter13practices.Factory<Mocha> {
		public Mocha create() { return new Mocha(); }
	}
}