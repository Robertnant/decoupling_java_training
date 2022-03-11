package fr.lernejo.guessgame;

import fr.lernejo.logger.*;

import java.security.Timestamp;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long guess = player.askNextGuess();

        if (guess == numberToGuess) {
            return true;
        }

        player.respond(guess > numberToGuess);

        return false;
    }

    public void loopUntilPlayerSucceed(long maxIterations) {
        long start = System.currentTimeMillis();

        do {
            maxIterations -= 1;
        } while (maxIterations > 0 && nextRound() == false);

        if (maxIterations == 0)
            logger.log("Sorry you ran out of tries. Better luck next time...");
        else
            logger.log("Congrats! You found the number!");

        long duration = System.currentTimeMillis() - start;

        long millis = duration % 1000;
        long seconds = (duration / 1000) % 60;
        long minutes = (duration / (1000 * 60)) % 60;

        logger.log(String.format("Time taken: %02d:%02d.%03d", minutes, seconds, millis));
    }
}
