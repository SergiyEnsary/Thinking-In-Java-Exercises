package practices;

public class Exercise004 {
	public static void main(String[] args) {
		class DataOnly {
			int i;
			double d;
			boolean b;
		}
		DataOnly data = new DataOnly();
		data.i = 200;
		data.d = 0.20;
		data.b = false;
		System.out.println(data.i*data.d);
	}
}