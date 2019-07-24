package practices;

public class Exercise003 {
	public static void main(String[] args) {
		class ATypeName { 
			private String newType = "Class within a class"; 
			public String getNewType() {
				return this.newType;
			}
		}
		ATypeName a = new ATypeName();
		System.out.println(a.getNewType());
	}
}