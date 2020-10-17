package com.company;

public class Main {

    public static void main(String[] args) {
    	/*
		Employee[] employees = new Employee[5];

		employees[0] = new Employee("Ivanov Ivan", "Engineer", "iviivan@mail.com", "89991112300", 30000, 30);
		employees[1] = new Employee("Sergeev Sergey", "Engineer", "sergey@mail.com", "89991843745", 32000, 25);
		employees[2] = new Employee("Dmitriev Dmitriy", "Engineer", "dmitriy@mail.com", "89993294615", 35000, 33);
		employees[3] = new Employee("Pavlov Pavel", "Engineer", "pavel@mail.com", "89992513648", 33000, 41);
		employees[4] = new Employee("Petrov Petr", "Engineer", "petr@mail.com", "89997267669", 31000, 40);

		for (Employee employee : employees) {
			if (employee.age > 40) employee.printInfo();
		}

		Dog dog = new Dog();
		dog.run(150);

    	 */

		//----------------------------- test -------------------

		int[][] arr = new int[8][2];

		int x = 1;
		int y = 1;

		for (int i = 0; i < arr.length; i++) {
			//int[] a = {(int)(Math.random()*10), (int)(Math.random()*10)};
			int[] a = {x, y};
			arr[i][0] = a[0];
			//arr[i][1] = a[1];
			x++;
			y++;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
    }
}
