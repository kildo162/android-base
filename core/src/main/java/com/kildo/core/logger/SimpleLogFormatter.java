package com.kildo.core.logger;

import android.util.Log;

public class SimpleLogFormatter implements LogFormatter {

    public String format(final String pattern, Object... params) {
        int i = 0;

        String format = pattern;
        while (format.contains("{}") && i < params.length) {
            if (null == params[i]) {
                format = format.replaceFirst(BRACKET, "null");
            } else if (isInt(params[i])) {
                format = format.replaceFirst(BRACKET, "%d");
            } else if (isDouble(params[i])) {
                format = format.replaceFirst(BRACKET, "%f");
            } else {
                format = format.replaceFirst(BRACKET, "%s");
            }
            i++;
        }
        return String.format(format, params);
    }

    private boolean isDouble(Object param) {
        return param instanceof Double;
    }

    private boolean isInt(Object param) {
        return param instanceof Long;
    }

    public String getStackTraceString(Throwable t) {
        return Log.getStackTraceString(t);
    }
}
