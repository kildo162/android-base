package com.kildo.core.logger;

public interface LogFormatter {
    String BRACKET = "\\{\\}";

    String format(final String pattern, Object... params);

    String getStackTraceString(Throwable e);

}
