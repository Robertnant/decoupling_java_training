package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        Predicate<String> condition = className -> className == "simulation";

        Logger contextualLogger = new ContextualLogger(name, new ConsoleLogger());
        Logger filteredLogger = new FilteredLogger(new FileLogger("log"), condition);

        return new CompositeLogger(contextualLogger, filteredLogger);
    }
}
