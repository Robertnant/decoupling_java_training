package fr.lernejo.guessgame;

import fr.lernejo.logger.*;

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
            logger.log("Congrats! You found the number!");
            return true;
        }

        if (guess < numberToGuess)
            player.respond(true);
        else
            player.respond(false);

        return false;
    }

    public void loopUntilPlayerSucceed() {
        while (nextRound()) {

        }
    }
}
