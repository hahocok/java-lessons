package com.company;

public class Main {

    public static void main(String[] args) {
		Dog dog = new Dog();
		dog.run(150);

		Cat[] cats = new Cat[6];
		int count = 1;
		Bowl bowl = new Bowl(100, 70);

		for (Cat cat : cats) {
			cat = new Cat();
			cat.name = "cat " + count++;
		}

		feedCats(cats, bowl);
    }

    public static void feedCats(Cat[] cats, Bowl bowl) {
		for (Cat cat : cats) {
			cat.eat(bowl);
			if (bowl.food == 0) {
				System.out.println("Еда в тарелке закончилась!");
				fullBowl(bowl);
			}
			System.out.println(cat.fullness);
		}
	}

	private static void fullBowl(Bowl bowl) {
		bowl.food = bowl.volume;
	}
}
