package chapter13practices;

class FuelFilter extends Filter {
	// Create a Class Factory for each specific type:
	public static class Factory implements chapter13practices.Factory<FuelFilter> {
		public FuelFilter create() { return new FuelFilter(); }
	}
}