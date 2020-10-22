package com.company.obtacles;

import com.company.parcipants.Participant;

public class Cross extends Obstacle {
    private final int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public boolean doIt(Participant participant) {
        if (participant == null) {
            return false;
        }
        return participant.run(length);
    }
}
