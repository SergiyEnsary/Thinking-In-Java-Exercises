package chapter1practices;
/* Chapter 1
 * Exercise 11: (1) Turn the AllTheColorsOfTheRainbow example into a program that
 *	compiles and runs.
 */
public class Chapter1Exercise11 {
	public static void main(String[] args) {
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
		AllTheColorsOfTheRainbow colors = new AllTheColorsOfTheRainbow();
		colors.populateHues();
	}
}
