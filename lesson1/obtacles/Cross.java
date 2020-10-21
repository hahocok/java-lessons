package com.company.obtacles;

import com.company.parcipants.Participant;

public class Cross extends Obstacle {
    private final int length;

    public Cross(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean doIt(Participant participant) {
        return participant.run(length);
    }
}
