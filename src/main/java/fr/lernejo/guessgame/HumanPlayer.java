package fr.lernejo.guessgame;

import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;
import java.util.logging.Logger;

public class HumanPlayer implements Player {
    private final fr.lernejo.logger.Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        logger.log("Enter a number to guess:");
        
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        return scanner.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
            logger.log("Number to find is smaller than current guess");
        else
            logger.log("Number to find is bigger than current guess");
    }
}
