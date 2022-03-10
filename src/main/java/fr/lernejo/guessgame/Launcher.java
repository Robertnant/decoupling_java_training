package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
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
            simulation = new Simulation(new ComputerPlayer());
            maxIterations = 1000;
            simulation.initialize(Long.parseLong(args[1]));
        }
        else {
            System.out.println("Option passed was not recognized. Try one of these two: -interactive or -auto");
        }

        simulation.loopUntilPlayerSucceed(maxIterations);
    }
}
