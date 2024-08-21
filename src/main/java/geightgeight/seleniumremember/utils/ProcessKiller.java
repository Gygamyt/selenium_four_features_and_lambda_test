package geightgeight.seleniumremember.utils;

import geightgeight.seleniumremember.logging.ILogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            // Pattern to match the process ID
            Pattern pattern = Pattern.compile("(\\d+)");
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    return Long.parseLong(matcher.group(1));
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
                        ILogger.getStaticLogger(ProcessKiller.class).error("Failed to wait for process exit: {}", e.getMessage());
                    }
                });
            } catch (Exception e) {
                ILogger.getStaticLogger(ProcessKiller.class).error("Error handling process ID {}: {}", processId, e.getMessage());
            }
        }
        processIds.clear();
    }

    public static void saveProcessId(String driverName) {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            String command;

            if (os.contains("win")) {
                command = "cmd /c tasklist | findstr " + driverName;
            } else {
                command = "ps -e | grep " + driverName;
            }

            long pid = getProcessId(command);
            if (pid > 0) {
                addProcessIdToList(pid);
            }
        } catch (IOException e) {
            ILogger.getStaticLogger(ProcessKiller.class).error("Failed to retrieve process ID: {}", e.getMessage());
        }
    }
}