package util;

public interface AppData {
    String charset = "utf-8";
    int threadDefault = 5;

    interface Config {
        interface Input {
            String folder = "/config";
            String config = folder + "/config.json";
        }

        interface Output {
            String folder = "/out";
            String news = folder + "/news.json";
            String wallpaper = folder + "/wallpaper.json";
        }
    }

    interface Database {
        interface MySQL {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://%s/%s?user=%s&password=%s";
        }
    }
}
