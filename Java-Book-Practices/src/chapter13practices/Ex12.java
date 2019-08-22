package chapter13practices;

//Use TypeCounter with the CoffeeGenerator.java class in the Generics chapter.

public class Ex12 {
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Coffee.class);
		for(Coffee coffee : new CoffeeGenerator(20)) {
			System.out.println(coffee.getClass().getSimpleName() + " ");
			counter.count(coffee);
		}
		System.out.println();
		System.out.println(counter);
	}
}

/*Output:

Americano 
Latte 
Americano 
Mocha 
Mocha 
Breve 
Americano 
Latte 
Cappuccino 
Cappuccino 
Americano 
Americano 
Mocha 
Breve 
Breve 
Americano 
Americano 
Mocha 
Latte 
Americano 

{Americano=8, Coffee=20, Cappuccino=2, Latte=3, Mocha=4, Breve=3}

 */