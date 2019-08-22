package chapter13practices;

class GeneratorBelt extends Belt {
	public static class Factory	implements chapter13practices.Factory<GeneratorBelt> {
		public GeneratorBelt create() {
			return new GeneratorBelt();
		}
	}
}