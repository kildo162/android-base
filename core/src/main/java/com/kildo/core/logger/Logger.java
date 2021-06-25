package com.kildo.core.logger;

import android.util.Log;

public class Logger {
    private final String tag;
    private final String name;
    private final String fullName;
    private final boolean hasThread;
    private final boolean hasLine;
    private final boolean debugEnabled;
    private static final LogFormatter FORMATTER = new SimpleLogFormatter();

    Logger(String tag, String name, String fullName, boolean hasThread, boolean hasLine, boolean debugEnabled) {
        this.tag = tag;
        this.name = name;
        this.fullName = fullName;
        this.hasThread = hasThread;
        this.hasLine = hasLine;
        this.debugEnabled = debugEnabled;
    }

    private String patternWithPrefix(String pattern) {
        int line = 0;
        if (hasLine) {
            StackTraceElement[] st = Thread.currentThread().getStackTrace();
            if (st.length > 4) {
                line = st[4].getLineNumber();
            }
        }
        String lineNumber = hasLine && line > 0 ? ":" + line : "";
        return (hasThread ? "[" + Thread.currentThread().getName() + "] " : "")
            + (name + lineNumber + " ")
            + pattern.replace("%", "%%");// if pattern include %, convert to %%
    }

    public void debug(String pattern, Object... params) {
        if (!debugEnabled) {
            return;
        }
        String msg = FORMATTER.format(patternWithPrefix(pattern), params);
        Log.d(tag, msg);
    }

    public void d(String pattern, Object... params) {
        this.debug(pattern, params);
    }

    public void info(String pattern, Object... params) {
        String msg = FORMATTER.format(patternWithPrefix(pattern), params);
        Log.i(tag, msg);
    }

    public void i(String pattern, Object... params) {
        this.info(pattern, params);
    }

    public void warn(String pattern, Object... params) {
        String msg = FORMATTER.format(patternWithPrefix(pattern), params);
        Log.w(tag, msg);
    }

    public void w(String pattern, Object... params) {
        this.warn(pattern, params);
    }

    public void error(String pattern, Object... params) {
        String msg = FORMATTER.format(patternWithPrefix(pattern), params);
        Log.e(tag, msg);

    }

    public void e(String pattern, Object... params) {
        this.error(pattern, params);
    }

    public void error(String message, Throwable throwable) {
        String msg = FORMATTER.format("%s\n%s", message, FORMATTER.getStackTraceString(throwable));
        Log.e(tag, msg);
    }

    public void e(String message, Throwable throwable) {
        this.error(message, throwable);
    }

    public boolean isDebugEnabled() {
        return false;
    }

}
