package chapter18practices;

//Repeat the above (EX 3) for Meal2.java.

public enum Ex4 {
	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCourse.class),
	SECONDCOURSE(Food.SecondCourse.class),
	DESSERT(Food.Dessert.class),
	COFFEE(Food.Coffee.class);
	private Food[] values;
	private Ex4(Class<? extends Food> kind) {
		values = kind.getEnumConstants();
	}
	public interface Food {
		enum Appetizer implements Food {
			SALAD, SOUP, SPRING_ROLLS;
		}
		enum MainCourse implements Food {
			LASAGNE, BURRITO, PAD_THAI,
			LENTILS, HUMMOUS, VINDALOO;
		}
		enum SecondCourse implements Food {
			LEG_OF_LAMB, NEW_YORK_STEAK, 
			MAINE_LOBSTER, ALASKAN_KING_CRAB;
		}
		enum Dessert implements Food {
			TIRAMISU, GELATO, BLACK_FOREST_CAKE,
			FRUIT, CREME_CARAMEL;
		}
		enum Coffee implements Food {
			BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
			LATTE, CAPPUCCINO, TEA, HERB_TEA;
		}
	}
	public Food randomSelection() {
		return Enums.random(values);
	}
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			for(Ex4 meal: Ex4.values()) {
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
MAINE_LOBSTER
GELATO
TEA
---
SPRING_ROLLS
HUMMOUS
NEW_YORK_STEAK
BLACK_FOREST_CAKE
BLACK_COFFEE
---
SALAD
LASAGNE
NEW_YORK_STEAK
CREME_CARAMEL
LATTE
---
SOUP
HUMMOUS
LEG_OF_LAMB
TIRAMISU
ESPRESSO
---
SOUP
LASAGNE
MAINE_LOBSTER
BLACK_FOREST_CAKE
BLACK_COFFEE
---

 */