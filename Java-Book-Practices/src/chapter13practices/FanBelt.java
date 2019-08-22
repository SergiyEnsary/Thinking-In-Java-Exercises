package chapter13practices;

class FanBelt extends Belt {
	public static class Factory implements chapter13practices.Factory<FanBelt> {
		public FanBelt create() { return new FanBelt(); }
	}
}