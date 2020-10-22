package com.company;

import com.company.obtacles.Obstacle;

public class Course {
    private final Obstacle[] obstacles;

    public Course(Obstacle ...obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        team.doIt(obstacles);
    }
}
