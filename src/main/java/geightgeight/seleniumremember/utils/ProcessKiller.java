package geightgeight.seleniumremember.utils;

import geightgeight.seleniumremember.logging.ILogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Вот этот вот киллер процессов был написан по той причине, что после тест рана оставался
 * "хром фор тестинг", который не убивался с помощью простого .quit в afterEach.
 * А можно было бы СРАЗУ проверить версии зависимостей, оставлю в напоминание себе.
 */

public class ProcessKiller implements ILogger {
    private static final List<Long> processIds = new CopyOnWriteArrayList<>();

    private static void addProcessIdToList(long processId) {
        processIds.add(processId);
    }

    private static long getProcessId(String command) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", command);
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("chromedriver") || line.contains("geckodriver") || line.contains("msedgedriver")) {
                    String[] parts = line.trim().split("\\s+");
                    return Long.parseLong(parts[1]);
                }
            }
        }
        return -1;
    }

    public static void killProcessesUsingIds() {
        for (Long processId : processIds) {
            try {
                ProcessHandle.of(processId).ifPresent(processHandle -> {
                    processHandle.destroy();
                    try {
                        processHandle.onExit().get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                        ILogger.getStaticLogger(ProcessKiller.class).error(e.getMessage());
                        ILogger.getStaticLogger(ProcessKiller.class).error("Тут что-то сдохло.");
                    }
                });
            } catch (Exception e) {
                ILogger.getStaticLogger(ProcessKiller.class).error(e.getMessage());
                ILogger.getStaticLogger(ProcessKiller.class).error("Здесь что-то сдохло.");
            }
        }
        processIds.clear();
    }

    public static void saveProcessId(String driverName) {
        try {
            String command = "ps -ef | grep " + driverName;
            long pid = getProcessId(command);
            if (pid > 0) {
                addProcessIdToList(pid);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
