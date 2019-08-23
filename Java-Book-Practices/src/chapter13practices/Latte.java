package chapter13practices;

class Latte extends Coffee {
	public static class Factory implements chapter13practices.Factory<Latte> {
		public Latte create() { return new Latte(); }
	}
}