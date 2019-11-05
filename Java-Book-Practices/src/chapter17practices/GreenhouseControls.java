package chapter17practices;

public class GreenhouseControls extends Controller {
	private boolean light = false;

	public class LightOn extends Event {
		LightOn(long delayTime) {
			super(delayTime);
		}

		public void action() {
			light = true;
		}

		public String toString() {
			return "Light is on";
		}
	}

	public class LightOff extends Event {
		LightOff(long delayTime) {
			super(delayTime);
		}

		public void action() {
			light = false;
		}

		public String toString() {
			return "Light is off";
		}
	}

	private boolean water = false;

	public class WaterOn extends Event {
		WaterOn(long delayTime) {
			super(delayTime);
		}

		public void action() {
			water = true;
		}

		public String toString() {
			return "Greenhouse water is on";
		}
	}

	public class WaterOff extends Event {
		WaterOff(long delayTime) {
			super(delayTime);
		}

		public void action() {
			water = false;
		}

		public String toString() {
			return "Greenhouse water is off";
		}
	}

	private String thermostat = "Day";

	public class ThermostatNight extends Event {
		ThermostatNight(long delayTime) {
			super(delayTime);
		}

		public void action() {
			thermostat = "Night";
		}

		public String toString() {
			return "Thermostat on night setting";
		}
	}

	public class ThermostatDay extends Event {
		ThermostatDay(long delayTime) {
			super(delayTime);
		}

		public void action() {
			thermostat = "Day";
		}

		public String toString() {
			return "Thermostat on day setting";
		}
	}

	public class Bell extends Event {
		Bell(long delayTime) {
			super(delayTime);
		}

		public void action() {
			addEvent(new Bell(delayTime));
		}

		public String toString() {
			return "Bing!";
		}
	}

	public class Restart extends Event {
		private Event[] eventList;

		public Restart(long delayTime, Event[] eventList) {
			super(delayTime);
			this.eventList = eventList;
			for (Event e : eventList)
				addEvent(e);
		}

		public void action() {
			for (Event e : eventList) {
				e.start();
				addEvent(e);
			}
			start();
			addEvent(this);
		}

		public String toString() {
			return "Restarting system";
		}
	}

	public static class Terminate extends Event {
		public Terminate(long delayTime) {
			super(delayTime);
		}

		public void action() {
			System.exit(0);
		}

		public String toString() {
			return "Terminating";
		}
	}
}