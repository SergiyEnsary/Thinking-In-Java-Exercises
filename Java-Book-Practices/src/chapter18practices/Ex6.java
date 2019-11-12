package chapter18practices;

/* Is there any special benefit in nexting Appetizer, MainCourse, Dessert, and 
 * Coffee inside Food rather than making them standalone enums that just happen
 * to implement Food?
 */

interface Food {}

enum Appetizer implements Food {
	SALAD, SOUP, SPRING_ROLLS;
}
enum MainCourse implements Food {
	LASAGNE, BURRITO, PAD_THAI,
	LENTILS, HUMMOUS, VINDALOO;
}
enum Dessert implements Food {
	TIRAMISU, GELATO, BLACK_FOREST_CAKE,
	FRUIT, CREME_CARAMEL;
}
enum Coffee implements Food {
	BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
	LATTE, CAPPUCCINO, TEA, HERB_TEA;
}

public enum Ex6 {
	APPETIZER(Appetizer.class),
	MAINCOURSE(MainCourse.class),
	DESSERT(Dessert.class),
	COFFEE(Coffee.class);
	private Food[] values;
	private Ex6(Class<? extends Food> kind) {
		values = kind.getEnumConstants();
	}	
	public Food randomSelection() {
		return Enums.random(values);
	}
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			for(Ex6 meal: Ex6.values()) {
				Food food = meal.randomSelection();
				System.out.println(food);
			}
			System.out.println("---");
		}
	}
}

/*Output:

SPRING_ROLLS
VINDALOO
FRUIT
DECAF_COFFEE
---
SOUP
VINDALOO
FRUIT
TEA
---
SALAD
BURRITO
FRUIT
TEA
---
SALAD
BURRITO
CREME_CARAMEL
LATTE
---
SOUP
BURRITO
TIRAMISU
ESPRESSO
---

 */