package geightgeight.seleniumremember.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface ILogger {
    default Logger logger() {
        return LogManager.getLogger(this.getClass());
    }

    static Logger getStaticLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }
}
