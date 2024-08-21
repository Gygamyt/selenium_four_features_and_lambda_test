package geightgeight.seleniumremember.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.apache.logging.log4j.LogManager.getLogger;

public interface ILogger {
    default Logger logger() {
        return getLogger(this.getClass());
    }

    static Logger getStaticLogger(Class<?> clazz) {
        return getLogger(clazz);
    }
}
