package com.company.obtacles;

import com.company.parcipants.Participant;

public class Wall extends Obstacle {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean doIt(Participant participant) {
        return participant.jump(height);
    }
}
