package chapter13practices;

class PowerSteeringBelt extends Belt {
	public static class Factory	implements chapter13practices.Factory<PowerSteeringBelt> {
		public PowerSteeringBelt create() {
			return new PowerSteeringBelt();
		}
	}
}