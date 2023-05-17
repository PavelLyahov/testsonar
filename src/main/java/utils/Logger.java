package utils;

public final class Logger {
    private static ThreadLocal<org.apache.log4j.Logger> log4J = ThreadLocal.withInitial(()
            -> org.apache.log4j.Logger.getLogger(String.valueOf(Thread.currentThread().getId())));
    private static ThreadLocal<Logger> instance = ThreadLocal.withInitial(Logger::new);

    private Logger() {
    }

    public static Logger getInstance() {
        return instance.get();
    }

    public void info(String message) {
        log4J.get().info(message);
    }

    public void warn(String message) {
        log4J.get().warn(message);
    }

    public void error(String message) {
        log4J.get().error(message);
    }

    public void fatal(final String message, Throwable throwable) {
        log4J.get().fatal(String.format("%s: %s", message, throwable.toString()));
    }

    public void info(String key, Object... params) {
        log4J.get().info(String.format(key, params));
    }

    public void debug(String key, Object... params) {
        log4J.get().debug(String.format(key, params));
    }
}
