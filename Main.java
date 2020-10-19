package com.company;

public class Main {

	public static void main(String[] args) {
		Cat[] cats = new Cat[6];
		Bowl bowl = new Bowl(100, 70);

		for (int i = 0; i < cats.length; i++) {
			cats[i] = new Cat("cat " + i);
			feedCat(cats[i], bowl);
		}
	}

	public static void feedCat(Cat cat, Bowl bowl) {
		String fullnessText;

		cat.eat(bowl);
		if (cat.fullness) {
			fullnessText = "сыт";
		} else {
			fullnessText = "голоден";
		}
		System.out.println(cat.getName() + " - " + fullnessText);
	}
}
