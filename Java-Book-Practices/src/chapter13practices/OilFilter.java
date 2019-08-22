package chapter13practices;

class OilFilter extends Filter {
	public static class Factory implements chapter13practices.Factory<OilFilter> {
		public OilFilter create() { return new OilFilter(); }
	}
}