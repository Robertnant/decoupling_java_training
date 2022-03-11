package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Missing argument: -interactive or -auto");
        }

        Simulation simulation = null;
        long maxIterations = Long.MAX_VALUE;

        if (args[0] == "-interactive") {
            simulation = new Simulation(new HumanPlayer());

            // Generate random number between Long.MIN_VALUE and Long.MAX_VALUE
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextLong();

            simulation.initialize(randomNumber);
        }
        else if (args[0] == "-auto") {
            if (args.length != 2) {
                throw new IllegalArgumentException("No number to guess was given in -auto mode");
            }

            simulation = new Simulation(new ComputerPlayer());
            maxIterations = 1000;
            simulation.initialize(Long.parseLong(args[1]));
        }
        else {
            throw new IllegalArgumentException("Invalid mode: " + args[0]);
        }

        simulation.loopUntilPlayerSucceed(maxIterations);
    }
}
