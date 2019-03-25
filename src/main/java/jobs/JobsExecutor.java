package jobs;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JobsExecutor {

    private static final int HOURS = 0;
    private static final int MINUTES = 5;
    private static final int SECONDS = 0;
    public static long summarySeconds;

    public static void startJobs() {
        long hoursToSeconds = TimeUnit.HOURS.toSeconds(HOURS);
        long minutesToSeconds = TimeUnit.MINUTES.toSeconds(MINUTES);
        long seconds = TimeUnit.SECONDS.toSeconds(SECONDS);

        summarySeconds = hoursToSeconds + minutesToSeconds + seconds;

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.schedule(new AccountBalanceIncrementorImpl(), summarySeconds, TimeUnit.SECONDS);
    }
}
