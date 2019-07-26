package chapter5practices;

import protectedData.ProtectedData;

/*	Chapter 5
 * 	Exercise 4: (2) Show that protected methods have package access
 * 				but are not public
 */
public class Chapter5Exercise04 extends ProtectedData {
	public void save() {saved();}
	public static void main(String[] args) {
		Chapter5Exercise04 data = new Chapter5Exercise04();
        data.save();
	}
}
