package outsidePackage;

public class Connection {

	private Connection() {}

	public static Connection get() {
		return new Connection();
	}
	
}