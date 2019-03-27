package jobs;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JobsExecutor {

    private static final int HOURS = 0;
    private static final int MINUTES = 1;
    private static final int SECONDS = 0;
    private static long summarySeconds;
    private static ScheduledExecutorService executorService;


    public static void startJobs() {
        long hoursToSeconds = TimeUnit.HOURS.toSeconds(HOURS);
        long minutesToSeconds = TimeUnit.MINUTES.toSeconds(MINUTES);
        long seconds = TimeUnit.SECONDS.toSeconds(SECONDS);

        summarySeconds = hoursToSeconds + minutesToSeconds + seconds;

        executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleWithFixedDelay(new AccountBalanceIncrementorImpl(), 0, summarySeconds, TimeUnit.SECONDS);
    }

    public static void destroy() {
        if (executorService == null || executorService.isShutdown()) {
            return;
        }
        executorService.shutdown();
    }


    public static long getSummarySeconds() {
        return summarySeconds;
    }


}
