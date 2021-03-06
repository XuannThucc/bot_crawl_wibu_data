package bot;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import util.AppData;
import util.AppSql;
import util.AppStorage;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BaseBot {
    protected boolean isRunning;
    protected long lastRun;
    protected long restTime;
    protected Random random;
    protected AppStorage appStorage;
    protected Gson gson;
    protected OkHttpClient client;
    protected ExecutorService executor;

    public BaseBot(int maxThread, long restTime) {
        this.isRunning = false;
        this.restTime = restTime;
        this.lastRun = 0;
        this.random = new Random();
        this.appStorage = AppStorage.getInstance();
        this.gson = new Gson();
        this.client = new OkHttpClient();
        this.executor = Executors.newFixedThreadPool(Math.max(maxThread, AppData.threadDefault));
    }

    public void run() {
        isRunning = true;
    }

    public void complete() {
        isRunning = false;
        lastRun = System.currentTimeMillis();
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean isNeedRun(long now) {
        return (!isRunning && (lastRun + restTime < now));
    }
}
