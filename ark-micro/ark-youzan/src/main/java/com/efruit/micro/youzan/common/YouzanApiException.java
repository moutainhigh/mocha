package com.efruit.micro.youzan.common;

public class YouzanApiException extends Exception {

    private static final long serialVersionUID = 3105246824428283109L;

    public YouzanApiException() {
    }

    public YouzanApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public YouzanApiException(Throwable cause) {
        super(cause);
    }

    public YouzanApiException(String message) {
        super(message);
    }
}
