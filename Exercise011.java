package practices;

public class Exercise011 {
	class AllTheColorsOfTheRainbow {
		String[] hues = new String[3];
		int anIntegerRepresentingColors;
		void changeTheHueOfTheColor(int newHue) {
			// changes the hue through a value
			this.anIntegerRepresentingColors = newHue;
		}
		void populateHues() {
			this.hues[0] = "Red";
			this.hues[1] = "Blue";
			this.hues[2] = "Green";
		}
	}
}