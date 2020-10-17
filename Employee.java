package com.company;

public class Employee {
    public String fio;
    public String position;
    public String email;
    public String phone;
    public int salary;
    public int age;

    public Employee(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("fio: " + fio + ", " +
                "position: " + position + ", " +
                "email: " + email + ", " +
                "phone: " + phone + ", " +
                "salary: " + salary + ", " +
                "age: " + age);
    }
}
