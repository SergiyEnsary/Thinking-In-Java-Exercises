package chapter13practices;

class Americano extends Coffee {
	public static class Factory implements chapter13practices.Factory<Americano> {
		public Americano create() { return new Americano(); }
	}
}