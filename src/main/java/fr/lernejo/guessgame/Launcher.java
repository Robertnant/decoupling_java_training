package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main() {
        Simulation simulation = new Simulation(new HumanPlayer());

        // Generate random number between Long.MIN_VALUE and Long.MAX_VALUE
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextLong();

        simulation.initialize(randomNumber);
        simulation.loopUntilPlayerSucceed();
    }
}
