package chapter13practices;

class Cappuccino extends Coffee {
	public static class Factory implements chapter13practices.Factory<Cappuccino> {
		public Cappuccino create() { return new Cappuccino(); }
	}
}