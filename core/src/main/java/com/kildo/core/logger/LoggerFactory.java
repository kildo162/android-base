package com.kildo.core.logger;

import com.kildo.core.BuildConfig;

public class LoggerFactory {

    public static final String LOG_TAG_DEFAULT = "TAG.APP";

    private LoggerFactory() {
    }

    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz, LOG_TAG_DEFAULT);
    }

    public static Logger getLogger(Class<?> clazz, String tag) {
        return new Logger(System.getProperty("logcat.tag", tag),
            clazz.getSimpleName(), clazz.getName(),
            Boolean.parseBoolean(System.getProperty("logcat.thread", "true")),
            Boolean.parseBoolean(System.getProperty("logcat.lineNumber", String.valueOf(BuildConfig.DEBUG))),
            Boolean.parseBoolean(System.getProperty("logcat.debug", String.valueOf(BuildConfig.DEBUG))));
    }
}
