package com.company;

import com.company.obtacles.Obstacle;
import com.company.parcipants.Participant;

public class Team {
    private final String name;
    private Participant[] participants;

    public Team(String name, Participant ...participants) {
        this.name = name;
        this.participants = participants;
    }

    public void doIt(Obstacle[] obstacles) {
        if (obstacles != null && obstacles.length > 0) {
            for (Participant participant : participants) {
                if (participant != null) {
                    int countFinishingObstacles = 0;
                    for (Obstacle obstacle : obstacles) {
                        if (obstacle != null) {
                            if (obstacle.doIt(participant)) {
                                countFinishingObstacles++;
                            } else {
                                break;
                            }
                        }
                    }
                    if (countFinishingObstacles == obstacles.length) participant.setFinish();
                }
                System.out.println("--------------------");
            }
        }
    }

    public void showInfoAllMembers() {
        System.out.println("Состав команды " + name + ":");
        if (participants != null && participants.length > 0) {
            for (Participant participant : participants) {
                participant.info();
            }
            System.out.println("--------------------");
        }
    }

    public void showResults() {
        if (participants != null && participants.length > 0) {
            for (Participant participant : participants) {
                if (participant != null && participant.isFinish()) participant.results();
            }
        }
    }
}
