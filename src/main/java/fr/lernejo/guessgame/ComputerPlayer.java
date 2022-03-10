package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class ComputerPlayer implements Player {
    private long min_value = Long.MIN_VALUE;
    private long max_value = Long.MAX_VALUE;

    @Override
    public long askNextGuess() {
        // Use binary search to find correct guess
        return (max_value + min_value) / 2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
            max_value = (max_value + min_value) / 2 - 1;
        else
            min_value = (max_value + min_value) / 2 + 1;
    }
}
