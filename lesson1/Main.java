package com.company;

import com.company.obtacles.Cross;
import com.company.obtacles.Wall;
import com.company.parcipants.Human;

public class Main {

    public static void main(String[] args) {
        Course c = new Course(                                  // создаем полосу препятствий
                new Cross(40),
                new Wall(20),
                new Cross(30));
        Team team = new Team(                                    // создаем команду
                "Динамо",
                new Human("Human 1"),
                new Human("Human 2"),
                new Human("Human 3"),
                new Human("Human 4"));
        team.showInfoAllMembers();
        c.doIt(team);                                             // просим команду пройти полосу
        team.showResults();                                       // показываем результат
    }
}
