package chapter13practices;

class CabinAirFilter extends Filter {
	public static class Factory implements chapter13practices.Factory<CabinAirFilter> {
		public CabinAirFilter create() {
			return new CabinAirFilter();
		}
	}
}