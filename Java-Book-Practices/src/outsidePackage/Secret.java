package outsidePackage;

class Secret implements A {
	public void e() { System.out.println("public Secret.e()"); } 
	void f() { System.out.println("package Secret.f()"); }
	protected void g() { System.out.println("protected Secret.g()"); }
	private void h() { System.out.println("private Secret.h()"); }
}