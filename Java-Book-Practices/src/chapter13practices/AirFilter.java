package chapter13practices;

class AirFilter extends Filter {
	public static class Factory implements chapter13practices.Factory<AirFilter> {
		public AirFilter create() { return new AirFilter(); }
	}
}