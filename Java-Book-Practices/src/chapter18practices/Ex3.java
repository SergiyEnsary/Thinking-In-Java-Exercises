package chapter18practices;

//Add a new Course to Course.java and demonstrate that it works in Meal.java.

enum Course3 {
	APPETIZER(Food3.Appetizer.class),
	MAINCOURSE(Food3.MainCourse.class),
	SECONDCOURSE(Food3.SecondCourse.class),
	DESSERT(Food3.Dessert.class),
	COFFEE(Food3.Coffee.class);
	private Food3[] values;
	private Course3(Class<? extends Food3> kind) {
		values = kind.getEnumConstants();
	}
	public Food3 randomSelection() {
		return Enums.random(values);
	}
}

interface Food3 {
	enum Appetizer implements Food3 {
		SALAD, SOUP, SPRING_ROLLS;
	}
	enum MainCourse implements Food3 {
		LASAGNE, BURRITO, PAD_THAI,
		LENTILS, HUMMOUS, VINDALOO;
	}
	enum SecondCourse implements Food3 {
		LEG_OF_LAMB, NEW_YORK_STEAK, 
		MAINE_LOBSTER, ALASKAN_KING_CRAB;
	}
	enum Dessert implements Food3 {
		TIRAMISU, GELATO, BLACK_FOREST_CAKE,
		FRUIT, CREME_CARAMEL;
	}
	enum Coffee implements Food3 {
		BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
		LATTE, CAPPUCCINO, TEA, HERB_TEA;
	}
}

public class Ex3 {
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			for(Course3 course : Course3.values()) {
				Food3 food = course.randomSelection();
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